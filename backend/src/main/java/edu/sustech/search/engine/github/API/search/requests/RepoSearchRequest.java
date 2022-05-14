package edu.sustech.search.engine.github.API.search.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class RepoSearchRequest extends SearchRequest {

    public enum Restriction {
        Name, Description, Readme
    }

    public enum SearchBy {
        Topic
    }

    public enum RepoOption {
        Stars, Forks
    }

    public enum DateOption {
        Created, Pushed
    }

    public enum Path {
        Root
    }

    public enum ForkOption {
        True, Only, False
    }

    public enum Visibility {
        Public, Private
    }

    public enum Sort {
        BestMatch, Stars, Forks, HelpWantedIssues, Updated
    }

    public enum Order {
        Ascending, Descending
    }

    public enum Issue {
        GoodFirstIssues, HelpWantedIssues
    }


    public static RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder extends SearchRequest.RequestBuilder {
        private final StringBuilder queryBasicBuilder = new StringBuilder();
        private final StringBuilder queryRestriction = new StringBuilder();
        private final StringBuilder queryByBuilder = new StringBuilder();

        //I thought they can be simplified using the same builder.
        private final StringBuilder qualifierOwner = new StringBuilder();
        private final StringBuilder qualifierLang = new StringBuilder();
        private final StringBuilder qualifierSize = new StringBuilder();
        private final StringBuilder qualifierRepoOption = new StringBuilder();
        private final StringBuilder qualifierDateOption = new StringBuilder();
        private final StringBuilder qualifierFollowerCount = new StringBuilder();
        private final StringBuilder qualifierTopicCount = new StringBuilder();
        private final StringBuilder qualifierLicense = new StringBuilder();
        private final StringBuilder qualifierVisibility = new StringBuilder();
        private final StringBuilder qualifierMirror = new StringBuilder();
        private final StringBuilder qualifierArchived = new StringBuilder();
        private final StringBuilder qualifierIssueOption = new StringBuilder();
        private final StringBuilder qualifierSponsor = new StringBuilder();

        private ForkOption forkOption = ForkOption.False;
        private Sort sort = Sort.BestMatch;
        private Order order = Order.Descending;


        public RequestBuilder addSearchKeyword(String keyword) {
            queryBasicBuilder.append(wrapIfRequired(keyword)).append(" ");
            return this;
        }

        /**
         * This will restrict your search to the restriction site applied.
         * <code>Path</code> means keyword contained in the full path.
         *
         * @param restrictions restrictions
         * @return this builder
         */
        public RequestBuilder addSearchRestriction(Restriction... restrictions) {
            if (restrictions.length != 0 && queryRestriction.length() != 0) {
                queryRestriction.append("in:");
            }
            for (Restriction r : restrictions) {
                if (queryRestriction.length() > ("in:".length())) {
                    queryRestriction.append(',');
                }
                queryRestriction.append(r.toString().toLowerCase());
            }
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
         * @param size     File size in Kilobyte
         * @param modifier can be one of <code>>,>=,<=,<</code>, or null
         * @return This builder.
         */
        public RequestBuilder addSizeOption(String size, String modifier) {
            qualifierSize.append("size:").append(modifier == null ? "" : modifier).append(size).append(" ");
            return this;
        }

        /**
         * If no restriction is applied before, or you have used basic search before, this operation may override keywords before.
         *
         * @param field
         * @param keywords
         * @return
         */
        public RequestBuilder addSearchField(SearchBy field, String... keywords) {
            for (String s : keywords) {
                queryByBuilder.append(field.toString().toLowerCase()).append(":").append(wrapIfRequired(s)).append(" ");
            }
            return this;
        }

        /**
         * @param option   option, can be one of <code>forks, stars</code>
         * @param amount   amount
         * @param modifier can be one of <code>>,>=,<=,<</code>. If not specified, no modifier will be used.
         * @return
         */
        public RequestBuilder addRepoOption(RepoOption option, String amount, String modifier) {
            qualifierRepoOption.append(option).append(":").append(modifier == null ? "" : modifier).append(amount).append(" ");
            return this;
        }


        /**
         * @param option   option
         * @param date     YYYY-MM-DD
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return This builder.
         */
        public RequestBuilder addDateOption(DateOption option, String date, String modifier) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

        public RequestBuilder addFollowerCount(long count) {
            qualifierFollowerCount.append("followers:").append(count).append(" ");
            return this;
        }

        public RequestBuilder addFollowerCount(long count, String modifier) {
            qualifierFollowerCount.append("followers:").append(modifier).append(count).append(" ");
            return this;
        }

        public RequestBuilder setForkOption(ForkOption option) {
            this.forkOption = option;
            return this;
        }

        /**
         * @param count    File count in Kilobyte
         * @param modifier can be one of <code>>,>=,<=,<</code>, or null
         * @return This builder.
         */
        public RequestBuilder addTopicCount(int count, String modifier) {
            qualifierTopicCount.append("topics:").append(modifier == null ? "" : modifier).append(count).append(" ");
            return this;
        }

        public RequestBuilder addLicenseOption(String licenseName) {
            qualifierLicense.append("license:").append(wrapIfRequired(licenseName)).append(" ");
            return this;
        }

        public RequestBuilder setRepoVisibility(Visibility visibility) {
            qualifierVisibility.delete(0, qualifierVisibility.length());
            qualifierVisibility.append("is:").append(visibility.toString().toLowerCase());
            return this;
        }

        public RequestBuilder setIsRepoMirror(boolean isRepoMirror) {
            qualifierMirror.delete(0, qualifierMirror.length());
            qualifierMirror.append("mirror:").append(isRepoMirror ? "true" : "false");
            return this;
        }

        public RequestBuilder setIsRepoArchived(boolean isRepoArchived) {
            qualifierArchived.delete(0, qualifierArchived.length());
            qualifierArchived.append("archived:").append(isRepoArchived ? "true" : "false");
            return this;
        }

        /**
         * @param issue    option
         * @param count    Date
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return This builder.
         */
        public RequestBuilder addIssueOption(Issue issue, int count, String modifier) {
            qualifierIssueOption.append(issue == Issue.GoodFirstIssues ? "good-first-issues" : "help-wanted-issues")
                    .append(":").append(modifier == null ? "" : modifier).append(count).append(" ");
            return this;
        }

        public RequestBuilder setSponsorable() {
            qualifierSponsor.append("is:sponsorable").append(" ");
            return this;
        }

        public RequestBuilder setHasFundingFile() {
            qualifierSponsor.append("has:funding-file").append(" ");
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


        public RepoSearchRequest build() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append(queryBasicBuilder).append(" ")
                    .append(queryRestriction).append(" ")
                    .append(queryByBuilder).append(" ")
                    .append(qualifierOwner).append(" ")
                    .append(qualifierLang).append(" ")
                    .append(qualifierSize).append(" ")
                    .append(qualifierRepoOption).append(" ")
                    .append(qualifierDateOption).append(" ")
                    .append(qualifierFollowerCount).append(" ")
                    .append(qualifierTopicCount).append(" ")
                    .append(qualifierLicense).append(" ")
                    .append(forkOption == ForkOption.False ? "" : "fork:" + forkOption.toString()).append(" ")
                    .append(qualifierVisibility).append(" ")
                    .append(qualifierMirror).append(" ")
                    .append(qualifierArchived).append(" ")
                    .append(qualifierIssueOption).append(" ")
                    .append(qualifierSponsor);

            RepoSearchRequest req = new RepoSearchRequest();
            StringBuilder reqBuilder = req.getRequestBuilder();

            //default:desc;
            reqBuilder.append("repositories?q=")
                    .append(URLEncoder.encode(queryBuilder.toString().trim().replaceAll("[ ]{2,}", " "), StandardCharsets.UTF_8));
            if (sort != Sort.BestMatch) {
                reqBuilder.append("&sort=");
                switch (sort) {
                    case Stars -> reqBuilder.append("stars");
                    case Forks -> reqBuilder.append("forks");
                    case HelpWantedIssues -> reqBuilder.append("help-wanted-issues");
                    case Updated -> reqBuilder.append("updated");
                }
            }
            reqBuilder.append(order == Order.Ascending ? "&order=asc" : "");
            return req;
        }

    }


}
