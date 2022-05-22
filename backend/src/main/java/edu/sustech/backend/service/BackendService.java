package edu.sustech.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sustech.backend.dto.DependencyData;
import edu.sustech.backend.service.models.BarChartItem;
import edu.sustech.search.engine.github.API.GitHubAPI;
import edu.sustech.search.engine.github.API.search.requests.CodeSearchRequest;
import edu.sustech.search.engine.github.API.search.requests.IPRSearchRequest;
import edu.sustech.search.engine.github.analyzer.Analyzer;
import edu.sustech.search.engine.github.models.Dependency;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.code.CodeItem;
import edu.sustech.search.engine.github.models.code.CodeResult;
import edu.sustech.search.engine.github.models.issue.IPRResult;
import edu.sustech.search.engine.github.models.issue.Issue;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Service
public class BackendService {
    private static final int LOCAL_MAJOR_UPDATE_INTERVAL_MILLIS = 15000;
    private static final int LOCAL_ITEM_UPDATE_INTERVAL_MILLIS = 1000;

    private final Logger logger = LogManager.getLogger(BackendService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");
    {gitHubAPI.searchAPI.setSuppressRateError(true);}


    public void updateLocalData() throws IOException, InterruptedException {
        logger.info("Updating local data.");

        //Update Dependency Analysis Result
//        RepoSearchRequest req3 = RepoSearchRequest.newBuilder()
//                .addLanguageOption("java")
//                .setSorted(RepoSearchRequest.Sort.Stars)
        updateLocalDependencyData();
        updateLocalLog4jIPRData();
    }


    private List<Issue> log4jIssues;

    //todo: add a method to acquire the data for charts.

    public IPRResult readLocalLog4jIPRData() throws IOException {
        logger.info("Reading local log4j issues and pull requests data");
        return objectMapper.readValue(new File("data/Log4jIssueAnalysis/Entries/log4jiprdata.json"), IPRResult.class);
    }

    public void updateLocalLog4jIPRData() throws IOException, InterruptedException {
        logger.info("Updating local log4j issues and pull requests data");

        IPRSearchRequest req = IPRSearchRequest.newBuilder()
                .addSearchKeyword("log4j")
                .build();

        IPRResult result = gitHubAPI.searchAPI.searchIPR(req, 3000, LOCAL_MAJOR_UPDATE_INTERVAL_MILLIS);
        if (result != null) {
            for (Issue i : result) {
                log4jIssues.add(i);
            }
        }

        PrintWriter pw = new PrintWriter("data/Log4jIssueAnalysis/Entries/log4jiprdata.json");
        pw.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(log4jIssues));
        pw.close();
        logger.info("Updated local log4j issues and pull requests data");
    }

    /**
     * For storing the dependency data acquired.
     */
    private static DependencyData dependencyData;

    public DependencyData getDependencyData() {
        return dependencyData;
    }

    public String getDependencyUsageWithLocation() {
        /**
         * String for artifactId
         * List of String for locations
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
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(locationMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Internal parsing failure.";
    }

    public String getTopUsedDependencies() {

        if (dependencyData == null) {
            try {
                dependencyData = readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (dependencyData != null) {
            HashMap<String, Integer> dependencyMap = new HashMap<>();

            dependencyData.getData().stream().forEach(e -> {
                List<Dependency> list = e.getValue().getValue();
                for (Dependency d : list) {
                    Integer cnt = dependencyMap.get(d.artifactId());
                    if (cnt == null) {
                        dependencyMap.put(d.artifactId(), 1);
                    } else {
                        dependencyMap.put(d.artifactId(), ++cnt);
                    }
                }
            });

            List<BarChartItem<String, Integer>> result = new ArrayList<>();

            dependencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(e -> {
                        result.add(new BarChartItem<>(e.getKey(), e.getValue()));
                    });
            try {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Internal parsing failure.";
    }

    //todo: give ranking options for top used dependencies

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
            dependencyData.getData().stream().forEach(e -> {
                List<Dependency> list = e.getValue().getValue();
                for (Dependency d : list) {
                    groupList.add(d.groupId());
                }
            });

        }
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Internal parsing failure.";
    }

    //todo: finish this

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
            dependencyData.getData().stream().forEach(e -> {
                List<Dependency> list = e.getValue().getValue();
                for (Dependency d : list) {
                    dependencyList.add(d.artifactId());
                }
            });

        }
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dependencyList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Internal parsing failure";
    }

    public DependencyData readLocalDependencyData() throws IOException {
        logger.info("Reading local dependency data");
        DependencyData data = new DependencyData();
        File dir = new File("data/DependencyAnalysis/Entries");
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                String fileName = f.getName();
                if (fileName.contains("DependencyDataEntry")) {
                    Entry<Repository, Entry<List<User>, List<Dependency>>> entry = null;
                    try {
                        entry = objectMapper.readValue(f, new TypeReference<>() {
                        });
                    } catch (JsonProcessingException e) {
                        logger.error(e);
                    }
                    if (entry != null) {
                        data.getData().add(entry);
                    }
                }
            }
        }
        return data;
    }

    public void updateLocalDependencyData() throws IOException, InterruptedException {
        updateLocalDependencyData(1000);
    }

    public void updateLocalDependencyData(int count) throws IOException, InterruptedException {
        logger.info("Updating local dependency data");

        CodeSearchRequest req1 = CodeSearchRequest.newBuilder()
                .addSearchField(CodeSearchRequest.SearchBy.Filename, "pom.xml")
                .addLanguageOption("Maven POM")
                .build();

        CodeResult result1 = gitHubAPI.searchAPI.searchCode(req1, count, LOCAL_MAJOR_UPDATE_INTERVAL_MILLIS);

        DependencyData data = new DependencyData();

        File file = new File("data/DependencyAnalysis/Entries/");
        if(!file.exists()){
            if(!file.mkdirs()){
                throw new IOException("Failed to create Entries directory");
            }
        }

        int cnt = 0;
        for (CodeItem item : result1) {
            Repository r = item.getRepository();

            List<Dependency> ls = null;
            try {
                ls = Analyzer.parseDependency(gitHubAPI.fileAPI.getFileRaw(item.getRawFileURI()));
            } catch (Exception e) {
                logger.error("Error encountered during parsing, ", e);
            } finally {
                Thread.sleep(LOCAL_ITEM_UPDATE_INTERVAL_MILLIS);
            }

            List<User> usr = null;
            try {
                usr = gitHubAPI.repositoryAPI.getContributors(r);
            } catch (Exception e) {
                logger.error("Error encountered during parsing, ", e);
            } finally {
                Thread.sleep(LOCAL_ITEM_UPDATE_INTERVAL_MILLIS);
            }
            Entry<Repository, Entry<List<User>, List<Dependency>>> entry = new Entry<>(r, new Entry<>(usr, ls));
            data.getData().add(entry);

            PrintWriter pw = new PrintWriter("data/DependencyAnalysis/Entries/DependencyDataEntry_" + (cnt++) + ".json");
            pw.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry));
            pw.close();
        }

        BackendService.dependencyData = data;


        logger.info("Updated local dependency data");
    }


    public void testWrite() throws FileNotFoundException {
        logger.info("The current backend file location is " + new File("").getAbsolutePath());
        PrintWriter pw = new PrintWriter("data/test.json");
        pw.write("Test write ok.");
        pw.close();
        logger.info("Test write ok.");
    }
}
