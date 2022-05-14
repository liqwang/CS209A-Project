package edu.sustech.search.engine.github.API.search.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//bai lan le
public class CommitSearchRequest extends SearchRequest {

    public enum SearchBy {
        Author("author"),
        Committer("committer"),
        AuthorName("author-name"),
        CommitterName("committer-name"),
        AuthorEmail("author-email"),
        CommitterEmail("committer-email");

        private final String string;

        SearchBy(String name) {
            string = name;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum DateOption {
        AuthorDate("author-date"),
        CommitterDate("committer-date");

        private final String string;

        DateOption(String name) {
            string = name;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum Sort {
        BestMatch("best-match"),
        AuthorDate("author-date"),
        CommitterDate("committer-date");

        private final String string;

        Sort(String name) {
            string = name;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum Order {
        Ascending, Descending
    }


    public static RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder extends SearchRequest.RequestBuilder {
        private final StringBuilder queryBasicBuilder = new StringBuilder();
        private final StringBuilder queryByBuilder = new StringBuilder();
        private final StringBuilder qualifierDateOption = new StringBuilder();

        private Boolean isMerged;
        private String hash;
        private String parentHash;
        private String treeHash;

        private Sort sort = Sort.BestMatch;
        private Order order = Order.Descending;

        /**
         * @param keyword Search keyword
         * @return This builder
         */
        public RequestBuilder addSearchKeyword(String keyword) {
            queryBasicBuilder.append(wrapIfRequired(keyword)).append(" ");
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
                queryByBuilder.append(field).append(":").append(wrapIfRequired(s)).append(" ");
            }
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
            qualifierDateOption.append(option).append(":").append(modifier == null ? "" : modifier).append(date).append(" ");
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
            qualifierDateOption.append(option).append(":").append(modifier == null ? "" : modifier).append(date.format(formatter)).append(" ");
            return this;
        }

        /**
         * @param merged If <code>null</code>, no restrictions will be applied.
         */
        public RequestBuilder setMerged(Boolean merged) {
            isMerged = merged;
            return this;
        }

        /**
         * @param hash If <code>null</code>, no restrictions will be applied.
         */
        public RequestBuilder setHash(String hash) {
            this.hash = hash;
            return this;
        }

        /**
         * @param parentHash If <code>null</code>, no restrictions will be applied.
         */
        public RequestBuilder setParentHash(String parentHash) {
            this.parentHash = parentHash;
            return this;
        }

        /**
         * @param treeHash If <code>null</code>, no restrictions will be applied.
         */
        public RequestBuilder setTreeHash(String treeHash) {
            this.treeHash = treeHash;
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


        public CommitSearchRequest build() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append(queryBasicBuilder).append(" ")
                    .append(queryByBuilder).append(" ")
                    .append(qualifierDateOption).append(" ")
                    .append(hash == null ? "" : ("hash:" + hash)).append(" ")
                    .append(parentHash == null ? "" : ("parent:" + parentHash)).append(" ")
                    .append(treeHash == null ? "" : ("tree:" + treeHash)).append(" ")
                    .append(isMerged == null ? "" : ("merged:" + (isMerged ? "true" : "false")));

            CommitSearchRequest req = new CommitSearchRequest();
            StringBuilder reqBuilder = req.getRequestBuilder();

            //default:desc;
            reqBuilder.append("repositories?q=")
                    .append(URLEncoder.encode(queryBuilder.toString().trim().replaceAll("[ ]{2,}", " "), StandardCharsets.UTF_8));
            if (sort != Sort.BestMatch) {
                reqBuilder.append("&sort=").append(sort);
            }
            reqBuilder.append(order == Order.Ascending ? "&order=asc" : "");
            return req;
        }
    }
}
