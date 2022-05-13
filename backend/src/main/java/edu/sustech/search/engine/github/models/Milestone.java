package edu.sustech.search.engine.github.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.user.User;

import java.net.URI;
import java.util.Date;
import java.util.Objects;

/**
 * A collection of related issues and pull requests.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "html_url",
        "labels_url",
        "id",
        "node_id",
        "number",
        "state",
        "title",
        "description",
        "creator",
        "open_issues",
        "closed_issues",
        "created_at",
        "updated_at",
        "closed_at",
        "due_on"
})
public class Milestone {
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
    @JsonProperty("html_url")
    private URI htmlUrl;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("labels_url")
    private URI labelsUrl;

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
    @JsonProperty("node_id")
    private String nodeId;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("number")
    private Integer number;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("state")
    private State state;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("title")
    private String title;

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
    @JsonProperty("creator")
    private User creator;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("open_issues")
    private Integer openIssues;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("closed_issues")
    private Integer closedIssues;

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
    @JsonProperty("closed_at")
    private Date closedAt;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("due_on")
    private Date dueOn;


    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public URI getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public URI getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(URI labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Integer getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(Integer openIssues) {
        this.openIssues = openIssues;
    }

    public Integer getClosedIssues() {
        return closedIssues;
    }

    public void setClosedIssues(Integer closedIssues) {
        this.closedIssues = closedIssues;
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

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public Date getDueOn() {
        return dueOn;
    }

    public void setDueOn(Date dueOn) {
        this.dueOn = dueOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milestone)) return false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(url, milestone.url) && Objects.equals(htmlUrl, milestone.htmlUrl) && Objects.equals(labelsUrl, milestone.labelsUrl) && Objects.equals(id, milestone.id) && Objects.equals(nodeId, milestone.nodeId) && Objects.equals(number, milestone.number) && state == milestone.state && Objects.equals(title, milestone.title) && Objects.equals(description, milestone.description) && Objects.equals(creator, milestone.creator) && Objects.equals(openIssues, milestone.openIssues) && Objects.equals(closedIssues, milestone.closedIssues) && Objects.equals(createdAt, milestone.createdAt) && Objects.equals(updatedAt, milestone.updatedAt) && Objects.equals(closedAt, milestone.closedAt) && Objects.equals(dueOn, milestone.dueOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, htmlUrl, labelsUrl, id, nodeId, number, state, title, description, creator, openIssues, closedIssues, createdAt, updatedAt, closedAt, dueOn);
    }
}
