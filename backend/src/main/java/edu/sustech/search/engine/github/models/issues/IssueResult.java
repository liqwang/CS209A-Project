package edu.sustech.search.engine.github.models.issues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.sustech.search.engine.github.models.AppendableResult;

import java.util.Iterator;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueResult implements AppendableResult, Iterable<Issue> {
    @Override
    public int appendItems(AppendableResult other) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public Iterator<Issue> iterator() {
        return null;
    }
}
