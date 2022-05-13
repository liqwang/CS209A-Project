package edu.sustech.search.engine.github.API;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

public class UserAPI extends RestAPI {

    private static final Logger logger = LogManager.getLogger(UserAPI.class);

    UserAPI(String OAuthToken) {
        super(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");
    }

    UserAPI() {
        this(null);
    }


    public List<Repository> getStarredRepo(String username) throws IOException, InterruptedException {
        return getStarredRepo(URI.create("https://api.github.com/users/" + username + "/starred"));
    }

    public List<Repository> getStarredRepo(User user) throws IOException, InterruptedException {
        return getStarredRepo(URI.create(user.getStarredUrl()));
    }

    public List<Repository> getStarredRepo(URI uri) throws IOException, InterruptedException {
        return objectMapper.readValue(getHttpResponseRaw(uri), new TypeReference<>() {
        });
    }

    public User getUser(URI uri) throws IOException, InterruptedException {
        return convert(sendUserRequestDirect(uri).body(), User.class);
    }

    public User getUser(String username) throws IOException, InterruptedException {
        return convert(getUserInfoRaw(username), User.class);
    }

    public String getUserInfoRaw(String username) throws IOException, InterruptedException {
        HttpResponse<String> response = sendUserRequest(username);
        return response.body();
    }


    public HttpResponse<String> sendUserRequest(String username) throws IOException, InterruptedException {
        return sendUserRequestDirect(URI.create("https://api.github.com/users/" + username));
    }

    public HttpResponse<String> sendUserRequestDirect(URI uri) throws IOException, InterruptedException {

        return getHttpResponse(uri);
    }

    public static UserAPI registerAPI(String OAuthToken) {
        return new UserAPI(OAuthToken);
    }

}
