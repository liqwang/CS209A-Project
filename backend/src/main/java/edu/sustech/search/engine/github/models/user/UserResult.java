package edu.sustech.search.engine.github.models.user;

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
public class UserResult implements AppendableResult,
        Iterable<User> {

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
    private List<edu.sustech.search.engine.github.models.user.User> users = new ArrayList<edu.sustech.search.engine.github.models.user.User>();
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
    public List<edu.sustech.search.engine.github.models.user.User> getItems() {
        return users;
    }

    /**
     * (Required)
     */
    @JsonProperty("items")
    public void setItems(List<edu.sustech.search.engine.github.models.user.User> users) {
        this.users = users;
    }

    @Override
    public int appendItems(AppendableResult result1) {
        int cnt = 0;

        if (result1 == null) {
            return cnt;
        }

        if (result1 instanceof UserResult other) {
            for (User u : other.getItems()) {
                users.add(u);
            }
            cnt = other.getItems().size();
        }
        return cnt;
    }

    @Override
    public int getItemCount() {
        return users.size();
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
        sb.append(UserResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append(((this.users == null) ? "<null>" : this.users));
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
        result = ((result * 31) + ((this.users == null) ? 0 : this.users.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserResult) == false) {
            return false;
        }
        UserResult rhs = ((UserResult) other);
        return (((((this.incompleteResults == rhs.incompleteResults) || ((this.incompleteResults != null) && this.incompleteResults.equals(rhs.incompleteResults))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.totalCount == rhs.totalCount) || ((this.totalCount != null) && this.totalCount.equals(rhs.totalCount)))) && ((this.users == rhs.users) || ((this.users != null) && this.users.equals(rhs.users))));
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}
