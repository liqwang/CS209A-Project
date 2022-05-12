package edu.sustech.search.engine.github.API.search.requests;

public class SearchRequest {

    StringBuilder requestBuilder;
    int page;
    int per_page;

    SearchRequest() {
        requestBuilder = new StringBuilder();
        page = 1;
        per_page = 100;
    }

    public SearchRequest(SearchRequest other) {
        requestBuilder = new StringBuilder(other.requestBuilder.toString());
        page = other.page;
        per_page = other.per_page;
    }

    /**
     * Set the result page number.<br>
     * If <code>page<=0</code>, then the default page = 1 will be used. Otherwise,
     * the corresponding result on <code>page</code> will be retrieved.
     *
     * @param page
     */
    public void setResultPage(int page) {
        if (page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    /**
     * Increase result page number by <code>amount</code>
     *
     * @param amount amount
     */
    public void incrResultPage(int amount) {
        if (amount >= 0) {
            page += amount;
        }
    }

    public int getResultPage() {
        return this.page;
    }

    /**
     * The default value is <code>100</code>
     * @return results per page
     */
    public int getResultPerPage() {
        return per_page;
    }

    /**
     * The default value is <code>100</code>
     */
    public void setResultPerPage(int count) {
        if (count <= 0 || count >= 100) {
            per_page = 100;
        } else {
            per_page = count;
        }
    }

    public String getRequestStringRaw() {
        return requestBuilder.toString().concat("&per_page=" + per_page).concat("&page=" + page);
    }

    public String getRequestString() {
        return requestBuilder.toString().replace(' ', '+').concat("&per_page=" + per_page).concat("&page=" + page);
    }

    public StringBuilder getRequestBuilder() {
        return this.requestBuilder;
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "]:" + requestBuilder.toString().replace(' ', '+');
    }


    //Below are utility methods

    static String wrapIfRequired(String wrapped) {
        if (wrapped.contains(" ")) {
            return '"' + wrapped + '"';
        } else {
            return wrapped;
        }
    }

}
