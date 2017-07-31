package com.company.my.stackexchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Result of request to stackexchange
 * {@see http://api.stackexchange.com/docs/search#page=2&order=desc&sort=creation&intitle=java&filter=default&site=stackoverflow&run=true}
 */
public class ListOfQuestions {
    private List<Question> items;
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonProperty("quota_max")
    private int quotaMax;
    @JsonProperty("quota_remaining")
    private int quotaRemaining;

    public List<Question> getItems() {
        return items;
    }

    public void setItems(List<Question> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
    }

    public int getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }
}
