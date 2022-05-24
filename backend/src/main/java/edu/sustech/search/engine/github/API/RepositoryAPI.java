package edu.sustech.search.engine.github.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.content.ContentFile;
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

public class RepositoryAPI extends RestAPI {

    private final Logger logger = LogManager.getLogger(RepositoryAPI.class);

    RepositoryAPI(String OAuthToken) {
        super(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");
    }

    RepositoryAPI() {
        this(null);
    }

    public List<User> getContributors(Repository r) throws IOException, InterruptedException {
        return getContributors(r.getContributorsUrl());
    }

    public List<User> getContributors(URI uri) throws IOException, InterruptedException {
        logger.info("Get contributors list from " + uri);

        List<User> result = new ArrayList<>();
        List<String> responses = getHttpResponseRawLoopFetching(uri, 5);
        for (String s : responses) {
            try {
                List<User> result1 = objectMapper.readValue(s, new TypeReference<>() {
                });
                result.addAll(result1);
            } catch (MismatchedInputException e) { //Sometimes you get no input
                logger.error(e);
            }
        }
        return result;
    }

    public List<Entry<User, Date>> getStarGazers(String repoFullName) throws IOException, InterruptedException {
        return getStarGazers(URI.create(Transformer.preTransformURI("https://api.github.com/repos/" + repoFullName + "/stargazers")));
    }

    public List<Entry<User, Date>> getStarGazers(Repository r) throws IOException, InterruptedException {
        return getStarGazers(r.getStargazersUrl());
    }


    public List<Entry<User, Date>> getStarGazers(URI uri) throws IOException, InterruptedException {
        logger.info("Get stargazers list from " + uri);

        String acceptSchema = "application/vnd.github.v3.star+json";
        List<String> resultResponses = getHttpResponseRawLoopFetching(uri, acceptSchema, 5);

        List<Entry<User, Date>> result = new ArrayList<>();

        for (String result0 : resultResponses) {
            JsonNode rootNode = objectMapper.readTree(result0);
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
                    User user = null;
                    convert(arrNode.get("user").toString(), User.class);
                    if (user != null) {
                        result.add(new Entry<>(user, creationDate));
                    }
                }
            }
        }
        return result;
    }


    public Repository getRepository(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = getRepositoryInfoDirect(uri);
        return response == null ? null : convert(response.body(), Repository.class);
    }

    public Repository getRepository(String repoFullName) throws IOException, InterruptedException {
        return convert(getRepositoryInfoRaw(repoFullName), Repository.class);
    }

    public String getRepositoryInfoRaw(String repoFullName) throws IOException, InterruptedException {
        HttpResponse<String> response = getRepositoryInfo(repoFullName);
        return response == null ? null : response.body();
    }

    public HttpResponse<String> getRepositoryInfo(String repoFullName) throws IOException, InterruptedException {
        return getRepositoryInfoDirect(URI.create(Transformer.preTransformURI("https://api.github.com/repos/" + repoFullName)));
    }

    public HttpResponse<String> getRepositoryInfoDirect(URI uri) throws IOException, InterruptedException {
        return getHttpResponse(uri);
    }

    public static RepositoryAPI registerAPI(String OAuthToken) {
        return new RepositoryAPI(OAuthToken);
    }

}
