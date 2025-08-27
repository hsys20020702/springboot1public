    package me.shinsunyoung.springbootdeveloper.domain.controller;

    import lombok.RequiredArgsConstructor;
    import me.shinsunyoung.springbootdeveloper.domain.Article;
    import me.shinsunyoung.springbootdeveloper.domain.dto.AddArticleRequest;
    import me.shinsunyoung.springbootdeveloper.domain.dto.ArticleResponse;
    import me.shinsunyoung.springbootdeveloper.domain.dto.UpdateArticleRequest;
    import me.shinsunyoung.springbootdeveloper.domain.service.BlogService;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
    @RestController // HTTP Response Body에 객체 데이터를 JSON 형태로 반환
    public class BlogApiController {
        private final BlogService blogService;

        @PostMapping("/api/articles")
        // HTTP 메서드가 POST일 때 받은 URL고 동일한 메서드와 매핑(addArticle() 메서드에 매핑)
        public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
            // HTTP를 요청할 때 응답에 해당하는 값을  @RequestBody 애너테이션이 붙은 대상 객체인 AddArticleRequest에 매핑
            Article savedArticle = blogService.save(request);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
            // 응답코드로 201(Create)를 응답하고 테이블에 저장된 객체를 반환
        }

        @GetMapping("/api/articles")
        public ResponseEntity<List<ArticleResponse>> findAllArticles() {
            List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();
            return ResponseEntity.ok().body(articles);
        }

        @GetMapping("/api/articles/{id}")
        public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
            Article article = blogService.findById(id);
            return ResponseEntity.ok().body(new ArticleResponse(article));
        }

        @DeleteMapping("/api/articles/{id}")
        public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
            blogService.delete(id);

            return ResponseEntity.ok().build();
        }

        @PutMapping("/api/articles/{id}")
        public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
            Article updatedArticle = blogService.update(id,request);
            return ResponseEntity.ok().body(updatedArticle);
        }
    }
