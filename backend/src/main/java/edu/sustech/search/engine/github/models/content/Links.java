
package edu.sustech.search.engine.github.models.content;

import java.net.URI;
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
    "git",
    "html",
    "self"
})
@Generated("jsonschema2pojo")
public class Links {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("git")
    private URI git;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("html")
    private URI html;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("self")
    private URI self;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("git")
    public URI getGit() {
        return git;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("git")
    public void setGit(URI git) {
        this.git = git;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("html")
    public URI getHtml() {
        return html;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("html")
    public void setHtml(URI html) {
        this.html = html;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("self")
    public URI getSelf() {
        return self;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("self")
    public void setSelf(URI self) {
        this.self = self;
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
        sb.append(Links.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("git");
        sb.append('=');
        sb.append(((this.git == null)?"<null>":this.git));
        sb.append(',');
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("self");
        sb.append('=');
        sb.append(((this.self == null)?"<null>":this.self));
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
        result = ((result* 31)+((this.self == null)? 0 :this.self.hashCode()));
        result = ((result* 31)+((this.html == null)? 0 :this.html.hashCode()));
        result = ((result* 31)+((this.git == null)? 0 :this.git.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return (((((this.self == rhs.self)||((this.self!= null)&&this.self.equals(rhs.self)))&&((this.html == rhs.html)||((this.html!= null)&&this.html.equals(rhs.html))))&&((this.git == rhs.git)||((this.git!= null)&&this.git.equals(rhs.git))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
