package valoration.twitter;

import com.twitter.hbc.core.HttpConstants;
import com.twitter.hbc.core.endpoint.DefaultStreamingEndpoint;

/**
 * Created by nachogarrone on 11/9/15.
 */
public class SearchTweetEndpoint extends DefaultStreamingEndpoint {

    public static final String PATH = "/search/tweets.json";

    /**
     * All endpoints have delimited=length by default
     */
    public SearchTweetEndpoint() {
        super(PATH, HttpConstants.HTTP_GET, false);
    }
}
