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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "admin",
    "maintain",
    "push",
    "triage",
    "pull"
})
@Generated("jsonschema2pojo")
public class Permissions {

    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("maintain")
    private Boolean maintain;
    @JsonProperty("push")
    private Boolean push;
    @JsonProperty("triage")
    private Boolean triage;
    @JsonProperty("pull")
    private Boolean pull;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("maintain")
    public Boolean getMaintain() {
        return maintain;
    }

    @JsonProperty("maintain")
    public void setMaintain(Boolean maintain) {
        this.maintain = maintain;
    }

    @JsonProperty("push")
    public Boolean getPush() {
        return push;
    }

    @JsonProperty("push")
    public void setPush(Boolean push) {
        this.push = push;
    }

    @JsonProperty("triage")
    public Boolean getTriage() {
        return triage;
    }

    @JsonProperty("triage")
    public void setTriage(Boolean triage) {
        this.triage = triage;
    }

    @JsonProperty("pull")
    public Boolean getPull() {
        return pull;
    }

    @JsonProperty("pull")
    public void setPull(Boolean pull) {
        this.pull = pull;
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
        sb.append(Permissions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("admin");
        sb.append('=');
        sb.append(((this.admin == null)?"<null>":this.admin));
        sb.append(',');
        sb.append("maintain");
        sb.append('=');
        sb.append(((this.maintain == null)?"<null>":this.maintain));
        sb.append(',');
        sb.append("push");
        sb.append('=');
        sb.append(((this.push == null)?"<null>":this.push));
        sb.append(',');
        sb.append("triage");
        sb.append('=');
        sb.append(((this.triage == null)?"<null>":this.triage));
        sb.append(',');
        sb.append("pull");
        sb.append('=');
        sb.append(((this.pull == null)?"<null>":this.pull));
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
        result = ((result* 31)+((this.pull == null)? 0 :this.pull.hashCode()));
        result = ((result* 31)+((this.maintain == null)? 0 :this.maintain.hashCode()));
        result = ((result* 31)+((this.admin == null)? 0 :this.admin.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.triage == null)? 0 :this.triage.hashCode()));
        result = ((result* 31)+((this.push == null)? 0 :this.push.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Permissions) == false) {
            return false;
        }
        Permissions rhs = ((Permissions) other);
        return (((((((this.pull == rhs.pull)||((this.pull!= null)&&this.pull.equals(rhs.pull)))&&((this.maintain == rhs.maintain)||((this.maintain!= null)&&this.maintain.equals(rhs.maintain))))&&((this.admin == rhs.admin)||((this.admin!= null)&&this.admin.equals(rhs.admin))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.triage == rhs.triage)||((this.triage!= null)&&this.triage.equals(rhs.triage))))&&((this.push == rhs.push)||((this.push!= null)&&this.push.equals(rhs.push))));
    }

}
