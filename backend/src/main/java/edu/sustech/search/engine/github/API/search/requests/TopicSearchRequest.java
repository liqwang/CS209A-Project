package edu.sustech.search.engine.github.API.search.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TopicSearchRequest extends SearchRequest {
    public enum Sort {
        BestMatch, Stars, Forks, HelpWantedIssues, Updated
    }

    public enum Order {
        Ascending, Descending
    }

    public static RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder extends SearchRequest.RequestBuilder {
        private final StringBuilder queryBasicBuilder = new StringBuilder();

        private final StringBuilder qualifierCurated = new StringBuilder();
        private final StringBuilder qualifierFeatured = new StringBuilder();

        private final StringBuilder qualifierRepoCount = new StringBuilder();
        private final StringBuilder qualifierDateOption = new StringBuilder();

        private Sort sort = Sort.BestMatch;
        private Order order = Order.Descending;


        public RequestBuilder addSearchKeyword(String keyword) {
            queryBasicBuilder.append(wrapIfRequired(keyword)).append(" ");
            return this;
        }

        public RequestBuilder setIsCurated(boolean isCurated) {
            removeCuratedTag();
            qualifierCurated.append("is:").append(isCurated ? "" : "not-").append("curated");
            return this;
        }

        public RequestBuilder removeCuratedTag() {
            qualifierCurated.delete(0, qualifierCurated.length());
            return this;
        }

        public RequestBuilder setIsFeatured(boolean isFeatured) {
            removeCuratedTag();
            qualifierFeatured.append("is:").append(isFeatured ? "" : "not-").append("featured");
            return this;
        }

        public RequestBuilder removeFeaturedTag() {
            qualifierFeatured.delete(0, qualifierFeatured.length());
            return this;
        }

        /**
         * @param repoCount Repo count
         * @param modifier  can be one of <code>>,>=,<=,<</code>, or null
         * @return This builder.
         */
        public RequestBuilder addRepoCountQualifier(String repoCount, String modifier) {
            qualifierRepoCount.append("repositories:").append(modifier == null ? "" : modifier).append(repoCount).append(" ");
            return this;
        }

        /**
         * @param date     YYYY-MM-DD
         * @param modifier can be one of <code>>,>=,<=,<, null</code>
         * @return This builder.
         */
        public RequestBuilder addDateOption(String date, String modifier) {
            qualifierDateOption.append("created:").append(modifier == null ? "" : modifier).append(date).append(" ");
            return this;
        }

        /**
         * @param date     Date
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return This builder.
         */
        public RequestBuilder addDateOption(ZonedDateTime date, String modifier) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            qualifierDateOption.append("created:").append(modifier == null ? "" : modifier).append(date.format(formatter)).append(" ");
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

        public TopicSearchRequest build() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append(queryBasicBuilder).append(" ")
                    .append(qualifierCurated).append(" ")
                    .append(qualifierFeatured).append(" ")
                    .append(qualifierRepoCount).append(" ")
                    .append(qualifierDateOption);


            TopicSearchRequest req = new TopicSearchRequest();
            StringBuilder reqBuilder = req.getRequestBuilder();

            reqBuilder.append("topics?q=")
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
