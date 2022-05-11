package edu.sustech.backend.controller;

import edu.sustech.search.engine.github.API.GitHubAPI;
import edu.sustech.search.engine.github.API.search.requests.RepoSearchRequest;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.repository.RepositoryResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("t1")
    public String test() throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");
        RepoSearchRequest req = RepoSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addSearchKeyword("Visualization")
                .addLanguageOption("java")
                .setSorted(RepoSearchRequest.Sort.Stars)
                .build();

        RepositoryResult result = gitHubAPI.searchAPI.searchRepo(req, 100);

        StringBuilder sb = new StringBuilder();
        sb.append("Results on request:" + req.getRequestStringRaw()).append("<br>");
        for (Repository r : result.getItems()) {
            sb.append("Stars:" + r.getStargazersCount() + ", repo name: " + r.getFullName() + ", created at " + r.getCreatedAt()).append("<br>");
        }

        return sb.toString();
    }
}
