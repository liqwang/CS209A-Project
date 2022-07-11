package edu.sustech.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sustech.backend.entities.DependencyData;
import edu.sustech.backend.service.models.BarChartItem;
import edu.sustech.backend.service.models.QueryItem;
import edu.sustech.backend.service.models.ReactiveMapEntry;
import edu.sustech.backend.util.Util;
import edu.sustech.search.engine.github.models.Dependency;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.ZoneId;
import java.util.*;

@Service
public class BackendServiceImpl implements BackendService {
    private static final long LOCAL_SEARCH_UPDATE_INTERVAL_MILLIS = 15000;
    private static final long LOCAL_ITEM_UPDATE_INTERVAL_MILLIS = 400;
    private static final long LOCAL_MINOR_UPDATE_INTERVAL_MILLIS = 200;

    private static final HashMap<String, String> COUNTRY_MAP = new HashMap<>();

    static {
        //May have bug because of Git
        String[] countries = Util.readFile("data/country.txt").split("\\r\\n\\r\\n");
        for (String country : countries) {
            String[] locations = country.split("\\r\\n");
            String countryCode = locations[0];
            for (int i = 1; i < locations.length; i++) {
                COUNTRY_MAP.put(locations[i], countryCode);
            }
        }
    }

    private final Logger logger = LogManager.getLogger(BackendServiceImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
//    private final GitHubAPI gitHubAPI = GitHubAPI.registerAPI("xxx");//the GitHub token
//    {
//        gitHubAPI.searchAPI.setSuppressRateError(true);
//    }

    private static DependencyData dependencyData;

    private final HashMap<String, Integer> springHeatMap = new HashMap<>();
    private final HashMap<String, Integer> lombokHeatMap = new HashMap<>();
    private final HashMap<String, Integer> log4jHeatMap = new HashMap<>();
    private final HashMap<String, Integer> mysqlHeatMap = new HashMap<>();

    {
        initMaps();
    }

    public void initMaps() {
        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dependencyData != null) {
            loadDependencyHeatMap("org.springframework");
            loadDependencyHeatMap("org.projectlombok");
            loadDependencyHeatMap("log4j");
            loadDependencyHeatMap("mysql");
            return;
        }
        logger.error("Map dependency data loaded complete.");
    }

