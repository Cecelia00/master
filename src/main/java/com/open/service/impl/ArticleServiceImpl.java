package com.open.service.impl;

import com.open.mapper.ArticleMapper;
import com.open.pojo.Article;
import com.open.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article) {
        Long bodyId = article.getBodyId();
        Long createDate = article.getCreateDate();
        String summary = article.getSummary();
        String title = article.getTitle();
        Long viewCounts = article.getViewCounts();
        Long weight = article.getWeight();
        Long categoryId = article.getCategoryId();
        String thumbnail = article.getThumbnail();
        String categories = article.getCategories();

        
    }
}
