
package edu.sustech.search.engine.github.models.commit;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.Parent;
import edu.sustech.search.engine.github.models.TextMatch;
import edu.sustech.search.engine.github.models.repository.Repository;


/**
 * Commit Search Result Item
 * <p>
 * Commit Search Result Item
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "sha",
        "html_url",
        "comments_url",
        "commit",
        "author",
        "committer",
        "parents",
        "repository",
        "score",
        "node_id",
        "text_matches"
})
@Generated("jsonschema2pojo")
public class CommitItem {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    private URI url;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("sha")
    private String sha;
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
    @JsonProperty("comments_url")
    private URI commentsUrl;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("commit")
    private Commit commit;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("author")
    private Object author;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("committer")
    private Object committer;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("parents")
    private List<Parent> parents = new ArrayList<Parent>();
    /**
     * Minimal Repository
     * <p>
     * Minimal Repository
     * (Required)
     *
     */
    @JsonProperty("repository")
    @JsonPropertyDescription("Minimal Repository")
    private Repository repository;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("score")
    private Double score;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_id")
    private String nodeId;
    /**
     * Search Result Text Matches
     * <p>
     *
     *
     */
    @JsonProperty("text_matches")
    private List<TextMatch> textMatches = new ArrayList<TextMatch>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("html_url")
    public URI getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("html_url")
    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("comments_url")
    public URI getCommentsUrl() {
        return commentsUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("comments_url")
    public void setCommentsUrl(URI commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("commit")
    public Commit getCommit() {
        return commit;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("commit")
    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("author")
    public Object getAuthor() {
        return author;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("author")
    public void setAuthor(Object author) {
        this.author = author;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("committer")
    public Object getCommitter() {
        return committer;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("committer")
    public void setCommitter(Object committer) {
        this.committer = committer;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("parents")
    public List<Parent> getParents() {
        return parents;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("parents")
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    /**
     * Minimal Repository
     * <p>
     * Minimal Repository
     * (Required)
     *
     */
    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    /**
     * Minimal Repository
     * <p>
     * Minimal Repository
     * (Required)
     *
     */
    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * Search Result Text Matches
     * <p>
     *
     *
     */
    @JsonProperty("text_matches")
    public List<TextMatch> getTextMatches() {
        return textMatches;
    }

    /**
     * Search Result Text Matches
     * <p>
     *
     *
     */
    @JsonProperty("text_matches")
    public void setTextMatches(List<TextMatch> textMatches) {
        this.textMatches = textMatches;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommitItem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("sha");
        sb.append('=');
        sb.append(((this.sha == null)?"<null>":this.sha));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null)?"<null>":this.htmlUrl));
        sb.append(',');
        sb.append("commentsUrl");
        sb.append('=');
        sb.append(((this.commentsUrl == null)?"<null>":this.commentsUrl));
        sb.append(',');
        sb.append("commit");
        sb.append('=');
        sb.append(((this.commit == null)?"<null>":this.commit));
        sb.append(',');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("committer");
        sb.append('=');
        sb.append(((this.committer == null)?"<null>":this.committer));
        sb.append(',');
        sb.append("parents");
        sb.append('=');
        sb.append(((this.parents == null)?"<null>":this.parents));
        sb.append(',');
        sb.append("repository");
        sb.append('=');
        sb.append(((this.repository == null)?"<null>":this.repository));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("nodeId");
        sb.append('=');
        sb.append(((this.nodeId == null)?"<null>":this.nodeId));
        sb.append(',');
        sb.append("textMatches");
        sb.append('=');
        sb.append(((this.textMatches == null)?"<null>":this.textMatches));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.author == null)? 0 :this.author.hashCode()));
        result = ((result* 31)+((this.htmlUrl == null)? 0 :this.htmlUrl.hashCode()));
        result = ((result* 31)+((this.commit == null)? 0 :this.commit.hashCode()));
        result = ((result* 31)+((this.textMatches == null)? 0 :this.textMatches.hashCode()));
        result = ((result* 31)+((this.repository == null)? 0 :this.repository.hashCode()));
        result = ((result* 31)+((this.sha == null)? 0 :this.sha.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.commentsUrl == null)? 0 :this.commentsUrl.hashCode()));
        result = ((result* 31)+((this.committer == null)? 0 :this.committer.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.nodeId == null)? 0 :this.nodeId.hashCode()));
        result = ((result* 31)+((this.parents == null)? 0 :this.parents.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CommitItem) == false) {
            return false;
        }
        CommitItem rhs = ((CommitItem) other);
        return ((((((((((((((this.author == rhs.author)||((this.author!= null)&&this.author.equals(rhs.author)))&&((this.htmlUrl == rhs.htmlUrl)||((this.htmlUrl!= null)&&this.htmlUrl.equals(rhs.htmlUrl))))&&((this.commit == rhs.commit)||((this.commit!= null)&&this.commit.equals(rhs.commit))))&&((this.textMatches == rhs.textMatches)||((this.textMatches!= null)&&this.textMatches.equals(rhs.textMatches))))&&((this.repository == rhs.repository)||((this.repository!= null)&&this.repository.equals(rhs.repository))))&&((this.sha == rhs.sha)||((this.sha!= null)&&this.sha.equals(rhs.sha))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.commentsUrl == rhs.commentsUrl)||((this.commentsUrl!= null)&&this.commentsUrl.equals(rhs.commentsUrl))))&&((this.committer == rhs.committer)||((this.committer!= null)&&this.committer.equals(rhs.committer))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.nodeId == rhs.nodeId)||((this.nodeId!= null)&&this.nodeId.equals(rhs.nodeId))))&&((this.parents == rhs.parents)||((this.parents!= null)&&this.parents.equals(rhs.parents))));
    }

}
