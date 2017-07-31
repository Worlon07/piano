package com.company.my.stackexchange;

import com.company.my.stackexchange.controller.ViewController;
import com.company.my.stackexchange.model.ListOfQuestions;
import com.company.my.stackexchange.service.api.StackExchangeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.io.IOException;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

public class ViewControllerTest {
    private static final String SEARCH_TITLE = "searchTitle";
    private static final String QUESTIONS_KEY = "questions";
    private StackExchangeService stackExchangeService;
    private ViewController viewController;

    @Before
    public void init() {
        stackExchangeService = Mockito.mock(StackExchangeService.class);
        viewController = new ViewController(stackExchangeService);
    }


    /**
     * Test correct behaviour {@link ViewController#searchQuestions(String, int, Model)}
     */
    @Test
    public void testSearchQuestions() throws IOException {
        final Model model = new ExtendedModelMap();
        final int searchPage = 1;
        final ListOfQuestions questions = new ListOfQuestions();
        Mockito.when(stackExchangeService.findQuestionsByTitle(SEARCH_TITLE, searchPage)).thenReturn(questions);
        viewController.searchQuestions(SEARCH_TITLE, searchPage, model);
        final ListOfQuestions listOfQuestions = (ListOfQuestions) model.asMap().get(QUESTIONS_KEY);
        Assert.assertEquals(questions, listOfQuestions);
    }

    /**
     * Test that service does not request any data when title is empty
     */
    @Test
    public void testEmptyTitle() throws IOException {
        final Model model = new ExtendedModelMap();
        viewController.searchQuestions("", 1, model);
        Mockito.verify(stackExchangeService, Mockito.never()).findQuestionsByTitle(anyString(), anyInt());
        final ListOfQuestions listOfQuestions = (ListOfQuestions) model.asMap().get(QUESTIONS_KEY);
        Assert.assertNotNull(listOfQuestions);
        Assert.assertEquals(0, listOfQuestions.getItems().size());
    }

    /**
     * Test that service request page 1 if page number is negative
     */
    @Test
    public void testNegativePage() throws IOException {
        final Model model = new ExtendedModelMap();
        final ListOfQuestions questions = new ListOfQuestions();
        Mockito.when(stackExchangeService.findQuestionsByTitle(SEARCH_TITLE, 1)).thenReturn(questions);
        viewController.searchQuestions(SEARCH_TITLE, -1, model);
        final ListOfQuestions listOfQuestions = (ListOfQuestions) model.asMap().get(QUESTIONS_KEY);
        Assert.assertEquals(questions, listOfQuestions);
    }
}
