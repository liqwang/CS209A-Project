package edu.sustech.search.engine.github.models.commits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.AppendableResult;

import java.io.IOException;
import java.util.Iterator;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total_count",
        "incomplete_results",
        "items"
})
public class CommitResult implements AppendableResult,
        Iterable<Commit> {

    @Override
    public Iterator<Commit> iterator() {
        return null;
    }

    @Override
    public int appendItems(AppendableResult other) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
