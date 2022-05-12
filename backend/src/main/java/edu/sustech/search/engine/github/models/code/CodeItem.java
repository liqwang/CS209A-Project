package edu.sustech.search.engine.github.models.code;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.*;
import edu.sustech.search.engine.github.models.TextMatch;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.transformer.Transformer;


/**
 * Code Search Result Item
 * <p>
 * Code Search Result Item
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "path",
    "sha",
    "url",
    "git_url",
    "html_url",
    "repository",
    "score",
    "file_size",
    "language",
    "last_modified_at",
    "line_numbers",
    "text_matches"
})
@Generated("jsonschema2pojo")
public class CodeItem {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("path")
    private String path;
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
    @JsonProperty("url")
    private URI url;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("git_url")
    private URI gitUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("html_url")
    private URI htmlUrl;
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
    @JsonProperty("file_size")
    private Integer fileSize;
    @JsonProperty("language")
    private String language;
    @JsonProperty("last_modified_at")
    private Date lastModifiedAt;
    @JsonProperty("line_numbers")
    private List<String> lineNumbers = new ArrayList<String>();
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

    public URI getRawFileURI(){
        return Transformer.transformToRawURI(htmlUrl);
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
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
    @JsonProperty("git_url")
    public URI getGitUrl() {
        return gitUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("git_url")
    public void setGitUrl(URI gitUrl) {
        this.gitUrl = gitUrl;
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

    @JsonProperty("file_size")
    public Integer getFileSize() {
        return fileSize;
    }

    @JsonProperty("file_size")
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("last_modified_at")
    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    @JsonProperty("last_modified_at")
    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    @JsonProperty("line_numbers")
    public List<String> getLineNumbers() {
        return lineNumbers;
    }

    @JsonProperty("line_numbers")
    public void setLineNumbers(List<String> lineNumbers) {
        this.lineNumbers = lineNumbers;
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
        sb.append(CodeItem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
        sb.append(',');
        sb.append("sha");
        sb.append('=');
        sb.append(((this.sha == null)?"<null>":this.sha));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("gitUrl");
        sb.append('=');
        sb.append(((this.gitUrl == null)?"<null>":this.gitUrl));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null)?"<null>":this.htmlUrl));
        sb.append(',');
        sb.append("repository");
        sb.append('=');
        sb.append(((this.repository == null)?"<null>":this.repository));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("fileSize");
        sb.append('=');
        sb.append(((this.fileSize == null)?"<null>":this.fileSize));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("lastModifiedAt");
        sb.append('=');
        sb.append(((this.lastModifiedAt == null)?"<null>":this.lastModifiedAt));
        sb.append(',');
        sb.append("lineNumbers");
        sb.append('=');
        sb.append(((this.lineNumbers == null)?"<null>":this.lineNumbers));
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
        result = ((result* 31)+((this.lineNumbers == null)? 0 :this.lineNumbers.hashCode()));
        result = ((result* 31)+((this.lastModifiedAt == null)? 0 :this.lastModifiedAt.hashCode()));
        result = ((result* 31)+((this.htmlUrl == null)? 0 :this.htmlUrl.hashCode()));
        result = ((result* 31)+((this.textMatches == null)? 0 :this.textMatches.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.repository == null)? 0 :this.repository.hashCode()));
        result = ((result* 31)+((this.sha == null)? 0 :this.sha.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.path == null)? 0 :this.path.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.fileSize == null)? 0 :this.fileSize.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.gitUrl == null)? 0 :this.gitUrl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CodeItem) == false) {
            return false;
        }
        CodeItem rhs = ((CodeItem) other);
        return (((((((((((((((this.lineNumbers == rhs.lineNumbers)||((this.lineNumbers!= null)&&this.lineNumbers.equals(rhs.lineNumbers)))&&((this.lastModifiedAt == rhs.lastModifiedAt)||((this.lastModifiedAt!= null)&&this.lastModifiedAt.equals(rhs.lastModifiedAt))))&&((this.htmlUrl == rhs.htmlUrl)||((this.htmlUrl!= null)&&this.htmlUrl.equals(rhs.htmlUrl))))&&((this.textMatches == rhs.textMatches)||((this.textMatches!= null)&&this.textMatches.equals(rhs.textMatches))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.repository == rhs.repository)||((this.repository!= null)&&this.repository.equals(rhs.repository))))&&((this.sha == rhs.sha)||((this.sha!= null)&&this.sha.equals(rhs.sha))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.path == rhs.path)||((this.path!= null)&&this.path.equals(rhs.path))))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.fileSize == rhs.fileSize)||((this.fileSize!= null)&&this.fileSize.equals(rhs.fileSize))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.gitUrl == rhs.gitUrl)||((this.gitUrl!= null)&&this.gitUrl.equals(rhs.gitUrl))));
    }

}
