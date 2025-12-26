package com.example.ai_news_summarizer.model;

public class NewsSummary {
    private String title;
    private String summary;

    public NewsSummary(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }
}
