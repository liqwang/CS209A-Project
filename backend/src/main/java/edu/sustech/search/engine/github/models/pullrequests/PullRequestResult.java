package edu.sustech.search.engine.github.models.pullrequests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.sustech.search.engine.github.models.AppendableResult;

import javax.annotation.processing.Generated;
import java.util.Iterator;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PullRequestResult implements AppendableResult, Iterable<PullRequest> {
    @Override
    public int appendItems(AppendableResult other) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public Iterator<PullRequest> iterator() {
        return null;
    }
}
