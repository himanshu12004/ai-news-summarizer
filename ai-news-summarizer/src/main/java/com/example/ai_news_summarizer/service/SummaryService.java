package com.example.ai_news_summarizer.service;

import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    public String summarize(String text) {
        if (text == null || text.isEmpty()) {
            return "No summary available.";
        }

        // simple NLP: first 40 words
        String[] words = text.split(" ");
        StringBuilder summary = new StringBuilder();

        for (int i = 0; i < Math.min(words.length, 40); i++) {
            summary.append(words[i]).append(" ");
        }

        return summary.toString().trim() + "...";
    }
}
