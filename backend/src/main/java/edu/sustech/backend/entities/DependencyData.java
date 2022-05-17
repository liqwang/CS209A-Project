package edu.sustech.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sustech.search.engine.github.models.Dependency;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class DependencyData {
    @JsonProperty("data")
    private List<Entry<Repository, List<Dependency>>> data = new ArrayList<>();

    public List<Entry<Repository, List<Dependency>>> getData() {
        return data;
    }

    public void setData(List<Entry<Repository, List<Dependency>>> data) {
        this.data = data;
    }
}
