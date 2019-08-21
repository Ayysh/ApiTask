package com.flaregames.stackoverflow.utility;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This class provides RestClient for making RestApi calls
 */
@Component
public class RestClientProvider {

    /**
     * RestClient
     */
    private final RestTemplate restTemplate;

    public RestClientProvider(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * This method sets the HttpComponentsClientHttpRequestFactory into RestTemplate to
     * enable reading of GZIP encoded data by restTemplate
     *
     * @return
     */
    public RestTemplate getClient() {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }
}
