package edu.sustech.backend.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BackendStatus {
    @JsonProperty("sample_number")
    private Integer sampleNumber = 0;

    @JsonProperty("query_request_count")
    private Integer queryRequestCount;

}
