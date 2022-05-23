package edu.sustech.search.engine.github.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Provides the entry to interact with the GitHub RestAPI.
 * The class needs to be instantiated with an OAuthToken to unlock all functionalities.
 */
public class GitHubAPI extends RestAPI {

    private static final Logger logger = LogManager.getLogger(GitHubAPI.class);

    public final SearchAPI searchAPI;
    public final RepositoryAPI repositoryAPI;
    public final UserAPI userAPI;
    public final ContentAPI contentAPI;
    public final FileAPI fileAPI;

    /**
     * Initialize a new GitHubAPI instance to interact with.
     * This method is only used internally to prevent further modifications.
     * @param OAuthToken Personal Access Token, or OAuthToken, which will be used for authentication.
     *                   If set to <code>null</code>, then no OAuthToken will be used.
     */
    GitHubAPI(String OAuthToken) {
        super(OAuthToken);

        searchAPI = SearchAPI.registerAPI(OAuthToken);
        repositoryAPI = RepositoryAPI.registerAPI(OAuthToken);
        userAPI = UserAPI.registerAPI(OAuthToken);
        contentAPI = ContentAPI.registerAPI(OAuthToken);
        fileAPI = FileAPI.registerAPI(OAuthToken);

        logger.info("Initialized " + (OAuthToken != null ? OAuthToken.substring(0, 8) : "<null>") + "...(hidden)");
    }

    /**
     * Initialize a new GitHubAPI instance with no OAuthToken.
     */
    GitHubAPI(){
        this(null);
    }

    /**
     * Initialize a new GitHubAPI instance to interact with.
     * @param OAuthToken Personal Access Token, or OAuthToken, which will be used for authentication.
     *                   If set to <code>null</code>, then no OAuthToken will be used.
     * @return A new GitHubAPI with specific OAuthToken initialized as the certificate for authentication.
     */
    public static GitHubAPI registerAPI(String OAuthToken) {
        return new GitHubAPI(OAuthToken);
    }
}
