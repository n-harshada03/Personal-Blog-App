package com.blog.personal_blog.Controller;

import com.blog.personal_blog.Entity.Article;
import com.blog.personal_blog.Models.ArticleRequest;
import com.blog.personal_blog.Service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> postArticle(@RequestBody ArticleRequest articleRequest){
        boolean isPosted=articleService.addArticle(articleRequest);
        if(isPosted){
            return new ResponseEntity<>("Article is posted.", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Article is not posted.",HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/list/{username}")
//    public ResponseEntity<String> getAllArticlesByUsername(@PathVariable ("username") String username ){
//        List<Article> articles=articleService.getAllArticles();
//    }

}
