package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.CommentEntity;
import com.example.ecommerceapi.Repository.CommentRepository;
import com.example.ecommerceapi.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<CommentEntity> getCommentsByBlogId(long blogId) {
        return commentRepository.findCommentEntitiesByIdBlog(blogId);
    }
    @Override
    public List<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }
}
