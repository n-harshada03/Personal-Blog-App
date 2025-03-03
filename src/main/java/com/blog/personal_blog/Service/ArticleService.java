package com.blog.personal_blog.Service;

import com.blog.personal_blog.Entity.Article;
import com.blog.personal_blog.Models.ArticleRequest;

import java.util.List;

public interface ArticleService {

    public boolean addArticle(ArticleRequest articleRequest);

//    public List<Article> getAllArticles();
}
