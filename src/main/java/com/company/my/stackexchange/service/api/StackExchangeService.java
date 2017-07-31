package com.company.my.stackexchange.service.api;

import com.company.my.stackexchange.model.ListOfQuestions;

import java.io.IOException;

/**
 * Service to use <a href="http://api.stackexchange.com">StackExchange</a> api
 */
public interface StackExchangeService {
    /**
     * Search questions from StackOverflow.com by title
     *
     * @param searchTitle searching title
     * @param page page number
     * @return List Of Questions
     * @throws IOException if any network connections issues
     */
    ListOfQuestions findQuestionsByTitle(final String searchTitle, final int page) throws IOException;
}
