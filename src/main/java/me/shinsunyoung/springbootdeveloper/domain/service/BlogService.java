package me.shinsunyoung.springbootdeveloper.domain.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.domain.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.domain.dto.UpdateArticleRequest;
import me.shinsunyoung.springbootdeveloper.domain.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 서블릿 컨테이너에 등록함
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) { // 블로그 글 추가 메서드
        return blogRepository.save(request.toEntity());
        //AddArticleRequest 클래스에 저장된 값들을 article 데이터베이스에 저장
    }
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
