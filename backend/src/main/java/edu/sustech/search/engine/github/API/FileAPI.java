package edu.sustech.search.engine.github.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

public class FileAPI extends RestAPI {

    private static final Logger logger = LogManager.getLogger(FileAPI.class);

    FileAPI(String OAuthToken) {
        super(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");

    }

    FileAPI() {
        this(null);
    }


    public String getFileRaw(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = getFileDirect(uri);
        return response == null ? null : getFileDirect(uri).body();
    }

    public HttpResponse<String> getFileDirect(URI uri) throws IOException, InterruptedException {
        logger.info("Getting raw file from " + uri.toString());
        return getHttpResponse(uri);
    }


    public static FileAPI registerAPI(String OAuthToken) {
        return new FileAPI(OAuthToken);
    }
}
