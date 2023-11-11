package com.example.ecommerceapi.Service;

import com.example.ecommerceapi.Entity.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentEntity> getCommentsByBlogId(long blogId);
    List<CommentEntity> getAllComments();
}
