package edu.sustech.search.engine.github.API.search.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * For issues and pull requests.
 */
public class IPRSearchRequest extends SearchRequest {

    public enum Restriction {
        Title, Body, Comments
    }

    public enum Type {
        PullRequest, Issue
    }

    public enum SearchBy {
        Interactions, Reactions, Comments
    }

    public enum DateOption {
        Created, Updated, Closed, Merged
    }

    public enum Visibility {
        Public, Private
    }

    public enum Sort {
        BestMatch, Comments, Reactions, ReactionsPlusOne, ReactionsMinusOne, ReactionsSmile, ReactionsThinkingFace, ReactionsHeart, ReactionsTada, Interactions, Created, Updated
    }

    public enum Order {
        Ascending, Descending
    }

    public enum Ignored {
        Label, Milestone, Assignee, Project
    }

    public enum Status {
        Pending, Success, Failure
    }

    public enum ReviewType {
        None, Required, Approved, ChangesRequested
    }


    public static RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder extends SearchRequest.RequestBuilder {
        private final StringBuilder queryBasicBuilder = new StringBuilder();
        private final StringBuilder queryRestriction = new StringBuilder();
        private final StringBuilder queryTypeBuilder = new StringBuilder();
        private final StringBuilder queryByBuilder = new StringBuilder();
        private final StringBuilder queryStatusBuilder = new StringBuilder();

        //I thought they can be simplified using the same builder.
        private final StringBuilder qualifierReviewType = new StringBuilder();
        private final StringBuilder qualifierOwner = new StringBuilder();
        private final StringBuilder qualifierLang = new StringBuilder();
        private final StringBuilder qualifierDateOption = new StringBuilder();
        private final StringBuilder qualifierVisibility = new StringBuilder();
        private final StringBuilder qualifierIgnored = new StringBuilder();

        private Boolean isOpened;
        private Boolean isDraft;
        private Boolean isPRMerged;
        private Boolean isRepoArchived;
        private Boolean isConversationLocked;

        private Sort sort = Sort.BestMatch;
        private Order order = Order.Descending;


        /**
         * @param keyword Keyword, or <code>SHA</code> which is allowed to search specific I/PR
         * @return This builder
         */
        public RequestBuilder addSearchKeyword(String keyword) {
            queryBasicBuilder.append(wrapIfRequired(keyword)).append(" ");
            return this;
        }

        /**
         * This will restrict your search to the restriction site applied.
         * <code>Path</code> means keyword contained in the full path.
         *
         * @param restrictions Restrictions
         * @return This builder
         */
        public RequestBuilder addSearchRestriction(Restriction... restrictions) {
            if (restrictions.length != 0 && queryRestriction.length() != 0) {
                queryRestriction.append("in:");
            }
            for (Restriction r : restrictions) {
                if (queryRestriction.length() > ("in:".length())) {
                    queryRestriction.append(',');
                }
                switch (r) {
                    case Body -> queryRestriction.append("body");
                    case Comments -> queryRestriction.append("comments");
                    case Title -> queryRestriction.append("title");
                }
            }
            return this;
        }

        /**
         * @param type Search type. If set to <code>null</code>, the type restriction will be cleared.
         * @return This builder
         */
        public RequestBuilder setSearchType(Type type) {
            queryTypeBuilder.delete(0, queryTypeBuilder.length());
            if (type != null) {
                queryTypeBuilder.append("type:").append(type == Type.PullRequest ? "pr" : "issue");
            }
            return this;
        }

        public RequestBuilder addReviewOption(ReviewType reviewType) {
            qualifierReviewType.append("review:");
            if (reviewType == ReviewType.ChangesRequested) {
                qualifierReviewType.append("changes_requested");
            } else {
                qualifierReviewType.append(reviewType.toString().toLowerCase());
            }
            return this;
        }

        public RequestBuilder addStatus(Status status) {
            queryStatusBuilder.append("status:").append(status.toString().toLowerCase()).append(" ");
            return this;
        }

        public RequestBuilder addUserOption(String username) {
            qualifierOwner.append("username:" + username).append(" ");
            return this;
        }

        public RequestBuilder addOrgOption(String orgName) {
            qualifierOwner.append("org:" + orgName).append(" ");
            return this;
        }

        public RequestBuilder addRepoOption(String repoFullName) {
            qualifierOwner.append("repo:" + repoFullName).append(" ");
            return this;
        }


        public RequestBuilder addLanguageOption(String... language) {
            for (String s : language) {
                qualifierLang.append("language:").append(s).append(" ");
            }
            return this;
        }

        /**
         * If no restriction is applied before, or you have used basic search before, this operation may override keywords before.
         *
         * @param field    field
         * @param number   number
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return
         */
        public RequestBuilder addSearchField(SearchBy field, int number, String modifier) {
            queryByBuilder.append(field.toString().toLowerCase()).append(":").append(modifier == null ? "" : modifier).append(number).append(" ");
            return this;
        }


        /**
         * @param option   option
         * @param date     YYYY-MM-DD
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return This builder.
         */
        public RequestBuilder addDateOption(DateOption option, String date, String modifier) {
            qualifierDateOption.append(option.toString().toLowerCase()).append(":").append(modifier == null ? "" : modifier).append(date).append(" ");
            return this;
        }

        /**
         * @param option   option
         * @param date     Date
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return This builder.
         */
        public RequestBuilder addDateOption(DateOption option, ZonedDateTime date, String modifier) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            qualifierDateOption.append(option.toString().toLowerCase()).append(":").append(modifier == null ? "" : modifier).append(date.format(formatter)).append(" ");
            return this;
        }

