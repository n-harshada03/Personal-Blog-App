package com.blog.personal_blog.Service.Impl;

import com.blog.personal_blog.Entity.AppUser;
import com.blog.personal_blog.Entity.Article;
import com.blog.personal_blog.Models.ArticleRequest;
import com.blog.personal_blog.Repository.ArticleRepository;
import com.blog.personal_blog.Repository.UserRepository;
import com.blog.personal_blog.Service.ArticleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean addArticle(ArticleRequest articleRequest) {

        AppUser appUser=userRepository.findByUsername(articleRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        //request obj to entity save
        Article article=mapDTOtoArticleEntity(articleRequest,appUser);
        Article savedArticle=articleRepository.save(article);
        return true;
    }

    private Article mapDTOtoArticleEntity(ArticleRequest articleRequest,AppUser appUser) {
        return Article.builder()
                .articleTitle(articleRequest.getArticleTitle())
                .content(articleRequest.getContent())
                .publishDate(LocalDateTime.now())
                .appUser(appUser)
                .build();
    }
}
