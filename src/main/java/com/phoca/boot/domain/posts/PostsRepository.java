package com.phoca.boot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>{
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //SpringDataJpa에서 제공하지 않는 메소드 작성 방법, 가독성이 좋음
    List<Posts> findAllDesc();
}
