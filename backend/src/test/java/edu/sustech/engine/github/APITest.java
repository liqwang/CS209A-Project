package edu.sustech.engine.github;

import edu.sustech.search.engine.github.API.GitHubAPI;
import edu.sustech.search.engine.github.API.RestAPI;
import edu.sustech.search.engine.github.API.search.requests.CodeSearchRequest;
import edu.sustech.search.engine.github.API.search.requests.RepoSearchRequest;
import edu.sustech.search.engine.github.analyzer.Analyzer;
import edu.sustech.search.engine.github.analyzer.models.Dependency;
import edu.sustech.search.engine.github.models.code.CodeItem;
import edu.sustech.search.engine.github.models.code.CodeResult;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.repository.RepositoryResult;
import edu.sustech.search.engine.github.models.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class APITest {
    private static final Logger logger = LogManager.getLogger(APITest.class);

    @Test
    void testRepoResult() throws IOException, InterruptedException {
        String OAuthToken = Files.readString(Path.of("src/test/samples/TestToken.txt"));

        GitHubAPI gitHubAPI = GitHubAPI.registerAPI(OAuthToken);

        RepoSearchRequest req = RepoSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addLanguageOption("Maven POM")
                .build();

        RepositoryResult result = gitHubAPI.searchAPI.searchRepo(req, 100);
        for (Repository r : result.getItems()) {
            System.out.println(r.getFullName() + "Contributors: ");
            for(User user: gitHubAPI.repositoryAPI.getRepositoryContributors(r)){
                System.out.println(user.getLogin());
            }
            Thread.sleep(500);
        }
    }

    @Test
    void testConvert() throws IOException {
        CodeResult result = RestAPI.convert(Files.readString(Path.of("result.json")), CodeResult.class);
        System.out.println(result);
    }

    @Test
    void test1() throws IOException, InterruptedException {
        String OAuthToken = Files.readString(Path.of("src/test/samples/TestToken.txt"));

        GitHubAPI gitHubAPI = GitHubAPI.registerAPI(OAuthToken);

        CodeSearchRequest req = CodeSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addLanguageOption("Maven POM")
                .addSearchField(CodeSearchRequest.SearchBy.Filename, "pom.xml")
                .build();

        CodeResult result = gitHubAPI.searchAPI.searchCode(req, 24);
//        CodeResult result = SearchAPI.convert(s);

        for (CodeItem item : result.getItems()) {
            System.out.println(item.getName());
            if (item.getName().equals("pom.xml")) {
                System.out.print("File from:" + item.getRepository().getFullName() + ", dependencies: \n");

                String s = gitHubAPI.fileAPI.getFileRaw(item.getRawFileURI());
                List<Dependency> dependencies = Analyzer.parseDependency(s);
                for (Dependency d : dependencies) {
                    System.out.print(d + " ");
                }
                System.out.println();
            }
        }
    }
}