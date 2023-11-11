package com.example.ecommerceapi.Controller;

import com.example.ecommerceapi.Entity.BlogEntity;
import com.example.ecommerceapi.Entity.CommentEntity;
import com.example.ecommerceapi.Service.BlogService;
import com.example.ecommerceapi.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "https://food-mart-e-commerce.onrender.com")
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/list")
    public ResponseEntity<List<BlogEntity>> findAllBlogs() {
        List<BlogEntity> blogEntities = blogService.getAllBlogs();
        List<CommentEntity> commentEntities = commentService.getAllComments();
        Map<Long, List<CommentEntity>> commentMap = new HashMap<>();
        for (CommentEntity commentEntity : commentEntities) {
            commentMap
                    .computeIfAbsent((long)commentEntity.getIdBlog(), k -> new ArrayList<>())
                    .add(commentEntity);
        }
        for (BlogEntity blogEntity : blogEntities) {
            List<CommentEntity> blogComments = commentMap.getOrDefault(blogEntity.getId(), new ArrayList<>());
            blogEntity.setComments(blogComments);
        }
        return ResponseEntity.ok(blogEntities);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogEntity> findBlogById(@PathVariable Long id) {
        Optional<BlogEntity> blogOptional = blogService.findBlogById(id);
        if(blogOptional.isPresent()) {
            BlogEntity blogEntity = blogOptional.get();
            List<CommentEntity> commentEntities = commentService.getCommentsByBlogId(id);
            blogEntity.setComments(commentEntities);
            return ResponseEntity.ok(blogEntity);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogEntity> saveBlog(@RequestBody BlogEntity blog) {
        return ResponseEntity.ok(blogService.saveBlog(blog));
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<BlogEntity> updateBlog(@PathVariable Long id, @RequestBody BlogEntity blog) {
        Optional<BlogEntity> blogOptional = blogService.findBlogById(id);
        if (blogOptional.isPresent()) {
            BlogEntity blogEntity = blogOptional.get();
            blogEntity.setTitle(blog.getTitle());
            blogEntity.setContent(blog.getContent());
            blogEntity.setIdAuth(blog.getIdAuth());
            blogEntity.setImage(blog.getImage());
            return ResponseEntity.ok(blogService.saveBlog(blogEntity));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable Long id) {
        blogService.deleteBlogById(id);
        return ResponseEntity.ok().build();
    }
}
