package edu.sustech.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sustech.search.engine.github.models.Dependency;

public class DependencyResult {
    @JsonProperty("dependency")
    private Dependency dependency;

    @JsonProperty("used")
    private Integer used = 1;

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}
