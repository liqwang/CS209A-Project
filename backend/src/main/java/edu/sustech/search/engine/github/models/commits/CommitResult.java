package edu.sustech.search.engine.github.models.commits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.sustech.search.engine.github.models.AppendableResult;

import java.io.IOException;
import java.util.Iterator;

@JsonIgnoreProperties(ignoreUnknown = true)
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
