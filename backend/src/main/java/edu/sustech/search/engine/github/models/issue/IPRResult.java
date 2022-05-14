package edu.sustech.search.engine.github.models.issue;

import com.fasterxml.jackson.annotation.*;
import edu.sustech.search.engine.github.models.AppendableResult;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total_count",
        "incomplete_results",
        "items"
})
public class IPRResult implements AppendableResult, Iterable<Issue> {
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
    private List<Issue> issues = new ArrayList<Issue>();
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
    public List<Issue> getItems() {
        return issues;
    }

    /**
     * (Required)
     */
    @JsonProperty("items")
    public void setItems(List<Issue> issues) {
        this.issues = issues;
    }


    @Override
    public int appendItems(AppendableResult result1) {
        int cnt = 0;

        if (result1 == null) {
            return cnt;
        }

        if (result1 instanceof IPRResult other) {
            for (Issue i : other.getItems()) {
                issues.add(i);
            }
            cnt = other.getItems().size();
        }
        return cnt;
    }

    @Override
    public int getItemCount() {
        return issues.size();
    }

    @Override
    public Iterator<Issue> iterator() {
        return issues.iterator();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