    @Override
    public List<ReactiveMapEntry> loadDependencyHeatMapImpl(String dependency) {
        List<ReactiveMapEntry> prefetchedData = null;
        String resultPrefetchedData = switch (dependency) {
            case "org.springframework" -> "spring";
            case "org.projectlombok" -> "lombok";
            case "log4j" -> "log4j";
            case "mysql" -> "mysql";
            default -> null;
        };
        try {
            prefetchedData = objectMapper.readValue(Util.readFile("data/DependencyAnalysis/heatmapData/" + resultPrefetchedData + ".json"), new TypeReference<>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prefetchedData;
    }

    @Override
    public void loadDependencyHeatMap(String dependency) {
        HashMap<String, Integer> targetHeatMap = switch (dependency) {
            case "org.springframework" -> springHeatMap;
            case "org.projectlombok" -> lombokHeatMap;
            case "log4j" -> log4jHeatMap;
            case "mysql" -> mysqlHeatMap;
            default -> null;
        };
        if (targetHeatMap == null) {
            return;
        }
        dependencyData.getData().forEach(repo -> {
            //1加载dependency热力图数据
            logger.debug("Loading " + dependency + " heat map...");
            //1.1计算该仓库中dependency依赖的数量
            List<Dependency> dependencies = repo.getValue().getValue();
            int dependencyCount = (int) dependencies.stream().filter(dep -> dep.groupId().startsWith(dependency)).count();

            //1.2加入该仓库中的国家使用dependency的数量
            List<User> users = repo.getValue().getKey();
            for (User user : users) {
                String location = user.getLocation();
                for (String key : COUNTRY_MAP.keySet()) {
                    String countryCode = COUNTRY_MAP.get(key);
                    if (location != null && location.contains(key)) {
                        targetHeatMap.put(countryCode, targetHeatMap.getOrDefault(countryCode, 0) + dependencyCount);
                        break;
                    }
                }
            }
            logger.debug("Successfully loaded " + dependency + " heat map.");
        });
    }

    @Override
    public Map<String, Integer> getSpringData() {
        return springHeatMap;
    }

    public Map<String, Integer> getLombokData() {
        return lombokHeatMap;
    }

    public Map<String, Integer> getLog4jData() {
        return log4jHeatMap;
    }

    public Map<String, Integer> getMysqlData() {
        return mysqlHeatMap;
    }

    private List<QueryItem> requestQueryList;

    {
        readLocalQueryStatus();
    }

//    @Override
//    public void updateLocalData() throws IOException, InterruptedException {
//        logger.info("Updating local data.");
//
//        //Update Dependency Analysis Result
//        RepoSearchRequest req3 = RepoSearchRequest.newBuilder()
//                .addLanguageOption("java")
//                .setSorted(RepoSearchRequest.Sort.Stars)
//        updateLocalDependencyData();
//        updateLocalLog4jIPRData();
//    }

    @Override
    @Async
    public void readLocalData() throws IOException {
        dependencyData = readLocalDependencyData();
        initMaps();
//        readLocalLog4jIPRData();
    }

//    @Override
//    public void updateLocalLog4jIPRData() throws IOException, InterruptedException {
//        logger.info("Updating local log4j issues and pull requests data");
//
//        IPRSearchRequest req = IPRSearchRequest.newBuilder()
//                .addSearchKeyword("log4j")
//                .build();
//
//        List<HttpResponse<String>> result = gitHubAPI.searchAPI.searchRawLoop(req, 3000, LOCAL_SEARCH_UPDATE_INTERVAL_MILLIS);
////        if (result != null) {
////            for (Issue i : result) {
////                log4jIssues.add(i);
////            }
////        }
//
//        objectMapper.writeValue(new File("backend/data/Log4jIssueAnalysis/log4jiprdata.json"), log4jIssues);
//        logger.info("Updated local log4j issues and pull requests data");
//    }

    @Override
    public DependencyData getDependencyData() {
        return dependencyData;
    }

    @Override
    public String getDependencyUsageWithLocation() {
        /*
          String for artifactId
          List of String for locations
         */
        HashMap<String, List<String>> locationMap = new HashMap<>();
        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dependencyData != null) {
            try {
                return objectMapper.writeValueAsString(locationMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Internal parsing failure.";
    }

    @Override
    public String getTopUsedDependencies(@Nullable String group, @Nullable Integer year, @Nullable Integer dataCount) {
        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dependencyData != null) {
            HashMap<String, Integer> dependencyMap = new HashMap<>() {{
                dependencyData.getData().forEach(e -> {
                    Repository repo = e.getKey();
                    if (year != null && !(repo.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).getYear() == year)) {
                        return;
                    }
                    e.getValue().getValue().stream().filter(d -> {
                                if (group != null) {
                                    return d.groupId().equals(group);
                                }
                                return true;
                            })
                            .forEach(d -> put(d.artifactId(), getOrDefault(d.artifactId(), 0) + 1));

                });
            }};

            List<BarChartItem<String, Integer>> result = new ArrayList<>();

            dependencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(dataCount == null ? 10 : dataCount)
                    .forEach(e -> result.add(new BarChartItem<>(e.getKey(), e.getValue())));
            try {
                return objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Internal parsing failure.";
    }

    @Override
    public String getTopUsedVersions(@Nullable String group, @Nullable String artifact, @Nullable Integer year, @Nullable Integer dataCount) {
        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dependencyData != null) {
            HashMap<String, Integer> versionMap = new HashMap<>() {{
                dependencyData.getData().forEach(e -> {
                    Repository repo = e.getKey();
                    if (year != null && !(repo.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).getYear() == year)) {
                        return;
                    }
                    e.getValue().getValue().stream().filter(d -> {
                                if (group != null) {
                                    return d.groupId().equals(group);
                                }
                                return true;
                            }).filter(d -> {
                                if (artifact != null) {
                                    return d.groupId().equals(artifact);
                                }
                                return true;
                            })
                            .forEach(d -> put(d.version(), getOrDefault(d.version(), 0) + 1));
                });
            }};

            List<BarChartItem<String, Integer>> result = new ArrayList<>();

            versionMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(dataCount == null ? 10 : dataCount)
                    .forEach(e -> result.add(new BarChartItem<>(e.getKey() == null ? "<null>" : e.getKey(), e.getValue())));
            try {
                return objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Internal parsing failure";
    }

    @Override
    public String getAvailableGroupSelections() {
        HashSet<String> groupList = new HashSet<>();
        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dependencyData != null) {
            dependencyData.getData().forEach(e -> {
                List<Dependency> list = e.getValue().getValue();
                for (Dependency d : list) {
                    groupList.add(d.groupId());
                }
            });
        }
        try {
            return objectMapper.writeValueAsString(groupList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Internal parsing failure.";
    }

    @Override
    public String getAvailableDependencySelections() {
        HashSet<String> dependencyList = new HashSet<>();
        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dependencyData != null) {
            dependencyData.getData().forEach(e -> {
                List<Dependency> list = e.getValue().getValue();
                for (Dependency d : list) {
                    dependencyList.add(d.artifactId());
                }
            });
        }
        try {
            return objectMapper.writeValueAsString(dependencyList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Internal parsing failure";
    }

    @Override
    public DependencyData readLocalDependencyData() throws IOException {
        logger.info("Reading local dependency data");
        DependencyData data = new DependencyData();
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(null).getResources("classpath:data/DependencyAnalysis/Entries/*.json");
        for (Resource resource : resources) {
            String json = Util.readInputStream(resource.getInputStream());
            Entry<Repository, Entry<List<User>, List<Dependency>>> entry = objectMapper.readValue(json,new TypeReference<>(){});
            data.getData().add(entry);
        }
        logger.info("Loaded " + data.getData().size() + " entries.");
        return data;
    }

//    @Override
//    public void updateLocalDependencyData() throws IOException, InterruptedException {
//        updateLocalDependencyData(1000);
//    }
//
//    @Override
//    public void updateLocalDependencyData(int count) throws IOException, InterruptedException {
//        logger.info("Updating local dependency data");
//
//        CodeSearchRequest req1 = CodeSearchRequest.newBuilder()
//                .addSearchKeyword("dependency")
//                .addSearchField(CodeSearchRequest.SearchBy.Filename, "pom.xml")
//                .addLanguageOption("Maven POM")
//                .build();
//
//        CodeResult result1 = gitHubAPI.searchAPI.searchCode(req1, count, LOCAL_SEARCH_UPDATE_INTERVAL_MILLIS);
////        CodeResult result1 = objectMapper.readValue(Files.readString(Path.of("backend/data/DependencyAnalysis/DependencySearchResult.json")), CodeResult.class);
//
//        appendNewQueryStatus(new QueryItem("Query Request: " + req1.getFullRequestStringWithoutPage(),
//                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                "GitHub",
//                "progress"));
//
//        DependencyData data = new DependencyData();
//
//        File file = new File("backend/data/DependencyAnalysis/Entries/");
//        if (!file.exists()) {
//            if (!file.mkdirs()) {
//                throw new IOException("Failed to create Entries directory");
//            }
//        }
//
//        int cnt = 0;
//        int fileNameCnt = dependencyData.getData().size();
//        for (CodeItem item : result1.getItems()) {
////        for (int i = cnt; i < result1.getItems().size(); i++) {
////            CodeItem item = result1.getItems().get(i);
//            logger.info("Acquiring item " + (++cnt) + " on BackendService");
//            Repository r = item.getRepository();
//
//            if (r.getStargazersCount() < 50) {
//                continue;
//            }
//
//            r = gitHubAPI.repositoryAPI.getRepository(r.getUrl());
//
//            List<Dependency> ls = new ArrayList<>();
//            try {
//                List<Dependency> res = Analyzer.parseDependency(gitHubAPI.fileAPI.getFileRaw(item.getRawFileURI()));
//                if (res != null) {
//                    ls = res;
//                    logger.info("Acquired " + ls.size() + " dependencies");
//                }
//            } catch (Exception e) {
//                logger.error("Error encountered during parsing, ", e);
//            } finally {
//                Thread.sleep(LOCAL_ITEM_UPDATE_INTERVAL_MILLIS);
//            }
//
//            List<User> userList = new ArrayList<>();
//            try {
//                userList = gitHubAPI.repositoryAPI.getContributors(r);
//            } catch (Exception e) {
//                logger.error("Error encountered during parsing, ", e);
//            } finally {
//                Thread.sleep(LOCAL_ITEM_UPDATE_INTERVAL_MILLIS);
//            }
//            if (userList != null) {
//                logger.info("Updating " + userList.size() + " users");
//                for (User user : userList) {
//                    User rep = gitHubAPI.userAPI.getUser(user.getUrl());
//                    user.setLocation(rep.getLocation());
//                    Thread.sleep(LOCAL_MINOR_UPDATE_INTERVAL_MILLIS);
//                }
//            }
//            Entry<Repository, Entry<List<User>, List<Dependency>>> entry = new Entry<>(r, new Entry<>(userList, ls));
//            data.getData().add(entry);
//
//            objectMapper.writeValue(new File("backend/data/DependencyAnalysis/Entries/DependencyDataEntry_" + (fileNameCnt++) + ".json"), entry);
//
//        }
//        dependencyData = data;
//        overwriteLastQueryStatus(new QueryItem("Query Request: " + req1.getFullRequestStringWithoutPage(),
//                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                "GitHub",
//                "completed"));
//        logger.info("Updated local dependency data");
//    }

    @Override
    public Integer getSampledEntries() {
        return dependencyData.getData().size();
    }

    @Override
    public Integer getRequestCount() {
        return requestQueryList.size();
    }

    @Override
    public Integer getSampleSize() {
        return dependencyData.getData().stream().mapToInt(value -> 1 + value.getValue().getValue().size() + value.getValue().getKey().size()).sum();
    }

    @Override
    public void appendNewQueryStatus(QueryItem item) {
        requestQueryList.add(item);
        try {
            objectMapper.writeValue(new FileOutputStream("backend/data/status/QueryStatus.status"), requestQueryList);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void overwriteLastQueryStatus(QueryItem item) {
        requestQueryList.set(requestQueryList.size() - 1, item);
        try {
            objectMapper.writeValue(new FileOutputStream("backend/data/status/QueryStatus.status"), requestQueryList);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<QueryItem> readQueryStatus() {
        return requestQueryList;
    }

    @Override
    public void readLocalQueryStatus() {
        logger.info("Reading local query status history");
        try {
            requestQueryList = objectMapper.readValue(Util.readFile("data/status/QueryStatus.status"), new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        logger.info("Successfully loaded local query status history");
    }

    @Override
    public void testWrite() throws FileNotFoundException {
        logger.info("The current backend file location is " + new File("").getAbsolutePath());
        PrintWriter pw = new PrintWriter("backend/data/test.json");
        pw.write("Test write ok.");
        pw.close();
        logger.info("Test write ok.");
    }
}
