package valoration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static final String BASE_URL = "http://store.apicultur.com/api";
    private static final String VALUATION_API = "/stmtlk/1.0.0/valoracion/tweet/10/";
    private static final String DATUMBOX_API_KEY = "14f149d67468fcd213ce7ef49345ad05";
    private static final String DATUMBOX_API_ENDPOINT = "http://api.datumbox.com:80/1.0/TwitterSentimentAnalysis.json";


    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        Twitter twitter = new TwitterTemplate("5YLjNsOP2XJAK3VexX4KD3Sns", "F5eK8NbsCcyoqc8I7OoiE6t8MVHanxudJBNTTtpyeysw6hfcu2", "394658000-HHxxQDDJWS9zC9bENJjacJBhOQTkYc9HhpZ31BfL", "XGuvPZku2SeXPuo3bxH2IYqS43bRJDzFjHxIombPioheR");

        SearchResults elections2016 = twitter.searchOperations().search("elections2016");
        for (Tweet tweet : elections2016.getTweets()) {
            System.out.println(tweet.getText());
            //getDatumBoxValuation(tweet.getText());
        }
    }

    private void getDatumBoxValuation(String text) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("api_key", DATUMBOX_API_KEY);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        Map<String,String> parameters = new HashMap<>();
        parameters.put("text",text);
        parameters.put("api_key",DATUMBOX_API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(DATUMBOX_API_ENDPOINT, HttpMethod.POST,
                Object.class, parameters);
        log.info(responseEntity.getBody().toString());
//        log.info(responseEntity.getBody().getPonderacion());
    }

    private void getValuation(String text) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", "Bearer nfXwZqvfreEYRfzDoUqJuHAoElga");
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Response> response = restTemplate.exchange(BASE_URL + VALUATION_API + text,
                HttpMethod.GET, requestEntity, Response.class);
        log.info(response.getBody().getTexto());
        log.info(response.getBody().getPonderacion());
    }
}