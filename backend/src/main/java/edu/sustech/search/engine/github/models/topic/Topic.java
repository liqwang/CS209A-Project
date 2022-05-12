
package edu.sustech.search.engine.github.models.topic;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.*;
import edu.sustech.search.engine.github.models.TextMatch;
import edu.sustech.search.engine.github.models.Alias;
import edu.sustech.search.engine.github.models.Related;


/**
 * Topic Search Result Item
 * <p>
 * Topic Search Result Item
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "display_name",
    "short_description",
    "description",
    "created_by",
    "released",
    "created_at",
    "updated_at",
    "featured",
    "curated",
    "score",
    "repository_count",
    "logo_url",
    "text_matches",
    "related",
    "aliases"
})
@Generated("jsonschema2pojo")
public class Topic {

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
    @JsonProperty("display_name")
    private String displayName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("short_description")
    private String shortDescription;
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
    @JsonProperty("created_by")
    private String createdBy;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("released")
    private String released;
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
    @JsonProperty("featured")
    private Boolean featured;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curated")
    private Boolean curated;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("score")
    private Double score;
    @JsonProperty("repository_count")
    private Integer repositoryCount;
    @JsonProperty("logo_url")
    private URI logoUrl;
    /**
     * Search Result Text Matches
     * <p>
     * 
     * 
     */
    @JsonProperty("text_matches")
    private List<TextMatch> textMatches = new ArrayList<TextMatch>();
    @JsonProperty("related")
    private List<Related> related = new ArrayList<Related>();
    @JsonProperty("aliases")
    private List<Alias> aliases = new ArrayList<Alias>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("short_description")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("created_by")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("released")
    public String getReleased() {
        return released;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("released")
    public void setReleased(String released) {
        this.released = released;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("updated_at")
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("featured")
    public Boolean getFeatured() {
        return featured;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("featured")
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curated")
    public Boolean getCurated() {
        return curated;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curated")
    public void setCurated(Boolean curated) {
        this.curated = curated;
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

    @JsonProperty("repository_count")
    public Integer getRepositoryCount() {
        return repositoryCount;
    }

    @JsonProperty("repository_count")
    public void setRepositoryCount(Integer repositoryCount) {
        this.repositoryCount = repositoryCount;
    }

    @JsonProperty("logo_url")
    public URI getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("logo_url")
    public void setLogoUrl(URI logoUrl) {
        this.logoUrl = logoUrl;
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

    @JsonProperty("related")
    public List<Related> getRelated() {
        return related;
    }

    @JsonProperty("related")
    public void setRelated(List<Related> related) {
        this.related = related;
    }

    @JsonProperty("aliases")
    public List<Alias> getAliases() {
        return aliases;
    }

    @JsonProperty("aliases")
    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
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
        sb.append(Topic.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("shortDescription");
        sb.append('=');
        sb.append(((this.shortDescription == null)?"<null>":this.shortDescription));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("createdBy");
        sb.append('=');
        sb.append(((this.createdBy == null)?"<null>":this.createdBy));
        sb.append(',');
        sb.append("released");
        sb.append('=');
        sb.append(((this.released == null)?"<null>":this.released));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("featured");
        sb.append('=');
        sb.append(((this.featured == null)?"<null>":this.featured));
        sb.append(',');
        sb.append("curated");
        sb.append('=');
        sb.append(((this.curated == null)?"<null>":this.curated));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("repositoryCount");
        sb.append('=');
        sb.append(((this.repositoryCount == null)?"<null>":this.repositoryCount));
        sb.append(',');
        sb.append("logoUrl");
        sb.append('=');
        sb.append(((this.logoUrl == null)?"<null>":this.logoUrl));
        sb.append(',');
        sb.append("textMatches");
        sb.append('=');
        sb.append(((this.textMatches == null)?"<null>":this.textMatches));
        sb.append(',');
        sb.append("related");
        sb.append('=');
        sb.append(((this.related == null)?"<null>":this.related));
        sb.append(',');
        sb.append("aliases");
        sb.append('=');
        sb.append(((this.aliases == null)?"<null>":this.aliases));
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
        result = ((result* 31)+((this.featured == null)? 0 :this.featured.hashCode()));
        result = ((result* 31)+((this.aliases == null)? 0 :this.aliases.hashCode()));
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        result = ((result* 31)+((this.textMatches == null)? 0 :this.textMatches.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.shortDescription == null)? 0 :this.shortDescription.hashCode()));
        result = ((result* 31)+((this.logoUrl == null)? 0 :this.logoUrl.hashCode()));
        result = ((result* 31)+((this.repositoryCount == null)? 0 :this.repositoryCount.hashCode()));
        result = ((result* 31)+((this.createdAt == null)? 0 :this.createdAt.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.related == null)? 0 :this.related.hashCode()));
        result = ((result* 31)+((this.createdBy == null)? 0 :this.createdBy.hashCode()));
        result = ((result* 31)+((this.curated == null)? 0 :this.curated.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.released == null)? 0 :this.released.hashCode()));
        result = ((result* 31)+((this.updatedAt == null)? 0 :this.updatedAt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Topic) == false) {
            return false;
        }
        Topic rhs = ((Topic) other);
        return ((((((((((((((((((this.featured == rhs.featured)||((this.featured!= null)&&this.featured.equals(rhs.featured)))&&((this.aliases == rhs.aliases)||((this.aliases!= null)&&this.aliases.equals(rhs.aliases))))&&((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName))))&&((this.textMatches == rhs.textMatches)||((this.textMatches!= null)&&this.textMatches.equals(rhs.textMatches))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.shortDescription == rhs.shortDescription)||((this.shortDescription!= null)&&this.shortDescription.equals(rhs.shortDescription))))&&((this.logoUrl == rhs.logoUrl)||((this.logoUrl!= null)&&this.logoUrl.equals(rhs.logoUrl))))&&((this.repositoryCount == rhs.repositoryCount)||((this.repositoryCount!= null)&&this.repositoryCount.equals(rhs.repositoryCount))))&&((this.createdAt == rhs.createdAt)||((this.createdAt!= null)&&this.createdAt.equals(rhs.createdAt))))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.related == rhs.related)||((this.related!= null)&&this.related.equals(rhs.related))))&&((this.createdBy == rhs.createdBy)||((this.createdBy!= null)&&this.createdBy.equals(rhs.createdBy))))&&((this.curated == rhs.curated)||((this.curated!= null)&&this.curated.equals(rhs.curated))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.released == rhs.released)||((this.released!= null)&&this.released.equals(rhs.released))))&&((this.updatedAt == rhs.updatedAt)||((this.updatedAt!= null)&&this.updatedAt.equals(rhs.updatedAt))));
    }

}
