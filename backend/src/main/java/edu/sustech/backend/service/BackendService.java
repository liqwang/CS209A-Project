package edu.sustech.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.sustech.backend.entities.DependencyData;
import edu.sustech.backend.service.models.BarChartItem;
import edu.sustech.search.engine.github.API.FileAPI;
import edu.sustech.search.engine.github.API.GitHubAPI;
import edu.sustech.search.engine.github.API.search.requests.CodeSearchRequest;
import edu.sustech.search.engine.github.API.search.requests.RepoSearchRequest;
import edu.sustech.search.engine.github.analyzer.Analyzer;
import edu.sustech.search.engine.github.models.Dependency;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.code.CodeItem;
import edu.sustech.search.engine.github.models.code.CodeResult;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.repository.RepositoryResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class BackendService {
    public static Logger logger = LogManager.getLogger(BackendService.class);
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");

    public static void updateLocalData() throws IOException, InterruptedException {
        logger.info("Updating local data.");

        //Update Dependency Analysis Result
//        RepoSearchRequest req3 = RepoSearchRequest.newBuilder()
//                .addLanguageOption("java")
//                .setSorted(RepoSearchRequest.Sort.Stars)
        updateLocalQ1();
    }

    public static String getTopUsedDependencies(){

        DependencyData data = null;
        try {
            data = BackendService.readLocalQ1();
        } catch (IOException e) {
            e.printStackTrace();
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
            try{
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Internal parsing failure.";
    }

    public static DependencyData readLocalQ1() throws IOException {
        logger.info("Reading local Q1");
//        System.out.println(new File("backend/data/q1.json").getAbsolutePath());
        return objectMapper.readValue(new File("backend/data/q1.json"), DependencyData.class);
    }

    public static void updateLocalQ1() throws IOException, InterruptedException {
        logger.info("Updating local Q1");

        CodeSearchRequest req1 = CodeSearchRequest.newBuilder()
                .addSearchField(CodeSearchRequest.SearchBy.Filename, "pom.xml")
                .addLanguageOption("Maven POM")
                .build();

        CodeResult result1 = gitHubAPI.searchAPI.searchCode(req1, 3);

        DependencyData data = new DependencyData();


        for (CodeItem item : result1) {
            Repository r = item.getRepository();

            List<Dependency> ls = null;
            try {
                ls = Analyzer.parseDependency(gitHubAPI.fileAPI.getFileRaw(item.getRawFileURI()));
                Thread.sleep(500);
            } catch (Exception e) {
                logger.error("Error encountered during parsing, ", e);
            }
            data.getData().add(new Entry<>(r, ls));
        }

        PrintWriter pw = new PrintWriter("backend/data/q1.json");
        pw.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
        pw.close();
    }

    public static void testWrite() {
        try {
            PrintWriter pw = new PrintWriter("backend/data/test.json");
            pw.write("Test write ok.");
            pw.close();
            logger.info("Test write ok.");
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
    }
}
