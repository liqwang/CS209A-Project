
package edu.sustech.search.engine.github.models.topic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.AppendableResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total_count",
        "incomplete_results",
        "items"
})
@Generated("jsonschema2pojo")
public class TopicResult implements AppendableResult {

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
    private List<edu.sustech.search.engine.github.models.topic.Topic> topics = new ArrayList<edu.sustech.search.engine.github.models.topic.Topic>();
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
    public List<edu.sustech.search.engine.github.models.topic.Topic> getItems() {
        return topics;
    }

    /**
     * (Required)
     */
    @JsonProperty("items")
    public void setItems(List<edu.sustech.search.engine.github.models.topic.Topic> topics) {
        this.topics = topics;
    }

    @Override
    public int appendItems(AppendableResult result1) {
        int cnt = 0;
        if (result1 == null) {
            return cnt;
        }
        if (result1 instanceof TopicResult other) {
            for (Topic t : other.getItems()) {
                topics.add(t);
            }
            cnt = other.getItems().size();
        }
        return cnt;
    }

    @Override
    public int getItemCount() {
        return topics.size();
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
        sb.append(TopicResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append(((this.topics == null) ? "<null>" : this.topics));
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
        result = ((result * 31) + ((this.topics == null) ? 0 : this.topics.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TopicResult) == false) {
            return false;
        }
        TopicResult rhs = ((TopicResult) other);
        return (((((this.incompleteResults == rhs.incompleteResults) || ((this.incompleteResults != null) && this.incompleteResults.equals(rhs.incompleteResults))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.totalCount == rhs.totalCount) || ((this.totalCount != null) && this.totalCount.equals(rhs.totalCount)))) && ((this.topics == rhs.topics) || ((this.topics != null) && this.topics.equals(rhs.topics))));
    }

}