        public RequestBuilder setRepoVisibility(Visibility visibility) {
            qualifierVisibility.delete(0, qualifierVisibility.length());
            qualifierVisibility.append("is:").append(visibility.toString().toLowerCase());
            return this;
        }

        /**
         * @param isOpened If set to <code>null</code>, no restriction will be applied.
         * @return This builder.
         */
        public RequestBuilder setState(Boolean isOpened) {
            this.isOpened = isOpened;
            return this;
        }

        /**
         * @param isDraft If set to <code>null</code>, no restriction will be applied.
         * @return This builder.
         */
        public RequestBuilder setDraft(Boolean isDraft) {
            this.isDraft = isDraft;
            return this;
        }

        /**
         * @param isPRMerged If set to <code>null</code>, no restriction will be applied.
         * @return This builder.
         */
        public RequestBuilder setIsPRMerged(Boolean isPRMerged) {
            this.isPRMerged = isPRMerged;
            return this;
        }

        /**
         * @param isRepoArchived If set to <code>null</code>, no restriction will be applied.
         * @return This builder.
         */
        public RequestBuilder setIsRepoArchived(Boolean isRepoArchived) {
            this.isRepoArchived = isRepoArchived;
            return this;
        }

        public RequestBuilder addIgnored(Ignored ignoredObject) {
            qualifierIgnored.append("no:" + ignoredObject.toString().toLowerCase());
            return this;
        }

        /**
         * @param isLocked If set to <code>null</code>, no restriction will be applied.
         * @return This builder.
         */
        public RequestBuilder setIsConversationLocked(Boolean isLocked) {
            this.isConversationLocked = isLocked;
            return this;
        }

        public RequestBuilder setSorted(Sort sort) {
            this.sort = sort;
            return this;
        }

        public RequestBuilder setOrder(Order order) {
            this.order = order;
            return this;
        }


        public IPRSearchRequest build() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append(queryBasicBuilder).append(" ")
                    .append(queryRestriction).append(" ")
                    .append(queryByBuilder).append(" ")
                    .append(queryTypeBuilder).append(" ")
                    .append(queryStatusBuilder).append(" ")
                    .append(qualifierReviewType).append(" ")
                    .append(qualifierOwner).append(" ")
                    .append(qualifierLang).append(" ")
                    .append(qualifierDateOption).append(" ")
                    .append(qualifierVisibility).append(" ")
                    .append(qualifierIgnored).append(" ")
                    .append(isOpened == null ? "" : ("state:" + (isOpened ? "open" : "closed"))).append(" ")
                    .append(isDraft == null ? "" : ("draft:" + (isDraft ? "true" : "false"))).append(" ")
                    .append(isPRMerged == null ? "" : ("is:" + (isPRMerged ? "merged" : "unmerged"))).append(" ")
                    .append(isRepoArchived == null ? "" : ("archived:" + (isRepoArchived ? "true" : "false"))).append(" ")
                    .append(isConversationLocked == null ? "" : ("is:" + (isConversationLocked ? "locked" : "unlocked")));

            IPRSearchRequest req = new IPRSearchRequest();
            StringBuilder reqBuilder = req.getRequestBuilder();

            //default:desc;
            reqBuilder.append("repositories?q=")
                    .append(URLEncoder.encode(queryBuilder.toString().trim().replaceAll("[ ]{2,}", " "), StandardCharsets.UTF_8));
            if (sort != Sort.BestMatch) {
                reqBuilder.append("&sort=");
                switch (sort) {
                    case ReactionsPlusOne -> reqBuilder.append("reactions-+1");
                    case ReactionsMinusOne -> reqBuilder.append("reactions--1");
                    case ReactionsHeart -> reqBuilder.append("reactions-heart");
                    case ReactionsSmile -> reqBuilder.append("reactions-smile");
                    case ReactionsTada -> reqBuilder.append("reactions-tada");
                    case ReactionsThinkingFace -> reqBuilder.append("reactions-thinking-face");
                    default -> reqBuilder.append(sort.toString().toLowerCase());
                }
            }
            reqBuilder.append(order == Order.Ascending ? "&order=asc" : "");
            return req;
        }

    }
}
