package me.shinsunyoung.springbootdeveloper.domain.dto;

import lombok.Getter;
import me.shinsunyoung.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
