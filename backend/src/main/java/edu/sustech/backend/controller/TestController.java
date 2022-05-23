package edu.sustech.backend.controller;

import edu.sustech.search.engine.github.API.GitHubAPI;
import edu.sustech.search.engine.github.API.search.requests.RepoSearchRequest;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.repository.RepositoryResult;
import edu.sustech.search.engine.github.models.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("repostars")
    public String testRepoStars() throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");
        RepoSearchRequest req = RepoSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addSearchKeyword("Visualization")
                .addLanguageOption("java")
                .setSorted(RepoSearchRequest.Sort.Stars)
                .build();

        RepositoryResult result = gitHubAPI.searchAPI.searchRepo(req, 100);

        StringBuilder sb = new StringBuilder();
        sb.append("Results on request:" + req.getRequestStringUnmodified()).append("<br>");
        for (Repository r : result) {
            sb.append("Stars:" + r.getStargazersCount() + ", repo name: " + r.getFullName() + ", created at " + r.getCreatedAt()).append("<br>");
        }

        return sb.toString();
    }

    @GetMapping("starredrepo")
    public String testStarredRepo(@RequestParam(value = "username", defaultValue = "IskXCr") String username) throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");
        List<Entry<Repository, Date>> repo = gitHubAPI.userAPI.getStarredRepo(username);

        StringBuilder res = new StringBuilder();
        res.append("Repositories that " + username + " has starred: <br>");
        for (Entry<Repository, Date> p : repo) {
            res.append("-------" + p.getKey().getFullName() + "<br>");
        }
        return res.toString();
    }

    @GetMapping("starhistory")
    public String testStarHistory(@RequestParam(value = "count", defaultValue = "100") Integer count) throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");

        RepoSearchRequest req = RepoSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addLanguageOption("Maven POM").build();

        req.setResultPerPage(count);

        RepositoryResult result = gitHubAPI.searchAPI.searchRepo(req, count);
        StringBuilder res = new StringBuilder();
        for (Repository r : result) {
            res.append(r.getFullName() + ", Stargazers: ").append("<br>");
            List<Entry<User, Date>> userList = gitHubAPI.repositoryAPI.getStarGazers(r);
            int deadLockCount = 0;
            while (userList.size() == 0 && deadLockCount < 2) {
                deadLockCount++;
                Thread.sleep(1000);
                userList = gitHubAPI.repositoryAPI.getStarGazers(r);
            }
            for (Entry<User, Date> entry : userList) {
                res.append("--------").append(entry.getKey().getLogin()).append("<br>")
                        .append("----------------starred at ").append(entry.getValue()).append("<br>")
                        .append("------------------------location ").append(gitHubAPI.userAPI.getUser(entry.getKey().getLogin()).getLocation()).append("<br>");
            }
            Thread.sleep(500);
        }
        return res.toString();
    }

    @GetMapping("repolocation")
    public String test2(@RequestParam(value = "count", defaultValue = "100") Integer count) throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = GitHubAPI.registerAPI("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");

        RepoSearchRequest req = RepoSearchRequest.newBuilder()
                .addSearchKeyword("Data")
                .addLanguageOption("Maven POM").build();

        req.setResultPerPage(count);

        RepositoryResult result = gitHubAPI.searchAPI.searchRepo(req, count);
        StringBuilder res = new StringBuilder();
        for (Repository r : result) {
            res.append(r.getFullName() + ", Contributors: ").append("<br>");
            List<User> userList = gitHubAPI.repositoryAPI.getContributors(r);
            int deadLockCount = 0;
            while (userList.size() == 0 && deadLockCount < 5) {
                deadLockCount++;
                Thread.sleep(1200);
                userList = gitHubAPI.repositoryAPI.getContributors(r);
            }
            for (User user : userList) {
                User usr = gitHubAPI.userAPI.getUser(user.getLogin());
                res.append("----").append(usr.getLogin()).append(" from ").append(usr.getLocation()).append("<br>");
            }
            Thread.sleep(500);
        }
        return res.toString();
    }
}
