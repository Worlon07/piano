package com.company.my.stackexchange.controller;

import com.company.my.stackexchange.model.ListOfQuestions;
import com.company.my.stackexchange.service.api.StackExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Collections;

/**
 * View controller to show main page with list of questions
 */
@Controller
public class ViewController {

    private StackExchangeService stackExchangeService;

    /**
     * Create ViewController
     *
     * @param stackExchangeService service to get data from StackExchange
     */
    @Autowired
    public ViewController(final StackExchangeService stackExchangeService) {
        this.stackExchangeService = stackExchangeService;
    }

    /**
     * Show main page with list of questiona
     *
     * @param title searching title
     * @param page  page number
     * @param model view model
     * @return view name to show
     * @throws IOException in case of exception in search
     */
    @RequestMapping("/")
    public String searchQuestions(@ModelAttribute("title") final String title, @RequestParam(name = "page", defaultValue = "1") final int page,
                                  final Model model) throws IOException {

        final ListOfQuestions questions;
        if (title == null || title.trim().isEmpty()) {
            questions = new ListOfQuestions();
            questions.setItems(Collections.emptyList());
        } else {
            questions = stackExchangeService.findQuestionsByTitle(title, page < 1 ? 1 : page);
        }
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
        return "questions";
    }
}
