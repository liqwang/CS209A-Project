package edu.sustech.search.engine.github.API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.user.User;
import edu.sustech.search.engine.github.transformer.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Entry<Repository, Date>> getStarredRepo(String username) throws IOException, InterruptedException {
        return getStarredRepo(URI.create(Transformer.preTransformURI("https://api.github.com/users/" + username + "/starred")));
    }

    public List<Entry<Repository, Date>> getStarredRepo(User user) throws IOException, InterruptedException {
        return getStarredRepo(URI.create(Transformer.preTransformURI(user.getStarredUrl())));
    }

    public List<Entry<Repository, Date>> getStarredRepo(URI uri) throws IOException, InterruptedException {
        String acceptSchema = "application/vnd.github.v3.star+json";
        String result0 = getHttpResponseRaw(uri, acceptSchema);
        JsonNode rootNode = objectMapper.readTree(result0);

        List<Entry<Repository, Date>> result = new ArrayList<>();

        String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (rootNode.isArray()) {
            logger.debug("Target type is array.");
            for (final JsonNode arrNode : rootNode) {
                logger.debug("Processing node:" + arrNode);
                Date creationDate = null;
                try {
                    creationDate = simpleDateFormat.parse(
                            arrNode.get("starred_at").textValue());
                } catch (ParseException e) {
                    logger.error(e);
                }
                Repository repository = convert(arrNode.get("repo").toString(), Repository.class);
                result.add(new Entry<>(repository, creationDate));
            }
        }
        return result;
    }

    public User getUser(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = sendUserRequestDirect(uri);
        return response == null ? null : convert(response.body(), User.class);
    }

    public User getUser(String username) throws IOException, InterruptedException {
        return convert(getUserInfoRaw(username), User.class);
    }

    public String getUserInfoRaw(String username) throws IOException, InterruptedException {
        HttpResponse<String> response = sendUserRequest(username);
        return response == null ? null : response.body();
    }


    public HttpResponse<String> sendUserRequest(String username) throws IOException, InterruptedException {
        return sendUserRequestDirect(URI.create(Transformer.preTransformURI("https://api.github.com/users/" + username)));
    }

    public HttpResponse<String> sendUserRequestDirect(URI uri) throws IOException, InterruptedException {
        logger.info("Sending user request direct: " + uri);
        return getHttpResponse(uri);
    }

    public static UserAPI registerAPI(String OAuthToken) {
        return new UserAPI(OAuthToken);
    }

}
