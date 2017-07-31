package com.company.my.stackexchange.service.impl;

import com.company.my.stackexchange.model.ListOfQuestions;
import com.company.my.stackexchange.service.api.StackExchangeService;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * {@inheritDoc}
 */
@Component
public class StackExchangeServiceImpl implements StackExchangeService {
    private final RestTemplate restTemplate;

    /**
     * Construct the service, init rest template
     */
    public StackExchangeServiceImpl() {
        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        restTemplate = new RestTemplate(clientHttpRequestFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListOfQuestions findQuestionsByTitle(final String searchTitle, final int page) throws IOException {
        final String encodedSearchTitle = URLEncoder.encode(searchTitle, "UTF-8");
        final String requestUrl = String.format("http://api.stackexchange.com/2.2/search?order=desc&sort=creation&intitle=%s&site=stackoverflow&page=%s", encodedSearchTitle, page);
        final ResponseEntity<ListOfQuestions> questions = restTemplate.getForEntity(requestUrl, ListOfQuestions.class);
        return questions.getBody();
    }
}
