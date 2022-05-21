package edu.sustech.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sustech.backend.entities.DependencyData;
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
import edu.sustech.search.engine.github.models.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class BackendService {
    private static final int LOCAL_UPDATE_INTERVAL_MILLIS = 60000;

    private static final Logger logger = LogManager.getLogger(BackendService.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");


    public static void updateLocalData() throws IOException, InterruptedException {
        logger.info("Updating local data.");

        //Update Dependency Analysis Result
//        RepoSearchRequest req3 = RepoSearchRequest.newBuilder()
//                .addLanguageOption("java")
//                .setSorted(RepoSearchRequest.Sort.Stars)
        updateLocalDependencyData();
        updateLocalLog4jIPRData();
    }

    private static DependencyData data;

    public static String getTopUsedDependencies() {

        if (data == null) {
            try {
                data = BackendService.readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (data != null) {
            HashMap<String, Integer> dependencyMap = new HashMap<>();

            data.getData().stream().forEach(e -> {
                List<Dependency> list = e.getValue();
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

    public static String getAvailableGroupSelections(){
        HashSet<String> groupList = new HashSet<>();
        if (data == null) {
            try {
                data = BackendService.readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (data != null) {
            data.getData().stream().forEach(e -> {
                List<Dependency> list = e.getValue();
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
    public static String getAvailableDependencySelections() {
        HashSet<String> dependencyList = new HashSet<>();
        if (data == null) {
            try {
                data = BackendService.readLocalDependencyData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (data != null) {
            data.getData().stream().forEach(e -> {
                List<Dependency> list = e.getValue();
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

    public static IPRResult readLocalLog4jIPRData() throws IOException {
        logger.info("Reading local log4j issues and pull requests data");

        return objectMapper.readValue(new File("backend/data/log4jiprdata.json"), IPRResult.class);
    }

    public static void updateLocalLog4jIPRData() throws IOException, InterruptedException {
        logger.info("Updating local log4j issues and pull requests data");

        IPRSearchRequest req = IPRSearchRequest.newBuilder()
                .addSearchKeyword("log4j")
                .build();

        IPRResult result1 = gitHubAPI.searchAPI.searchIPR(req, 3000, LOCAL_UPDATE_INTERVAL_MILLIS);

        PrintWriter pw = new PrintWriter("backend/data/log4jiprdata.json");
        pw.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result1));
        pw.close();
        logger.info("Updated local log4j issues and pull requests data");
    }

    public static DependencyData readLocalDependencyData() throws IOException {
        logger.info("Reading local dependency data");
        return objectMapper.readValue(new File("backend/data/dependency_data.json"), DependencyData.class);
    }

    public static void updateLocalDependencyData() throws IOException, InterruptedException {
        logger.info("Updating local dependency data");

        CodeSearchRequest req1 = CodeSearchRequest.newBuilder()
                .addSearchField(CodeSearchRequest.SearchBy.Filename, "pom.xml")
                .addLanguageOption("Maven POM")
                .build();

        CodeResult result1 = gitHubAPI.searchAPI.searchCode(req1, 1000, LOCAL_UPDATE_INTERVAL_MILLIS);

        DependencyData data = new DependencyData();

        for (CodeItem item : result1) {
            Repository r = item.getRepository();

            List<Dependency> ls = null;
            try {
                ls = Analyzer.parseDependency(gitHubAPI.fileAPI.getFileRaw(item.getRawFileURI()));
                Thread.sleep(600);
            } catch (Exception e) {
                logger.error("Error encountered during parsing, ", e);
            }
            data.getData().add(new Entry<>(r, ls));
        }

        BackendService.data = data;

        PrintWriter pw = new PrintWriter("backend/data/dependency_data.json");
        pw.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
        pw.close();
        logger.info("Updated local dependency data");
    }


    public static void testWrite() {
        try {
            PrintWriter pw = new PrintWriter("backend/data/test.json");
            pw.write("Test write ok.");
            pw.close();
            logger.info("Test write ok.");
        } catch (FileNotFoundException e) {
            logger.error("Test write failed.");
            logger.error(e);
        }
    }
}
