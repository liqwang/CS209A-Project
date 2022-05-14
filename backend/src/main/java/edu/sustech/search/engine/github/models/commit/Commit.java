
package edu.sustech.search.engine.github.models.commit;

import com.fasterxml.jackson.annotation.*;
import edu.sustech.search.engine.github.models.Author;

import javax.annotation.processing.Generated;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author",
    "committer",
    "comment_count",
    "message",
    "tree",
    "url",
    "verification"
})
@Generated("jsonschema2pojo")
public class Commit {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    private Author author;
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
    @JsonProperty("comment_count")
    private Integer commentCount;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    private String message;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tree")
    private Tree tree;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    private URI url;
    /**
     * Verification
     * <p>
     * 
     * 
     */
    @JsonProperty("verification")
    private Verification verification;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    public void setAuthor(Author author) {
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
    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tree")
    public Tree getTree() {
        return tree;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tree")
    public void setTree(Tree tree) {
        this.tree = tree;
    }

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
     * Verification
     * <p>
     * 
     * 
     */
    @JsonProperty("verification")
    public Verification getVerification() {
        return verification;
    }

    /**
     * Verification
     * <p>
     * 
     * 
     */
    @JsonProperty("verification")
    public void setVerification(Verification verification) {
        this.verification = verification;
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
        sb.append(Commit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("committer");
        sb.append('=');
        sb.append(((this.committer == null)?"<null>":this.committer));
        sb.append(',');
        sb.append("commentCount");
        sb.append('=');
        sb.append(((this.commentCount == null)?"<null>":this.commentCount));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("tree");
        sb.append('=');
        sb.append(((this.tree == null)?"<null>":this.tree));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("verification");
        sb.append('=');
        sb.append(((this.verification == null)?"<null>":this.verification));
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
        result = ((result* 31)+((this.committer == null)? 0 :this.committer.hashCode()));
        result = ((result* 31)+((this.author == null)? 0 :this.author.hashCode()));
        result = ((result* 31)+((this.tree == null)? 0 :this.tree.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.message == null)? 0 :this.message.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.verification == null)? 0 :this.verification.hashCode()));
        result = ((result* 31)+((this.commentCount == null)? 0 :this.commentCount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Commit) == false) {
            return false;
        }
        Commit rhs = ((Commit) other);
        return (((((((((this.committer == rhs.committer)||((this.committer!= null)&&this.committer.equals(rhs.committer)))&&((this.author == rhs.author)||((this.author!= null)&&this.author.equals(rhs.author))))&&((this.tree == rhs.tree)||((this.tree!= null)&&this.tree.equals(rhs.tree))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.message == rhs.message)||((this.message!= null)&&this.message.equals(rhs.message))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.verification == rhs.verification)||((this.verification!= null)&&this.verification.equals(rhs.verification))))&&((this.commentCount == rhs.commentCount)||((this.commentCount!= null)&&this.commentCount.equals(rhs.commentCount))));
    }

}
