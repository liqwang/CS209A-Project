package edu.sustech.backend.controller;

import edu.sustech.search.engine.github.API.GitHubAPI;
import edu.sustech.search.engine.github.API.search.requests.RepoSearchRequest;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.repository.RepositoryResult;
import edu.sustech.search.engine.github.models.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    @GetMapping("location")
    public String test2(Integer count) throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");

        RepoSearchRequest req = RepoSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addLanguageOption("Maven POM").build();

        if (count < req.getResultPerPage()) {
            req.setResultPerPage(count);
        }

        RepositoryResult result = gitHubAPI.searchAPI.searchRepo(req, count);
        StringBuilder res = new StringBuilder();
        for (Repository r : result.getItems()) {
            res.append(r.getFullName() + "Contributors: ").append("<br>");
            List<User> userList = gitHubAPI.repositoryAPI.getRepositoryContributors(r);
            int deadLockCount = 0;
            while (userList.size() == 0 && deadLockCount < 5) {
                deadLockCount++;
                Thread.sleep(1200);
                userList = gitHubAPI.repositoryAPI.getRepositoryContributors(r);
            }
            for (User user : gitHubAPI.repositoryAPI.getRepositoryContributors(r)) {
                User usr = gitHubAPI.userAPI.getUser(user.getLogin());
                res.append("----").append(usr.getLogin()).append(" from ").append(usr.getLocation()).append("<br>");
            }
            Thread.sleep(500);
        }
        return res.toString();
    }
}
