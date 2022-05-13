package edu.sustech.search.engine.github.models;

/**
 * Repo Search Result Item
 * <p>
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.net.URI;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "total_count",
        "+1",
        "-1",
        "laugh",
        "confused",
        "heart",
        "hooray",
        "eyes",
        "rocket"
})
public class Reactions {
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("url")
    private URI url;

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
    @JsonProperty("+1")
    private Integer plusOne;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("-1")
    private Integer minusOne;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("laugh")
    private Integer laugh;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("confused")
    private Integer confused;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("heart")
    private Integer heart;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("hooray")
    private Integer hooray;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("eyes")
    private Integer eyes;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("rocket")
    private Integer rocket;

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(Integer plusOne) {
        this.plusOne = plusOne;
    }

    public Integer getMinusOne() {
        return minusOne;
    }

    public void setMinusOne(Integer minusOne) {
        this.minusOne = minusOne;
    }

    public Integer getLaugh() {
        return laugh;
    }

    public void setLaugh(Integer laugh) {
        this.laugh = laugh;
    }

    public Integer getConfused() {
        return confused;
    }

    public void setConfused(Integer confused) {
        this.confused = confused;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    public Integer getHooray() {
        return hooray;
    }

    public void setHooray(Integer hooray) {
        this.hooray = hooray;
    }

    public Integer getEyes() {
        return eyes;
    }

    public void setEyes(Integer eyes) {
        this.eyes = eyes;
    }

    public Integer getRocket() {
        return rocket;
    }

    public void setRocket(Integer rocket) {
        this.rocket = rocket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reactions)) return false;
        Reactions reactions = (Reactions) o;
        return Objects.equals(url, reactions.url) && Objects.equals(totalCount, reactions.totalCount) && Objects.equals(plusOne, reactions.plusOne) && Objects.equals(minusOne, reactions.minusOne) && Objects.equals(laugh, reactions.laugh) && Objects.equals(confused, reactions.confused) && Objects.equals(heart, reactions.heart) && Objects.equals(hooray, reactions.hooray) && Objects.equals(eyes, reactions.eyes) && Objects.equals(rocket, reactions.rocket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, totalCount, plusOne, minusOne, laugh, confused, heart, hooray, eyes, rocket);
    }
}
