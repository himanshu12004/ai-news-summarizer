package com.example.ai_news_summarizer.service;

import com.example.ai_news_summarizer.model.NewsSummary;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Value("${news.api.key}")
    private String apiKey;

    @Value("${news.api.url}")
    private String apiUrl;

    private final SummaryService summaryService;

    public NewsService(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    public List<NewsSummary> getSummarizedNews() {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "&apiKey=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);

        List<NewsSummary> result = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode articles = root.get("articles");

            for (JsonNode article : articles) {
                String title = article.get("title").asText();
                String content = article.get("description") != null
                        ? article.get("description").asText()
                        : "";

                String summary = summaryService.summarize(content);
                result.add(new NewsSummary(title, summary));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
