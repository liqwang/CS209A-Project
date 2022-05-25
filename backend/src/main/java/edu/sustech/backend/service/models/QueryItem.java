package edu.sustech.backend.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class QueryItem {

    public QueryItem(){

    }

    public QueryItem(String searchQuery, String date, String source, String statusQuery){
        this.searchQuery = searchQuery;
        this.date = date;
        this.source = source;
        this.statusQuery = statusQuery;
    }

    @JsonProperty("searchQuery")
    private String searchQuery;

    @JsonProperty("date")
    private String date;

    @JsonProperty("source")
    private String source;

    @JsonProperty("statusQuery")
    private String statusQuery;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatusQuery() {
        return statusQuery;
    }

    public void setStatusQuery(String statusQuery) {
        this.statusQuery = statusQuery;
    }
}
