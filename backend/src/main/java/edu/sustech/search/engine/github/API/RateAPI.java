package edu.sustech.search.engine.github.API;

import edu.sustech.search.engine.github.API.rate.RateLimitResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

public class RateAPI extends RestAPI {

    private static final Logger logger = LogManager.getLogger(RateAPI.class);

    public RateAPI(String OAuthToken) {
        super(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");
    }

    public RateLimitResult getRateLimit() throws IOException, InterruptedException {
        HttpResponse<String> response = getHttpResponse(URI.create("https://api.github.com/rate_limit"));
        return convert(response.body(), RateLimitResult.class);
    }
}
