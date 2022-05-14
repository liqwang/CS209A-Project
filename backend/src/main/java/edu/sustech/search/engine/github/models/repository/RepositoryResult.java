
package edu.sustech.search.engine.github.models.repository;

import java.util.*;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.AppendableResult;
import edu.sustech.search.engine.github.models.code.CodeItem;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total_count",
        "incomplete_results",
        "items"
})
@Generated("jsonschema2pojo")
public class RepositoryResult implements AppendableResult,
        Iterable<Repository> {

    /**
     * (Required)
     */
    @JsonProperty("total_count")
    private Integer totalCount;
    /**
     * (Required)
     */
    @JsonProperty("incomplete_results")
    private Boolean incompleteResults;
    /**
     * (Required)
     */
    @JsonProperty("items")
    private List<Repository> repositories = new ArrayList<edu.sustech.search.engine.github.models.repository.Repository>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * (Required)
     */
    @JsonProperty("total_count")
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * (Required)
     */
    @JsonProperty("total_count")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * (Required)
     */
    @JsonProperty("incomplete_results")
    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    /**
     * (Required)
     */
    @JsonProperty("incomplete_results")
    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    /**
     * (Required)
     */
    @JsonProperty("items")
    public List<Repository> getItems() {
        return repositories;
    }

    /**
     * (Required)
     */
    @JsonProperty("items")
    public void setItems(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public int appendItems(AppendableResult result1) {
        int cnt = 0;

        if (result1 == null) {
            return cnt;
        }

        if (result1 instanceof RepositoryResult other) {
            for (Repository r : other.getItems()) {
                repositories.add(r);
            }
            cnt = other.getItems().size();
        }
        return cnt;
    }

    @Override
    public int getItemCount() {
        return repositories.size();
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
        sb.append(RepositoryResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("totalCount");
        sb.append('=');
        sb.append(((this.totalCount == null) ? "<null>" : this.totalCount));
        sb.append(',');
        sb.append("incompleteResults");
        sb.append('=');
        sb.append(((this.incompleteResults == null) ? "<null>" : this.incompleteResults));
        sb.append(',');
        sb.append("items");
        sb.append('=');
        sb.append(((this.repositories == null) ? "<null>" : this.repositories));
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
        result = ((result * 31) + ((this.incompleteResults == null) ? 0 : this.incompleteResults.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.totalCount == null) ? 0 : this.totalCount.hashCode()));
        result = ((result * 31) + ((this.repositories == null) ? 0 : this.repositories.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RepositoryResult) == false) {
            return false;
        }
        RepositoryResult rhs = ((RepositoryResult) other);
        return (((((this.incompleteResults == rhs.incompleteResults) || ((this.incompleteResults != null) && this.incompleteResults.equals(rhs.incompleteResults))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.totalCount == rhs.totalCount) || ((this.totalCount != null) && this.totalCount.equals(rhs.totalCount)))) && ((this.repositories == rhs.repositories) || ((this.repositories != null) && this.repositories.equals(rhs.repositories))));
    }

    @Override
    public Iterator<Repository> iterator() {
        return repositories.iterator();
    }
}
