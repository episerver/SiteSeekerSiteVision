package siteseeker;

public class RequestBuilder {
    public SimpleRequestParameters requestParameters;

    private RequestBuilder() {
        if(requestParameters!=null) {
            throw new IllegalStateException("Each RequestBuilder instance may be used only to create one request");
        }
        requestParameters = new SimpleRequestParameters();
    }

    public static RequestBuilder searchRequest() {
        return new RequestBuilder();
    }

    public RequestBuilder withQuery(String query) {
        requestParameters.setParameter("query", query);
        return this;
    }

    public SimpleRequestParameters parameters() {
        return requestParameters;
    }
}
