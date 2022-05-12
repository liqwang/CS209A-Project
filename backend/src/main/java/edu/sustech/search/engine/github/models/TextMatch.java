
package edu.sustech.search.engine.github.models;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "object_url",
    "object_type",
    "property",
    "fragment",
    "matches"
})
@Generated("jsonschema2pojo")
public class TextMatch {

    @JsonProperty("object_url")
    private String objectUrl;
    @JsonProperty("object_type")
    private String objectType;
    @JsonProperty("property")
    private String property;
    @JsonProperty("fragment")
    private String fragment;
    @JsonProperty("matches")
    private List<edu.sustech.search.engine.github.models.Match> matches = new ArrayList<edu.sustech.search.engine.github.models.Match>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("object_url")
    public String getObjectUrl() {
        return objectUrl;
    }

    @JsonProperty("object_url")
    public void setObjectUrl(String objectUrl) {
        this.objectUrl = objectUrl;
    }

    @JsonProperty("object_type")
    public String getObjectType() {
        return objectType;
    }

    @JsonProperty("object_type")
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @JsonProperty("property")
    public String getProperty() {
        return property;
    }

    @JsonProperty("property")
    public void setProperty(String property) {
        this.property = property;
    }

    @JsonProperty("fragment")
    public String getFragment() {
        return fragment;
    }

    @JsonProperty("fragment")
    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    @JsonProperty("matches")
    public List<edu.sustech.search.engine.github.models.Match> getMatches() {
        return matches;
    }

    @JsonProperty("matches")
    public void setMatches(List<Match> matches) {
        this.matches = matches;
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
        sb.append(TextMatch.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("objectUrl");
        sb.append('=');
        sb.append(((this.objectUrl == null)?"<null>":this.objectUrl));
        sb.append(',');
        sb.append("objectType");
        sb.append('=');
        sb.append(((this.objectType == null)?"<null>":this.objectType));
        sb.append(',');
        sb.append("property");
        sb.append('=');
        sb.append(((this.property == null)?"<null>":this.property));
        sb.append(',');
        sb.append("fragment");
        sb.append('=');
        sb.append(((this.fragment == null)?"<null>":this.fragment));
        sb.append(',');
        sb.append("matches");
        sb.append('=');
        sb.append(((this.matches == null)?"<null>":this.matches));
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
        result = ((result* 31)+((this.fragment == null)? 0 :this.fragment.hashCode()));
        result = ((result* 31)+((this.objectUrl == null)? 0 :this.objectUrl.hashCode()));
        result = ((result* 31)+((this.property == null)? 0 :this.property.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.matches == null)? 0 :this.matches.hashCode()));
        result = ((result* 31)+((this.objectType == null)? 0 :this.objectType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TextMatch) == false) {
            return false;
        }
        TextMatch rhs = ((TextMatch) other);
        return (((((((this.fragment == rhs.fragment)||((this.fragment!= null)&&this.fragment.equals(rhs.fragment)))&&((this.objectUrl == rhs.objectUrl)||((this.objectUrl!= null)&&this.objectUrl.equals(rhs.objectUrl))))&&((this.property == rhs.property)||((this.property!= null)&&this.property.equals(rhs.property))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.matches == rhs.matches)||((this.matches!= null)&&this.matches.equals(rhs.matches))))&&((this.objectType == rhs.objectType)||((this.objectType!= null)&&this.objectType.equals(rhs.objectType))));
    }

}
