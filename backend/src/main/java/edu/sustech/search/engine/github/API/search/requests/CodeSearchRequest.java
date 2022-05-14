package edu.sustech.search.engine.github.API.search.requests;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class implements the GitHub REST api query,
 * for interaction between the end-user and the GitHub code search engine.
 */
public class CodeSearchRequest extends SearchRequest {

    public enum Restriction {
        File, Path
    }

    public enum SearchBy {
        Filename, Extension, Unspecified
    }

    public enum RepoOption {
        Stars, Forks
    }

    public enum Path {
        Root
    }

    public enum Sort {
        Indexed, BestMatch
    }

    public enum Order {
        Ascending, Descending
    }


    public static RequestBuilder newBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder extends SearchRequest.RequestBuilder {
        private final StringBuilder queryBasicBuilder = new StringBuilder();
        private final StringBuilder queryRestriction = new StringBuilder();
        private final StringBuilder queryByBuilder = new StringBuilder();

        private final StringBuilder qualifierOwner = new StringBuilder();
        private final StringBuilder qualifierPath = new StringBuilder();
        private final StringBuilder qualifierLang = new StringBuilder();
        private final StringBuilder qualifierSize = new StringBuilder();
        private final StringBuilder qualifierRepoOption = new StringBuilder();
        private final StringBuilder qualifierDateOption = new StringBuilder();

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
                switch (r) {
                    case File -> queryRestriction.append("file");
                    case Path -> queryRestriction.append("path");
                }
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

        public RequestBuilder addPathOption(Path path) {
            switch (path) {
                case Root -> qualifierPath.append("path:/").append(" ");
            }
            return this;
        }

        /**
         * Search files only under the specific path in the corresponding repository.
         *
         * @param path path
         * @return
         */
        public RequestBuilder addPathOption(String path) {
            qualifierPath.append("path:").append(path).append(" ");
            return this;
        }

        public RequestBuilder addLanguageOption(String... language) {
            for (String s : language) {
                qualifierLang.append("language:").append(s).append(" ");
            }
            return this;
        }

        /**
         * @param size     File size in Byte
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
                switch (field) {
                    case Filename -> queryByBuilder.append("filename:");
                    case Extension -> queryByBuilder.append("extension:");
                }
                queryByBuilder.append(wrapIfRequired(s)).append(" ");
            }
            return this;
        }

        /**
         * @param option
         * @param amount
         * @param modifier can be one of <code>>,>=,<=,<</code>. If not specified, no modifier will be used.
         * @return
         */
        public RequestBuilder setRepoOption(RepoOption option, String amount, String modifier) {
            switch (option) {
                case Stars -> qualifierRepoOption.append("stars:");
                case Forks -> qualifierRepoOption.append("forks:");
            }
            qualifierRepoOption.append(modifier == null ? "" : modifier).append(amount).append(" ");
            return this;
        }


        /**
         * @param date     YYYY-MM-DD
         * @param modifier can be one of <code>>,>=,<=,<,null</code>
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


        public CodeSearchRequest build() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append(queryBasicBuilder).append(" ")
                    .append(queryRestriction).append(" ")
                    .append(queryByBuilder).append(" ")
                    .append(qualifierOwner).append(" ")
                    .append(qualifierPath).append(" ")
                    .append(qualifierLang).append(" ")
                    .append(qualifierSize).append(" ")
                    .append(qualifierRepoOption).append(" ")
                    .append(qualifierDateOption);

            CodeSearchRequest req = new CodeSearchRequest();
            StringBuilder reqBuilder = req.getRequestBuilder();
            //default:desc;
            reqBuilder.append("code?q=")
                    .append(URLEncoder.encode(queryBuilder.toString().trim().replaceAll("[ ]{2,}", " "), StandardCharsets.UTF_8))
                    .append(sort == Sort.Indexed ? "&sort=indexed" : "")
                    .append(order == Order.Ascending ? "&order=asc" : "");
            return req;
        }

    }


}
