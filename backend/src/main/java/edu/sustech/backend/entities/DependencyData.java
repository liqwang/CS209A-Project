package edu.sustech.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sustech.search.engine.github.models.Dependency;
import edu.sustech.search.engine.github.models.Entry;
import edu.sustech.search.engine.github.models.repository.Repository;
import edu.sustech.search.engine.github.models.user.User;

import java.util.ArrayList;
import java.util.List;

public class DependencyData {
    @JsonProperty("data")
    private List<Entry<Repository, Entry<List<User>, List<Dependency>>>> data = new ArrayList<>();

    public List<Entry<Repository, Entry<List<User>, List<Dependency>>>> getData() {
        return data;
    }

    public void setData(List<Entry<Repository, Entry<List<User>, List<Dependency>>>> data) {
        this.data = data;
    }
}
