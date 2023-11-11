package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.BlogEntity;
import com.example.ecommerceapi.Repository.BlogRepository;
import com.example.ecommerceapi.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Optional<BlogEntity> findBlogById(Long id) {
        return blogRepository.findById(id);
    }
    @Override
    public List<BlogEntity> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public BlogEntity saveBlog(BlogEntity blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Long id) {
        blogRepository.deleteById(id);
    }
}
