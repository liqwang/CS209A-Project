
package edu.sustech.search.engine.github.models.label;

import com.fasterxml.jackson.annotation.*;
import edu.sustech.search.engine.github.models.AppendableResult;

import javax.annotation.processing.Generated;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total_count",
    "incomplete_results",
    "items"
})
@Generated("jsonschema2pojo")
public class LabelResult implements AppendableResult, Iterable<Label> {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("total_count")
    private Integer totalCount;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("incomplete_results")
    private Boolean incompleteResults;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("items")
    private List<Label> labels = new ArrayList<Label>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("total_count")
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("total_count")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("incomplete_results")
    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("incomplete_results")
    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("items")
    public List<Label> getItems() {
        return labels;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("items")
    public void setItems(List<Label> labels) {
        this.labels = labels;
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
        sb.append(LabelResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("totalCount");
        sb.append('=');
        sb.append(((this.totalCount == null)?"<null>":this.totalCount));
        sb.append(',');
        sb.append("incompleteResults");
        sb.append('=');
        sb.append(((this.incompleteResults == null)?"<null>":this.incompleteResults));
        sb.append(',');
        sb.append("items");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
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
        result = ((result* 31)+((this.incompleteResults == null)? 0 :this.incompleteResults.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.totalCount == null)? 0 :this.totalCount.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LabelResult) == false) {
            return false;
        }
        LabelResult rhs = ((LabelResult) other);
        return (((((this.incompleteResults == rhs.incompleteResults)||((this.incompleteResults!= null)&&this.incompleteResults.equals(rhs.incompleteResults)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.totalCount == rhs.totalCount)||((this.totalCount!= null)&&this.totalCount.equals(rhs.totalCount))))&&((this.labels == rhs.labels)||((this.labels != null)&&this.labels.equals(rhs.labels))));
    }

    @Override
    public int appendItems(AppendableResult result1) {
        int cnt = 0;

        if (result1 == null) {
            return cnt;
        }

        if (result1 instanceof LabelResult other) {
            for (Label l : other.getItems()) {
                labels.add(l);
            }
            cnt = other.getItems().size();
        }
        return cnt;
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    @Override
    public Iterator<Label> iterator() {
        return labels.iterator();
    }
}
