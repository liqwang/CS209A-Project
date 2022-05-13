package edu.sustech.search.engine.github.models.githubapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.user.User;

import javax.annotation.processing.Generated;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *  GitHub apps are a new way to extend GitHub. They can be installed directly on organizations and user accounts and granted access to specific repositories. They come with granular permissions and built-in webhooks. GitHub apps are first class actors within GitHub.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "slug",
        "node_id",
        "owner",
        "name",
        "description",
        "external_url",
        "html_url",
        "created_at",
        "updated_at",
        "permissions",
        "events",
        "installations_count",
        "client_id",
        "client_secret",
        "webhook_secret",
        "pem"
})
@Generated("by hand, lol") //J2P not working!
public class GitHubApp {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    private Integer id;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("slug")
    private String slug;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_id")
    private String nodeId;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("owner")
    private User owner;

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
    @JsonProperty("description")
    private String description;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("external_url")
    private URI externalUrl;

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
    @JsonProperty("created_at")
    private Date createdAt;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("updated_at")
    private Date updatedAt;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("permissions")
    private Permissions permissions;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("events")
    private List<String> events = new ArrayList<>();

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("installations_count")
    private Integer installationsCount;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_id")
    private String clientId;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("client_secret")
    private String clientSecret;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("webhook_secret")
    private String webhookSecret;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("pem")
    private String pem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URI getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(URI externalUrl) {
        this.externalUrl = externalUrl;
    }

    public URI getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public Integer getInstallationsCount() {
        return installationsCount;
    }

    public void setInstallationsCount(Integer installationsCount) {
        this.installationsCount = installationsCount;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getWebhookSecret() {
        return webhookSecret;
    }

    public void setWebhookSecret(String webhookSecret) {
        this.webhookSecret = webhookSecret;
    }

    public String getPem() {
        return pem;
    }

    public void setPem(String pem) {
        this.pem = pem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GitHubApp)) return false;
        GitHubApp gitHubApp = (GitHubApp) o;
        return Objects.equals(id, gitHubApp.id) && Objects.equals(slug, gitHubApp.slug) && Objects.equals(nodeId, gitHubApp.nodeId) && Objects.equals(owner, gitHubApp.owner) && Objects.equals(name, gitHubApp.name) && Objects.equals(description, gitHubApp.description) && Objects.equals(externalUrl, gitHubApp.externalUrl) && Objects.equals(htmlUrl, gitHubApp.htmlUrl) && Objects.equals(createdAt, gitHubApp.createdAt) && Objects.equals(updatedAt, gitHubApp.updatedAt) && Objects.equals(permissions, gitHubApp.permissions) && Objects.equals(events, gitHubApp.events) && Objects.equals(installationsCount, gitHubApp.installationsCount) && Objects.equals(clientId, gitHubApp.clientId) && Objects.equals(clientSecret, gitHubApp.clientSecret) && Objects.equals(webhookSecret, gitHubApp.webhookSecret) && Objects.equals(pem, gitHubApp.pem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, nodeId, owner, name, description, externalUrl, htmlUrl, createdAt, updatedAt, permissions, events, installationsCount, clientId, clientSecret, webhookSecret, pem);
    }
}
