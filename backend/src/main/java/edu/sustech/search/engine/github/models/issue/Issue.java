package edu.sustech.search.engine.github.models.issue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.*;
import edu.sustech.search.engine.github.models.githubapp.GitHubApp;
import edu.sustech.search.engine.github.models.label.Label;
import edu.sustech.search.engine.github.models.pullrequests.PullRequest;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.user.User;

import javax.annotation.processing.Generated;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Issue Search Result Item
 * <p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "repository_url",
        "labels_url",
        "comments_url",
        "events_url",
        "html_url",
        "id",
        "node_id",
        "number",
        "title",
        "locked",
        "active_lock_reason",
        "assignees",
        "user",
        "labels",
        "state",
        "assignee",
        "milestone",
        "comments",
        "created_at",
        "updated_at",
        "closed_at",
        "text_matches",
        "pull_request",
        "body",
        "score",
        "author_association",
        "draft",
        "repository",
        "body_html",
        "body_text",
        "timeline_url",
        "performed_via_github_app",
        "reactions"
})
@Generated("by hand, lol")
public class Issue {
    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public URI getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(URI repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public URI getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(URI commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public URI getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(URI eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public URI getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getActiveLockReason() {
        return activeLockReason;
    }

    public void setActiveLockReason(String activeLockReason) {
        this.activeLockReason = activeLockReason;
    }

    public List<User> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<User> assignees) {
        this.assignees = assignees;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
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

    public List<TextMatch> getTextMatches() {
        return textMatches;
    }

    public void setTextMatches(List<TextMatch> textMatches) {
        this.textMatches = textMatches;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(PullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public AuthorAssociation getAuthorAssociation() {
        return authorAssociation;
    }

    public void setAuthorAssociation(AuthorAssociation authorAssociation) {
        this.authorAssociation = authorAssociation;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public URI getTimelineUrl() {
        return timelineUrl;
    }

    public void setTimelineUrl(URI timelineUrl) {
        this.timelineUrl = timelineUrl;
    }

    public GitHubApp getGitHubApp() {
        return gitHubApp;
    }

    public void setGitHubApp(GitHubApp gitHubApp) {
        this.gitHubApp = gitHubApp;
    }

    public Reactions getReactions() {
        return reactions;
    }

    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }

    /**
     * (Required)
     */
    @JsonProperty("url")
    private URI url;

    /**
     * (Required)
     */
    @JsonProperty("repository_url")
    private URI repositoryUrl;

    /**
     * (Required)
     */
    @JsonProperty("labels_url")
    private String labelsUrl;

    /**
     * (Required)
     */
    @JsonProperty("comments_url")
    private URI commentsUrl;

    /**
     * (Required)
     */
    @JsonProperty("events_url")
    private URI eventsUrl;

    /**
     * (Required)
     */
    @JsonProperty("html_url")
    private URI htmlUrl;

    /**
     * (Required)
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * (Required)
     */
    @JsonProperty("node_id")
    private String nodeId;

    /**
     * (Required)
     */
    @JsonProperty("number")
    private Integer number;

    /**
     * (Required)
     */
    @JsonProperty("title")
    private String title;

    /**
     * (Required)
     */
    @JsonProperty("locked")
    private Boolean locked;

    /**
     * (Required)
     */
    @JsonProperty("active_lock_reason")
    private String activeLockReason;

    /**
     * (Required)
     */
    @JsonProperty("assignees")
    private List<User> assignees = new ArrayList<>();

    /**
     * (Required)
     */
    @JsonProperty("user")
    private User user;

    /**
     * (Required)
     */
    @JsonProperty("labels")
    private List<Label> labels = new ArrayList<>();

    /**
     * (Required)
     */
    @JsonProperty("state")
    private State state;

    /**
     * (Required)
     */
    @JsonProperty("assignee")
    private User assignee;

    /**
     * (Required)
     */
    @JsonProperty("milestone")
    private Milestone milestone;

    /**
     * (Required)
     */
    @JsonProperty("comments")
    private Integer comments;

    /**
     * (Required)
     */
    @JsonProperty("created_at")
    private Date createdAt;

    /**
     * (Required)
     */
    @JsonProperty("updated_at")
    private Date updatedAt;

    /**
     * (Required)
     */
    @JsonProperty("closed_at")
    private Date closedAt;

    /**
     * (Required)
     */
    @JsonProperty("text_matches")
    private List<TextMatch> textMatches = new ArrayList<>();

    /**
     * (Required)
     */
    @JsonProperty("pull_request")
    private PullRequest pullRequest;

    /**
     * (Required)
     */
    @JsonProperty("body")
    private String body;

    /**
     * (Required)
     */
    @JsonProperty("score")
    private Double score;

    /**
     * (Required)
     */
    @JsonProperty("author_association")
    private AuthorAssociation authorAssociation;

    /**
     * (Required)
     */
    @JsonProperty("draft")
    private Boolean draft;

    /**
     * (Required)
     */
    @JsonProperty("repository")
    private Repository repository;

    /**
     * (Required)
     */
    @JsonProperty("body_html")
    private String bodyHtml;

    /**
     * (Required)
     */
    @JsonProperty("body_text")
    private String bodyText;

    /**
     * (Required)
     */
    @JsonProperty("timeline_url")
    private URI timelineUrl;

    /**
     * (Required)
     */
    @JsonProperty("performed_via_github_app")
    private GitHubApp gitHubApp;

    @JsonProperty("reactions")
    private Reactions reactions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        Issue issue = (Issue) o;
        return Objects.equals(url, issue.url) && Objects.equals(repositoryUrl, issue.repositoryUrl) && Objects.equals(labelsUrl, issue.labelsUrl) && Objects.equals(commentsUrl, issue.commentsUrl) && Objects.equals(eventsUrl, issue.eventsUrl) && Objects.equals(htmlUrl, issue.htmlUrl) && Objects.equals(id, issue.id) && Objects.equals(nodeId, issue.nodeId) && Objects.equals(number, issue.number) && Objects.equals(title, issue.title) && Objects.equals(locked, issue.locked) && Objects.equals(activeLockReason, issue.activeLockReason) && Objects.equals(assignees, issue.assignees) && Objects.equals(user, issue.user) && Objects.equals(labels, issue.labels) && state == issue.state && Objects.equals(assignee, issue.assignee) && Objects.equals(milestone, issue.milestone) && Objects.equals(comments, issue.comments) && Objects.equals(createdAt, issue.createdAt) && Objects.equals(updatedAt, issue.updatedAt) && Objects.equals(closedAt, issue.closedAt) && Objects.equals(textMatches, issue.textMatches) && Objects.equals(pullRequest, issue.pullRequest) && Objects.equals(body, issue.body) && Objects.equals(score, issue.score) && authorAssociation == issue.authorAssociation && Objects.equals(draft, issue.draft) && Objects.equals(repository, issue.repository) && Objects.equals(bodyHtml, issue.bodyHtml) && Objects.equals(bodyText, issue.bodyText) && Objects.equals(timelineUrl, issue.timelineUrl) && Objects.equals(gitHubApp, issue.gitHubApp) && Objects.equals(reactions, issue.reactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, repositoryUrl, labelsUrl, commentsUrl, eventsUrl, htmlUrl, id, nodeId, number, title, locked, activeLockReason, assignees, user, labels, state, assignee, milestone, comments, createdAt, updatedAt, closedAt, textMatches, pullRequest, body, score, authorAssociation, draft, repository, bodyHtml, bodyText, timelineUrl, gitHubApp, reactions);
    }
}
