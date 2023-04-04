package com.open.service;

import com.open.pojo.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    /**
     * 添加文章
     * @param article
     */
    void addArticle(Article article);
}
