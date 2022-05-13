package edu.sustech.search.engine.github.models.pullrequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.net.URI;
import java.util.Date;

/**
 * Pull requests
 * <p>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "merged_at",
        "diff_url",
        "html_url",
        "patch_url",
        "url"
})
public class PullRequest {
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("merged_at")
    private Date mergedAt;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("diff_url")
    private URI diffUrl;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("html_url")
    private URI htmlUrl;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("patch_url")
    private URI patchUrl;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    private URI url;

}
