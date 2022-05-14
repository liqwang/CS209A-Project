package edu.sustech.search.engine.github.API.search.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class UserSearchRequest extends SearchRequest {

    public enum Type {
        User, Organization, None
    }

    public enum Sort {
        Followers, Repositories, Joined, BestMatch
    }

    public enum Order {
        Ascending, Descending
    }


    public static RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder extends SearchRequest.RequestBuilder {
        private final StringBuilder queryBasicBuilder = new StringBuilder();
        private final StringBuilder queryTypeRestriction = new StringBuilder();

        private final StringBuilder qualifierRepoCount = new StringBuilder();
        private final StringBuilder qualifierLocation = new StringBuilder();
        private final StringBuilder qualifierLanguage = new StringBuilder();
        private final StringBuilder qualifierDateOption = new StringBuilder();
        private final StringBuilder qualifierFollowerCount = new StringBuilder();

        private Sort sort = Sort.BestMatch;
        private Order order = Order.Descending;


        public RequestBuilder addSearchKeyword(String keyword) {
            queryBasicBuilder.append(wrapIfRequired(keyword)).append(" ");
            return this;
        }


        public RequestBuilder setTypeRestriction(Type type) {
            queryTypeRestriction.delete(0, queryTypeRestriction.length());
            switch (type) {
                case User -> queryTypeRestriction.append("type:user");
                case Organization -> queryTypeRestriction.append("type:org");
            }
            return this;
        }

        /**
         * @param repoCount Repo count
         * @param modifier  can be one of <code>>,>=,<=,<</code>, or null
         * @return This builder.
         */
        public RequestBuilder addRepoCountQualifier(String repoCount, String modifier) {
            qualifierRepoCount.append("repos:").append(modifier == null ? "" : modifier).append(repoCount).append(" ");
            return this;
        }

        public RequestBuilder addLocation(String... location) {
            for (String s : location) {
                qualifierLocation.append("location:").append(s).append(" ");
            }
            return this;
        }

        /**
         * @param language The preferred language the user have used
         * @return
         */
        public RequestBuilder addLanguage(String... language) {
            for (String s : language) {
                qualifierLanguage.append("language:").append(s).append(" ");
            }
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

        public RequestBuilder addFollowerCount(long count) {
            qualifierFollowerCount.append("followers:").append(count).append(" ");
            return this;
        }

        /**
         *
         * @param count count
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
         * @return This builder.
         */
        public RequestBuilder addFollowerCount(long count, String modifier) {
            qualifierFollowerCount.append("followers:").append(modifier).append(count).append(" ");
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


        public UserSearchRequest build() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append(queryBasicBuilder).append(" ")
                    .append(queryTypeRestriction).append(" ")
                    .append(qualifierRepoCount).append(" ")
                    .append(qualifierLocation).append(" ")
                    .append(qualifierLanguage).append(" ")
                    .append(qualifierDateOption).append(" ")
                    .append(qualifierFollowerCount);


            UserSearchRequest req = new UserSearchRequest();
            StringBuilder reqBuilder = req.getRequestBuilder();
            reqBuilder.append("user?q=")
                    .append(URLEncoder.encode(queryBuilder.toString().trim().replaceAll("[ ]{2,}", " "), StandardCharsets.UTF_8))
                    .append(sort == Sort.BestMatch ? "" : "&sort=" + sort.toString().toLowerCase())
                    .append(order == Order.Ascending ? "&order=asc" : "");    //default:desc
            return req;
        }


    }
}
