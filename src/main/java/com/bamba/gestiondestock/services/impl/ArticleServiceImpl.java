package com.bamba.gestiondestock.services.impl;

import com.bamba.gestiondestock.dto.ArticleDto;
import com.bamba.gestiondestock.exception.EntityNotFoundException;
import com.bamba.gestiondestock.exception.ErrorCodes;
import com.bamba.gestiondestock.exception.InvalidEntityException;
import com.bamba.gestiondestock.model.Article;
import com.bamba.gestiondestock.repository.ArticleRepository;
import com.bamba.gestiondestock.services.ArticleService;
import com.bamba.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository ;
    }

    /**
     *
     * @param dto
     * @return
     */
    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}" , dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        Article saveArticle = articleRepository.save(ArticleDto.toEntity(dto));
        return ArticleDto.fromEntity(saveArticle);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return  null ;
        }

        Optional<Article> article = articleRepository.findById(id);

        ArticleDto articleDto = ArticleDto.fromEntity(article.get());

        return Optional.of(articleDto).orElseThrow(()->
                    new EntityNotFoundException("Aucun article avec l'ID = " + id + "n'a été trouvé dans la base" +
                            "de données", ErrorCodes.ARTICLE_NOT_FOUND));
    }

    /**
     *
     * @param codeArticle
     * @return
     */
    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("Article CODE is null");
            return  null ;
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        ArticleDto articleDto = ArticleDto.fromEntity(article.get());

        return Optional.of(articleDto).orElseThrow(()->
                new EntityNotFoundException("Aucun article avec le code = " + codeArticle + "n'a été trouvé dans la base" +
                        "de données", ErrorCodes.ARTICLE_NOT_FOUND));
    }

    /**
     *
     * @return
     */
    @Override
    public List<ArticleDto> findAll() {
         return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {

        if(id == null){
            log.error("Article ID is null");
            return;
        }

        articleRepository.deleteById(id);

    }
}
