package com.example.ecommerceapi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private long id;
    private int idBlog;
    private int idUser;
    private String nameUser;
    private int idComment;
    private String comment;
    private String imageUser;
}
