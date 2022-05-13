package edu.sustech.search.engine.github.models.githubapp;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Permissions for the GitHub app
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "issues",
        "checks",
        "metadata",
        "contents",
        "deployments"
})
public class Permissions {
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("issues")
    private String issues;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("")
    private String checks;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("metadata")
    private String metadata;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("contents")
    private String contents;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("deployments")
    private String deployments;

    @JsonProperty("additional_properties")
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public String getChecks() {
        return checks;
    }

    public void setChecks(String checks) {
        this.checks = checks;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDeployments() {
        return deployments;
    }

    public void setDeployments(String deployments) {
        this.deployments = deployments;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permissions)) return false;
        Permissions that = (Permissions) o;
        return Objects.equals(issues, that.issues) && Objects.equals(checks, that.checks) && Objects.equals(metadata, that.metadata) && Objects.equals(contents, that.contents) && Objects.equals(deployments, that.deployments) && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issues, checks, metadata, contents, deployments, additionalProperties);
    }
}
