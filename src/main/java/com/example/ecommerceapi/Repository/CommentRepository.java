package com.example.ecommerceapi.Repository;

import com.example.ecommerceapi.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentEntity> findByIdBlog(long blogId);
    List<CommentEntity> findCommentEntitiesByIdBlog(long blogId);
}
