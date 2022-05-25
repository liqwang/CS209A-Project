package edu.sustech.backend.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerStatus {

    public ServerStatus(){

    }

    public ServerStatus(Integer sampleEntries,
                        Integer requestCount,
                        String currentUpdateStatus,
                        Integer sampleSize){
        this.sampledEntries = sampleEntries;
        this.requestCount = requestCount;
        this.currentUpdateStatus = currentUpdateStatus;
        this.sampleSize = sampleSize;
    }

    @JsonProperty("sampledEntries")
    private Integer sampledEntries;

    @JsonProperty("requestCount")
    private Integer requestCount;

    @JsonProperty("currentUpdateStatus")
    private String currentUpdateStatus;

    @JsonProperty("sampleSize")
    private Integer sampleSize;

    public Integer getSampledEntries() {
        return sampledEntries;
    }

    public void setSampledEntries(Integer sampledEntries) {
        this.sampledEntries = sampledEntries;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public String getCurrentUpdateStatus() {
        return currentUpdateStatus;
    }

    public void setCurrentUpdateStatus(String currentUpdateStatus) {
        this.currentUpdateStatus = currentUpdateStatus;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }
}
