package edu.sustech.search.engine.github.API;

import edu.sustech.search.engine.github.API.search.requests.*;
import edu.sustech.search.engine.github.models.commit.CommitResult;
import edu.sustech.search.engine.github.models.issue.IssueResult;
import edu.sustech.search.engine.github.models.label.Label;
import edu.sustech.search.engine.github.models.label.LabelResult;
import edu.sustech.search.engine.github.models.repository.RepositoryResult;
import edu.sustech.search.engine.github.models.topic.TopicResult;
import edu.sustech.search.engine.github.models.user.UserResult;
import edu.sustech.search.engine.github.models.AppendableResult;
import edu.sustech.search.engine.github.models.code.CodeResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchAPI extends RestAPI {

    private static final Logger logger = LogManager.getLogger(SearchAPI.class);

    private static final int DEFAULT_INTERVAL = 15000; //Unit: ms

    private static String acceptSchema = "application/vnd.github.v3.text-match+json";
    private boolean isProvidingTextMatchEnabled = false;

    private final edu.sustech.search.engine.github.API.RateAPI rateAPI;

    SearchAPI(String OAuthToken) {
        super(OAuthToken);
        rateAPI = new RateAPI(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");
    }

    SearchAPI() {
        this(null);
    }

    /**
     * Search Issues and Pull-requests.
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public IssueResult searchIPR(IPRSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchIPR(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * Search Issues and Pull-requests.
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public IssueResult searchIPR(IPRSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, IssueResult.class, count, timeIntervalMillis);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CommitResult searchCommit(CommitSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchCommit(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CommitResult searchCommit(CommitSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, CommitResult.class, count, timeIntervalMillis);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public LabelResult searchLabel(LabelSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchLabel(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public LabelResult searchLabel(LabelSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, LabelResult.class, count, timeIntervalMillis);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public TopicResult searchTopic(TopicSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchTopic(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public TopicResult searchTopic(TopicSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, TopicResult.class, count, timeIntervalMillis);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public UserResult searchUser(UserSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchUser(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public UserResult searchUser(UserSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, UserResult.class, count, timeIntervalMillis);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CodeResult searchCode(CodeSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchCode(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CodeResult searchCode(CodeSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, CodeResult.class, count, timeIntervalMillis);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public RepositoryResult searchRepo(RepoSearchRequest request1, int count) throws IOException, InterruptedException {
        return searchRepo(request1, count, DEFAULT_INTERVAL);
    }

    /**
     * This method is a type-restricted implementation of the method <code>searchType</code>.
     * For detailed documentation, see <code>searchType</code>
     *
     * @param request1
     * @param count
     * @param timeIntervalMillis
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public RepositoryResult searchRepo(RepoSearchRequest request1, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return searchType(request1, RepositoryResult.class, count, timeIntervalMillis);
    }

    /**
     * This method uses while loop to request for search results.
     * Please notice that the GitHub REST API may severely restrict your ability to query the result.
     * <br>
     * If too often the secondary rate limit is encountered, please increase the <code>timeIntervalMillis</code>
     * (a typical recommendation might be <code>180000</code>), and run this method in another thread.
     *
     * @param <T>                Result type
     * @param request1           Request (will create another copy)
     * @param targetClazz        Target class for object mapper
     * @param count              Target Item count. Note that the actual items retrieved might be more
     * @param timeIntervalMillis Preferred time interval between requests
     * @return CodeResult
     * @throws IOException
     * @throws InterruptedException
     */
    @SuppressWarnings("unchecked")
    public <T extends AppendableResult> T searchType(SearchRequest request1, Class<T> targetClazz, int count, long timeIntervalMillis) throws IOException, InterruptedException {
        return (T) searchLoopFetching(request1, s -> convert(s, targetClazz), count, timeIntervalMillis); //It must be T, so no worry.
    }

    public AppendableResult searchLoopFetching(SearchRequest request1, AppendableResultParser p, int count, long timeIntervalMillis) throws InterruptedException, IOException {
        return searchLoopFetching(request1, null, p, count, timeIntervalMillis);
    }

    public AppendableResult searchLoopFetching(SearchRequest request1, AppendableResult origin, AppendableResultParser p, int count, long timeIntervalMillis) throws InterruptedException, IOException {

        SearchRequest request = new SearchRequest(request1);
        logger.info("Starting to fetch results on request[" + request.getRequestStringRaw() + "]. Target number: " + count);
        request.setResultPerPage(count);

        int cnt = 0;
        int endPage = Integer.MAX_VALUE;
        HttpResponse<String> response;
        AppendableResult result = origin;

        logger.warn("Suppressing responses from REST API");
        setSuppressError(true);

        for (int loopCnt = 1; cnt < count && request.getResultPage() <= endPage; loopCnt++) {
            logger.info("Looping: " + loopCnt);
            response = search(request);

            if (endPage == Integer.MAX_VALUE) {
                endPage = parseEndPageCount(response);
            }

            AppendableResult result1 = p.parse(response.body());

            if (result == null && result1.getItemCount() != 0) {
                result = result1;
                cnt = result.getItemCount();
                request.incrResultPage(1);
            } else if (result != null) {
                int incr = result.appendItems(result1);
                if (incr != 0) {
                    request.incrResultPage(1);
                    cnt += incr;
                } else {
                    printRateLimit(response);
                    Thread.sleep(500);
                }
            }

            logger.info("Result fetched: " + cnt);

            if (cnt < count && request.getResultPage() <= endPage) {
                logger.info("Waiting on time interval (millis) to fetch the next result: " + timeIntervalMillis);
                Thread.sleep(timeIntervalMillis);
            }
        }

        request.setResultPage(1);

        logger.warn("Recovering responses from REST API");
        setSuppressError(false);

        logger.info("Results have been gathered on request [" + request.getRequestStringRaw() + "]");

        return result;
    }

    @FunctionalInterface
    public interface AppendableResultParser {
        AppendableResult parse(String s);
    }

    /**
     * Automatically cast request result to the desired form.
     *
     * @param request Request
     * @param clazz   Target type class instance
     * @param <T>     Target type
     * @return Object result
     * @throws IOException
     * @throws InterruptedException
     */
    public <T> T searchResult(SearchRequest request, Class<T> clazz) throws IOException, InterruptedException {
        String s = searchRaw(request);
        return objectMapper.readValue(s, clazz);
    }

    public String searchRaw(SearchRequest request) throws IOException, InterruptedException {
        return search(request).body();
    }

    public HttpResponse<String> search(SearchRequest request) throws IOException, InterruptedException {
        if (isProvidingTextMatchEnabled) {
            return getHttpResponse(URI.create("https://api.github.com/search/" + request.getRequestString()), acceptSchema);
        } else {
            return getHttpResponse(URI.create("https://api.github.com/search/" + request.getRequestString()));
        }
    }

    /**
     * If set to <code>true</code>, the search result will provide text-match metadata.
     * @param enabled Whether the search result shall enable text-match providing.
     */
    public void setProvidingTextMatch(boolean enabled) {
        isProvidingTextMatchEnabled = enabled;
    }


    public static SearchAPI registerAPI(String OAuthToken) {
        return new SearchAPI(OAuthToken);
    }

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
