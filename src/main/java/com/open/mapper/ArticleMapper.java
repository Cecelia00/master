package com.open.mapper;

import com.open.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 查询所有的文章
     * @return
     */
    List<Article> getAll();

    /**
     * 根据id查询文章
     * @param uid
     * @return
     */
    Article findById(Integer uid);


    int addArticle(Article article);


}
