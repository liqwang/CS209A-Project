
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
 * Rate Limit Overview
 * <p>
 * Rate Limit Overview
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resources",
    "rate"
})
@Generated("jsonschema2pojo")
public class RateLimitResult {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("resources")
    private edu.sustech.search.engine.github.API.rate.Resources resources;
    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("rate")
    private edu.sustech.search.engine.github.API.rate.Rate rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("resources")
    public edu.sustech.search.engine.github.API.rate.Resources getResources() {
        return resources;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("resources")
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("rate")
    public edu.sustech.search.engine.github.API.rate.Rate getRate() {
        return rate;
    }

    /**
     * Rate Limit
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("rate")
    public void setRate(Rate rate) {
        this.rate = rate;
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
        sb.append(RateLimitResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("resources");
        sb.append('=');
        sb.append(((this.resources == null)?"<null>":this.resources));
        sb.append(',');
        sb.append("rate");
        sb.append('=');
        sb.append(((this.rate == null)?"<null>":this.rate));
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
        result = ((result* 31)+((this.resources == null)? 0 :this.resources.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.rate == null)? 0 :this.rate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RateLimitResult) == false) {
            return false;
        }
        RateLimitResult rhs = ((RateLimitResult) other);
        return ((((this.resources == rhs.resources)||((this.resources!= null)&&this.resources.equals(rhs.resources)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))));
    }

}
