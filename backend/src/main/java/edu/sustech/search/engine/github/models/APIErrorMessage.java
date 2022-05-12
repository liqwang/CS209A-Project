package edu.sustech.search.engine.github.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIErrorMessage {

    private String documentation_url;

    private String message;

    public void setDocumentation_url(String documentation_url) {
        this.documentation_url = documentation_url;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getDocumentation_url() {
        return documentation_url;
    }
}
