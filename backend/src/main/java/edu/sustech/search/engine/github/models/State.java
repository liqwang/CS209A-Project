package edu.sustech.search.engine.github.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum State {
    @JsonProperty("open") Open,
    @JsonProperty("closed") Closed
}
