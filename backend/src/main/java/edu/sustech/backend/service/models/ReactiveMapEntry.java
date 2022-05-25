package edu.sustech.backend.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReactiveMapEntry {

    public ReactiveMapEntry(){

    }

    public ReactiveMapEntry(String id, Integer value){
        this.id = id;
        this.value = value;
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private Integer value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
