package edu.sustech.search.engine.github.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import edu.sustech.search.engine.github.API.rate.RateLimitResult;
import edu.sustech.search.engine.github.models.APIErrorMessage;
import edu.sustech.search.engine.github.transformer.Transformer;
import org.apache.logging.log4j.*;

public class RestAPI {
    private static final long DEFAULT_TIME_LIMIT_MILLIS = 1000;

    public static final Duration TIME_OUT_DURATION = Duration.ofSeconds(10);
    private static final Logger logger = LogManager.getLogger(RestAPI.class);
    private static final ObjectMapper staticObjectMapper = new ObjectMapper();

    static {
        staticObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * The <code>getHttpResponse</code> method uses this variable to determine whether the error message will be printed when it receives an unexpected response
     */
    boolean suppressResponseError = false;

    /**
     * The <code>getHttpResponse</code> method uses this variable to determine whether the error message will be printed when it receives an unexpected response
     */
    boolean suppressRateError = false;

    final String token;
    HttpClient client;
    final ObjectMapper objectMapper;

    public RestAPI(String OAuthToken) {
        this.token = OAuthToken;
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public RestAPI() {
        this(null);
    }

    public String getHttpResponseRaw(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = getHttpResponse(uri);
        return response == null ? null : response.body();
    }

    public String getHttpResponseRaw(URI uri, String acceptSchema) throws IOException, InterruptedException {
        HttpResponse<String> response = getHttpResponse(uri, acceptSchema);

        return response == null ? null : response.body();
    }

    public List<String> getHttpResponseRawLoopFetching(URI rawUri, int targetPageCount) throws IOException, InterruptedException {
        return getHttpResponseRawLoopFetching(rawUri, targetPageCount, DEFAULT_TIME_LIMIT_MILLIS);
    }

    public List<String> getHttpResponseRawLoopFetching(URI rawUri, String acceptSchema, int targetPageCount) throws IOException, InterruptedException {
        return getHttpResponseRawLoopFetching(rawUri, acceptSchema, targetPageCount, DEFAULT_TIME_LIMIT_MILLIS);
    }

    public List<String> getHttpResponseRawLoopFetching(URI rawUri, int targetPageCount, long timeIntervalMillis) throws IOException, InterruptedException {
        return getHttpResponseRawLoopFetching(rawUri, "application/vnd.github.v3+json", targetPageCount, timeIntervalMillis);
    }

    public List<String> getHttpResponseRawLoopFetching(URI rawUri, String acceptSchema, int targetPageCount, long timeIntervalMillis) throws IOException, InterruptedException {
        return getHttpResponseLoopFetching(rawUri, acceptSchema, targetPageCount, timeIntervalMillis).stream().map(HttpResponse::body).collect(Collectors.toList());
    }

    /**
     * Get the response in a loop-fetching style. The default time interval between each request will be used.
     *
     * @param rawUri          Raw uri without per_page settings and page numbers
     * @param targetPageCount Target page count
     */
    public List<HttpResponse<String>> getHttpResponseLoopFetching(URI rawUri, int targetPageCount) throws IOException, InterruptedException {
        return getHttpResponseLoopFetching(rawUri, targetPageCount, DEFAULT_TIME_LIMIT_MILLIS);
    }

    /**
     * Get the response in a loop-fetching style. The default time interval between each request will be used.
     *
     * @param rawUri          Raw uri without per_page settings and page numbers
     * @param acceptSchema    Accept schema
     * @param targetPageCount Target page count
     */
    public List<HttpResponse<String>> getHttpResponseLoopFetching(URI rawUri, String acceptSchema, int targetPageCount) throws IOException, InterruptedException {
        return getHttpResponseLoopFetching(rawUri, acceptSchema, targetPageCount, DEFAULT_TIME_LIMIT_MILLIS);
    }

    /**
     * Get the response in a loop-fetching style
     *
     * @param rawUri             Raw uri without per_page settings and page numbers
     * @param targetPageCount    Target page count
     * @param timeIntervalMillis Time interval between each request made
     */
    public List<HttpResponse<String>> getHttpResponseLoopFetching(URI rawUri, int targetPageCount, long timeIntervalMillis) throws IOException, InterruptedException {
        return getHttpResponseLoopFetching(rawUri, "application/vnd.github.v3+json", targetPageCount, timeIntervalMillis);
    }

    /**
     * Get the response in a loop-fetching style
     *
     * @param rawUri             Raw uri without per_page settings and page numbers
     * @param acceptSchema       Accept schema
     * @param targetPageCount    Target page count
     * @param timeIntervalMillis Time interval between each request made
     */
    public List<HttpResponse<String>> getHttpResponseLoopFetching(URI rawUri, String acceptSchema, int targetPageCount, long timeIntervalMillis) throws IOException, InterruptedException {

        logger.info("Starting to fetch results on raw http request[" + rawUri.toString() + "]. Target number: " + targetPageCount);


        int pageCount = 0;
        int endPageCount = Integer.MAX_VALUE;
        int perPage = 100;

        HttpResponse<String> response;
        List<HttpResponse<String>> result = new ArrayList<>();

        StringBuilder uriRawContent = new StringBuilder(rawUri.toString() + "?&per_page=" + perPage + "&page=1");
        int lastIndex = uriRawContent.length() - 1;
        logger.debug("Suppressing responses from REST API");
        setSuppressResponseError(true);

        for (int loopCnt = 1; pageCount < targetPageCount && pageCount <= endPageCount; loopCnt++) {
            logger.info("Looping: " + loopCnt);

            response = getHttpResponse(URI.create(Transformer.preTransformURI(uriRawContent.toString())), acceptSchema);


            if (response != null) {
                if (endPageCount == Integer.MAX_VALUE) {
                    endPageCount = parseEndPageCount(response);
                }

                if (response.statusCode() == 200) {
                    result.add(response);
                    pageCount++;
                    uriRawContent.replace(lastIndex, lastIndex + 1, String.valueOf(pageCount + 1));
                } else {
                    printRateLimit(response);
                }
            }

            logger.info("Result fetched: " + pageCount);

            if (pageCount < targetPageCount && pageCount <= endPageCount) {
                logger.debug("Waiting on time interval (millis) to fetch the next result: " + timeIntervalMillis);
                Thread.sleep(timeIntervalMillis);
            }
        }

        logger.debug("Recovering responses from REST API");
        setSuppressResponseError(false);

        logger.info("Results have been gathered on request [" + rawUri.toString() + "]");

        return result;
    }

    public HttpResponse<String> getHttpResponse(URI uri) throws IOException, InterruptedException {
        return getHttpResponse(uri, "application/vnd.github.v3+json");
    }


    public HttpResponse<String> getHttpResponse(URI uri, String acceptSchema) throws IOException, InterruptedException {
        uri = URI.create(Transformer.preTransformURI(uri.toString()));

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        if (token != null) {
            builder.headers("Authorization", "token " + token);
        }
        if (acceptSchema == null) {
            acceptSchema = "application/vnd.github.v3+json";
        }
        HttpRequest httpRequest = builder.headers("Accept", acceptSchema)
                .uri(uri).timeout(TIME_OUT_DURATION).build();
        logger.debug("Sending request: " + httpRequest.uri());
        client = HttpClient.newHttpClient();

        HttpResponse<String> response;
        int deadLockCount = 0;
        do {
            response = null;
            try {
                response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                logger.error(e.getLocalizedMessage() + " Caused by: " + e.getCause());
            }
            if (response == null) {
                logger.error("Connection error upon receiving REST response from API. Check parameters, request intervals and etc. You may try again.");
            } else if (response.statusCode() != 200) {


                APIErrorMessage message = objectMapper.readValue(response.body(), APIErrorMessage.class);
                if (!suppressResponseError) {
                    logger.error("Error upon receiving REST response from API. Check parameters, request intervals and etc. You may try again.");
                    logger.error("Request URL = " + uri.toString());
                    logger.warn(message.getMessage());
                    logger.error("Http response code: " + response.statusCode());
                }

                if (!suppressRateError && message.getMessage().contains("secondary rate limit")) {
                    logger.error("Secondary rate limit exceeded.", new RequestRateExceededException());
                    printRateLimit(response);
                }
            }
            Thread.sleep(DEFAULT_TIME_LIMIT_MILLIS);
        } while ((response == null || response.statusCode() != 200) && (deadLockCount++ < 3));
        return response;
    }

    /**
     * If set to <code>true</code>, error messages for tries in the response will be hidden.
     * This is usually used in loop fetching.
     *
     * @param isErrorSuppressed
     */
    public void setSuppressResponseError(boolean isErrorSuppressed) {
        if (isErrorSuppressed) {
            logger.debug("Error suppression on http response is " + true + ". This may cause hidden problems.");
        } else {
            logger.debug("Error suppression on http response has been recovered.");
        }
        suppressResponseError = isErrorSuppressed;
    }

    /**
     * If set to <code>true</code>, error messages for rate limit exceeding in the response will be hidden.
     * This is usually used in <code>searchAPI</code>.
     *
     * @param isErrorSuppressed
     */
    public void setSuppressRateError(boolean isErrorSuppressed) {
        if (isErrorSuppressed) {
            logger.warn("Rate Error suppression on http response is " + true + ". This may cause hidden problems.");
        } else {
            logger.warn("Rate Error suppression on http response has been recovered.");
        }
        suppressRateError = isErrorSuppressed;
    }

    public void printRateLimit(HttpResponse<String> response) {
        response.headers().firstValue("x-ratelimit-reset")
                .ifPresent(e -> logger.error("The rate will be reset on " + new Date(Long.parseLong(e))));
        response.headers().firstValueAsLong("x-ratelimit-limit")
                .ifPresent(e -> logger.error("The rate limit maximum is " + e));
        response.headers().firstValueAsLong("x-ratelimit-remaining")
                .ifPresent(e -> logger.error("The rate limit remaining is " + e));
    }

    public RateLimitResult getRateLimit() throws IOException, InterruptedException {
        HttpResponse<String> response = getHttpResponse(URI.create("https://api.github.com/rate_limit"));
        return response == null ? null : convert(response.body(), RateLimitResult.class);
    }

    /**
     * Convert the object using the internal objectMapper created at instantiation.
     *
     * @param jsonContent JsonContent
     * @param clazz       Target class
     * @return An instance of the target class parsed from the json content provided.
     */
    public static <T> T convert(String jsonContent, Class<T> clazz) {
        try {
            return staticObjectMapper.readValue(jsonContent, clazz);
        } catch (JsonProcessingException e) {
            logger.error(e);
            logger.error("Internal parsing failure.");
        }
        return null;
    }

    /**
     * This method parse the end page count from the response header.
     *
     * @param response Response to parse
     * @return The end page count. <code>Integer.MAX_VALUE</code> will be assigned if not found.
     */
    public static int parseEndPageCount(HttpResponse<String> response) {
        int result = Integer.MAX_VALUE;
        if (response.headers().firstValue("Link").isPresent()) {
            try {
                String s1 = response.headers().firstValue("Link").get();
                Pattern p1 = Pattern.compile("&page=(\\d+)");

                logger.debug("The given header to read is: " + s1);
                logger.debug("The given index of the rel=\"last\" is: " + s1.indexOf("rel=\"last\""));

                Matcher matcher1 = p1.matcher(s1.substring((
                        Math.max(s1.indexOf("rel=\"last\"") - 30, 0) //practice value 30
                )));
                if (matcher1.find()) {
                    String result1 = matcher1.toMatchResult().group(1);
                    logger.debug("Matcher result: " + result1);
                    result = Integer.parseInt(result1);
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (result != Integer.MAX_VALUE) {
            logger.info("New end page number found: " + result);
        }
        return result;
    }

}
