
package edu.sustech.search.engine.github.API.rate;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Rate Limit
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limit",
    "remaining",
    "reset",
    "used"
})
@Generated("jsonschema2pojo")
public class Core {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    private Integer limit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("remaining")
    private Integer remaining;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reset")
    private Integer reset;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("used")
    private Integer used;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("remaining")
    public Integer getRemaining() {
        return remaining;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("remaining")
    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reset")
    public Integer getReset() {
        return reset;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reset")
    public void setReset(Integer reset) {
        this.reset = reset;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("used")
    public Integer getUsed() {
        return used;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("used")
    public void setUsed(Integer used) {
        this.used = used;
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
        sb.append(Core.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("limit");
        sb.append('=');
        sb.append(((this.limit == null)?"<null>":this.limit));
        sb.append(',');
        sb.append("remaining");
        sb.append('=');
        sb.append(((this.remaining == null)?"<null>":this.remaining));
        sb.append(',');
        sb.append("reset");
        sb.append('=');
        sb.append(((this.reset == null)?"<null>":this.reset));
        sb.append(',');
        sb.append("used");
        sb.append('=');
        sb.append(((this.used == null)?"<null>":this.used));
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
        result = ((result* 31)+((this.limit == null)? 0 :this.limit.hashCode()));
        result = ((result* 31)+((this.reset == null)? 0 :this.reset.hashCode()));
        result = ((result* 31)+((this.used == null)? 0 :this.used.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.remaining == null)? 0 :this.remaining.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Core) == false) {
            return false;
        }
        Core rhs = ((Core) other);
        return ((((((this.limit == rhs.limit)||((this.limit!= null)&&this.limit.equals(rhs.limit)))&&((this.reset == rhs.reset)||((this.reset!= null)&&this.reset.equals(rhs.reset))))&&((this.used == rhs.used)||((this.used!= null)&&this.used.equals(rhs.used))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.remaining == rhs.remaining)||((this.remaining!= null)&&this.remaining.equals(rhs.remaining))));
    }

}
