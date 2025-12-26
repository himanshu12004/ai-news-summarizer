package com.example.ai_news_summarizer.controller;

import com.example.ai_news_summarizer.model.NewsSummary;
import com.example.ai_news_summarizer.service.NewsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public List<NewsSummary> getNews() {
        return newsService.getSummarizedNews();
    }
}
