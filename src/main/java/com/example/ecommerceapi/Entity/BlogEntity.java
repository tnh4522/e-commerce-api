package com.example.ecommerceapi.Entity;

import com.example.ecommerceapi.Model.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "blog")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
    @Column(name = "id_auth")
    private int idAuth;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Transient
    private List<CommentEntity> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogEntity that = (BlogEntity) o;
        return id == that.id && idAuth == that.idAuth && Objects.equals(title, that.title) && Objects.equals(image, that.image) && Objects.equals(description, that.description) && Objects.equals(content, that.content) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, image, description, content, idAuth, createdAt, updatedAt);
    }

}
