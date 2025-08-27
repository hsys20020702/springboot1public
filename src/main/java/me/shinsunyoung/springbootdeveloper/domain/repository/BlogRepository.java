package me.shinsunyoung.springbootdeveloper.domain.repository;

import me.shinsunyoung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
