package edu.sustech.search.engine.github.models.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawContent {
    public enum Type {
        File, Directory, Symlink, Undefined
    }

    public Type getTargetType() {
        if (type.equals("file")) {
            return Type.File;
        }
        if (type.equals("directory")) {
            return Type.Directory;
        }
        if (type.equals("Symlink")) {
            return Type.Directory;
        }
        return Type.Undefined;
    }

    @JsonProperty("type")
    private String type;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("name")
    private String name;

    @JsonProperty("path")
    private String path;

    @JsonProperty("sha")
    private String sha;

    @JsonProperty("url")
    private URI url;

    @JsonProperty("git_url")
    private URI gitUrl;

    @JsonProperty("html_url")
    private URI htmlUrl;

    @JsonProperty("download_url")
    private URI downloadUrl;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    @JsonProperty("git_url")
    public URI getGitUrl() {
        return gitUrl;
    }

    @JsonProperty("git_url")
    public void setGitUrl(URI gitUrl) {
        this.gitUrl = gitUrl;
    }

    @JsonProperty("html_url")
    public URI getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("download_url")
    public URI getDownloadUrl() {
        return downloadUrl;
    }

    @JsonProperty("download_url")
    public void setDownloadUrl(URI downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
