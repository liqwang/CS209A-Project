
package edu.sustech.search.engine.github.models.content;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.transformer.Transformer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "size",
        "name",
        "path",
        "content",
        "sha",
        "url",
        "git_url",
        "html_url",
        "download_url",
        "_links"
})
@Generated("jsonschema2pojo")
public class ContentDirectory extends RawContent {

    /**
     * (Required)
     */
    @JsonProperty("type")
    private String type;
    /**
     * (Required)
     */
    @JsonProperty("size")
    private Integer size;
    /**
     * (Required)
     */
    @JsonProperty("name")
    private String name;
    /**
     * (Required)
     */
    @JsonProperty("path")
    private String path;
    @JsonProperty("content")
    private String content;
    /**
     * (Required)
     */
    @JsonProperty("sha")
    private String sha;
    /**
     * (Required)
     */
    @JsonProperty("url")
    private URI url;
    /**
     * (Required)
     */
    @JsonProperty("git_url")
    private URI gitUrl;
    /**
     * (Required)
     */
    @JsonProperty("html_url")
    private URI htmlUrl;
    /**
     * (Required)
     */
    @JsonProperty("download_url")
    private URI downloadUrl;
    /**
     * (Required)
     */
    @JsonProperty("_links")
    private edu.sustech.search.engine.github.models.content.Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public URI getRawFileURI() {
        return Transformer.transformToRawURI(htmlUrl);
    }

    /**
     * (Required)
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * (Required)
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * (Required)
     */
    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    /**
     * (Required)
     */
    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * (Required)
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * (Required)
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * (Required)
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * (Required)
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * (Required)
     */
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    /**
     * (Required)
     */
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * (Required)
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * (Required)
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * (Required)
     */
    @JsonProperty("git_url")
    public URI getGitUrl() {
        return gitUrl;
    }

    /**
     * (Required)
     */
    @JsonProperty("git_url")
    public void setGitUrl(URI gitUrl) {
        this.gitUrl = gitUrl;
    }

    /**
     * (Required)
     */
    @JsonProperty("html_url")
    public URI getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * (Required)
     */
    @JsonProperty("html_url")
    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * (Required)
     */
    @JsonProperty("download_url")
    public URI getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * (Required)
     */
    @JsonProperty("download_url")
    public void setDownloadUrl(URI downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * (Required)
     */
    @JsonProperty("_links")
    public edu.sustech.search.engine.github.models.content.Links getLinks() {
        return links;
    }

    /**
     * (Required)
     */
    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
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
        sb.append(ContentDirectory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null) ? "<null>" : this.size));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null) ? "<null>" : this.path));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null) ? "<null>" : this.content));
        sb.append(',');
        sb.append("sha");
        sb.append('=');
        sb.append(((this.sha == null) ? "<null>" : this.sha));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append(',');
        sb.append("gitUrl");
        sb.append('=');
        sb.append(((this.gitUrl == null) ? "<null>" : this.gitUrl));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null) ? "<null>" : this.htmlUrl));
        sb.append(',');
        sb.append("downloadUrl");
        sb.append('=');
        sb.append(((this.downloadUrl == null) ? "<null>" : this.downloadUrl));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null) ? "<null>" : this.links));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.htmlUrl == null) ? 0 : this.htmlUrl.hashCode()));
        result = ((result * 31) + ((this.downloadUrl == null) ? 0 : this.downloadUrl.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.sha == null) ? 0 : this.sha.hashCode()));
        result = ((result * 31) + ((this.content == null) ? 0 : this.content.hashCode()));
        result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
        result = ((result * 31) + ((this.path == null) ? 0 : this.path.hashCode()));
        result = ((result * 31) + ((this.size == null) ? 0 : this.size.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.links == null) ? 0 : this.links.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.gitUrl == null) ? 0 : this.gitUrl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContentDirectory) == false) {
            return false;
        }
        ContentDirectory rhs = ((ContentDirectory) other);
        return (((((((((((((this.htmlUrl == rhs.htmlUrl) || ((this.htmlUrl != null) && this.htmlUrl.equals(rhs.htmlUrl))) && ((this.downloadUrl == rhs.downloadUrl) || ((this.downloadUrl != null) && this.downloadUrl.equals(rhs.downloadUrl)))) && ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))) && ((this.sha == rhs.sha) || ((this.sha != null) && this.sha.equals(rhs.sha)))) && ((this.content == rhs.content) || ((this.content != null) && this.content.equals(rhs.content)))) && ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url)))) && ((this.path == rhs.path) || ((this.path != null) && this.path.equals(rhs.path)))) && ((this.size == rhs.size) || ((this.size != null) && this.size.equals(rhs.size)))) && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))) && ((this.links == rhs.links) || ((this.links != null) && this.links.equals(rhs.links)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.gitUrl == rhs.gitUrl) || ((this.gitUrl != null) && this.gitUrl.equals(rhs.gitUrl))));
    }

}
