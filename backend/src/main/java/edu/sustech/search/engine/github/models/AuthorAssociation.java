package edu.sustech.search.engine.github.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * How the author is associated with the repository.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum AuthorAssociation {
    @JsonProperty("COLLABORATOR") Collaborator,
    @JsonProperty("CONTRIBUTOR") Contributor,
    @JsonProperty("FIRST_TIMER") FirstTimer,
    @JsonProperty("FIRST_TIME_CONTRIBUTOR") FirstTimeContributor,
    @JsonProperty("MANNEQUIN") Mannequin,
    @JsonProperty("MEMBER") Member,
    @JsonProperty("NONE") None,
    @JsonProperty("OWNER") Owner
}
