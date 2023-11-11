package com.example.ecommerceapi.Service;

import com.example.ecommerceapi.Entity.BlogEntity;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Optional<BlogEntity> findBlogById(Long id);
    List<BlogEntity> getAllBlogs();
    BlogEntity saveBlog(BlogEntity blog);
    void deleteBlogById(Long id);
}
