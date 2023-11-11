package com.example.ecommerceapi.Convertor;

import com.example.ecommerceapi.Entity.CommentEntity;
import com.example.ecommerceapi.Model.Comment;

import java.util.List;

public class CommentConvertor {
    public static CommentEntity toEntity(Comment comment) {
        CommentEntity entity = new CommentEntity();
        entity.setId(comment.getId());
        entity.setIdBlog(comment.getIdBlog());
        entity.setIdUser(comment.getIdUser());
        entity.setNameUser(comment.getNameUser());
        entity.setIdComment(comment.getIdComment());
        entity.setComment(comment.getComment());
        entity.setImageUser(comment.getImageUser());
        return entity;
    }
    public static Comment toModel(CommentEntity entity) {
        Comment comment = new Comment();
        comment.setId(entity.getId());
        comment.setIdBlog(entity.getIdBlog());
        comment.setIdUser(entity.getIdUser());
        comment.setNameUser(entity.getNameUser());
        comment.setIdComment(entity.getIdComment());
        comment.setComment(entity.getComment());
        comment.setImageUser(entity.getImageUser());
        return comment;
    }
    public static List<Comment> toModelList(List<CommentEntity> entityList) {
        return entityList.stream().map(CommentConvertor::toModel).collect(java.util.stream.Collectors.toList());
    }
    public static List<CommentEntity> toEntityList(List<Comment> modelList) {
        return modelList.stream().map(CommentConvertor::toEntity).collect(java.util.stream.Collectors.toList());
    }
}
