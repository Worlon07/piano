package com.company.my.stackexchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Question gets from stackexchange
 * {@see http://api.stackexchange.com/docs/search#page=2&order=desc&sort=creation&intitle=java&filter=default&site=stackoverflow&run=true}
 */
public class Question {
    private List<String> tags;
    private QuestionOwner owner;
    @JsonProperty("is_answered")
    private boolean isAnswered;
    @JsonProperty("view_count")
    private int viewCount;
    @JsonProperty("answer_count")
    private int answerCount;
    private int score;
    @JsonProperty("last_activity_date")
    private long lastActivityDate;
    @JsonProperty("creation_date")
    private long creationDate;
    @JsonProperty("last_edit_date")
    private long lastEditDate;
    @JsonProperty("question_id")
    private long questionId;
    private String link;
    private String title;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public QuestionOwner getOwner() {
        return owner;
    }

    public void setOwner(QuestionOwner owner) {
        this.owner = owner;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        this.isAnswered = answered;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormattedCreationDate() {
        Date date = new Date(getCreationDate() * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        return sdf.format(date);
    }
}
