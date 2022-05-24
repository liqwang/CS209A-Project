package edu.sustech.search.engine.github.API;

import edu.sustech.search.engine.github.models.content.ContentDirectory;
import edu.sustech.search.engine.github.models.content.ContentFile;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.transformer.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

public class ContentAPI extends edu.sustech.search.engine.github.API.RestAPI {

    private static final Logger logger = LogManager.getLogger(RestAPI.class);

    ContentAPI(String OAuthToken) {
        super(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");
    }

    ContentAPI() {
        this(null);
    }

    public ContentDirectory getContentDirectory(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = getContentDirect(uri);
        return response == null ? null : convert(response.body(), ContentDirectory.class);
    }

    public ContentFile getContentFile(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = getContentDirect(uri);
        return response == null ? null : convert(response.body(), ContentFile.class);
    }

    public String getContentRaw(Repository repo, String path) throws IOException, InterruptedException {
        return getContentRaw(URI.create(Transformer.preTransformURI("https://api.github.com/repos/" + unwrapSlashes(repo.getFullName()) + "/contents" + (path.charAt(0) != '/' ? '/' + path : path))));

    }

    public String getContentRaw(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = getContentDirect(uri);
        return response == null ? null : response.body();
    }

    public HttpResponse<String> getContentDirect(URI uri) throws IOException, InterruptedException {
        return getHttpResponse(uri);
    }


    public static ContentAPI registerAPI(String OAuthToken) {
        return new ContentAPI(OAuthToken);
    }

    private static String unwrapSlashes(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.charAt(0) == '/') {
            sb.deleteCharAt(0);
        }
        if (s.charAt(s.length() - 1) == '/') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
