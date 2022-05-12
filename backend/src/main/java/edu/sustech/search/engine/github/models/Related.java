
package edu.sustech.search.engine.github.models;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.topic.TopicRelation;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "topic_relation"
})
@Generated("jsonschema2pojo")
public class Related {

    @JsonProperty("topic_relation")
    private TopicRelation topicRelation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("topic_relation")
    public TopicRelation getTopicRelation() {
        return topicRelation;
    }

    @JsonProperty("topic_relation")
    public void setTopicRelation(TopicRelation topicRelation) {
        this.topicRelation = topicRelation;
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
        sb.append(Related.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("topicRelation");
        sb.append('=');
        sb.append(((this.topicRelation == null)?"<null>":this.topicRelation));
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
        result = ((result* 31)+((this.topicRelation == null)? 0 :this.topicRelation.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Related) == false) {
            return false;
        }
        Related rhs = ((Related) other);
        return (((this.topicRelation == rhs.topicRelation)||((this.topicRelation!= null)&&this.topicRelation.equals(rhs.topicRelation)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
