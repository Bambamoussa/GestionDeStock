package com.bamba.gestiondestock.repository;

import com.bamba.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
   Optional <Article> findArticleByCodeArticle(String codeArticle);
}
