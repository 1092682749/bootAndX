package com.example.demo.service.impl;

import com.example.demo.dao.ArticleMapper;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Override
    public int save(Article article) {
        return articleMapper.save(article);
    }

    @Override
    public List<Article> findMatch(String condition) {
        return articleMapper.findMatch(condition);
    }

    @Override
    public List<Article> findArticleByCondition(String condition) {
        List<Article> articles;
        if ("".equals(condition)) {
            articles = articleMapper.findPass();
        } else {
            articles = articleMapper.findMatch(condition);
        }
        return articles;
    }

    @Override
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    @Override
    public List<Article> findPass() {
        return articleMapper.findPass();
    }

    @Override
    public List<Article> findByAdminCondition(Article article) {
        return articleMapper.findByAdminCondition(article);
    }

    @Override
    public int changeAuditState(Integer state, Integer aid) {
        return articleMapper.changeAuditState(state, aid);
    }

    @Override
    public List<Article> findByTitle(String title) {
        return articleMapper.findByTitle(title);
    }
}
