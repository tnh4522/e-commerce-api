package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "review_product")
public class ReviewProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "avatar_user")
    private String avatarUser;
    @Column(name = "id_sub")
    private Integer idSub;
    @Column(name = "review")
    private String review;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(String avatarUser) {
        this.avatarUser = avatarUser;
    }

    public Integer getIdSub() {
        return idSub;
    }

    public void setIdSub(Integer idSub) {
        this.idSub = idSub;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewProductEntity that = (ReviewProductEntity) o;
        return id == that.id && idProduct == that.idProduct && idUser == that.idUser && Objects.equals(nameUser, that.nameUser) && Objects.equals(avatarUser, that.avatarUser) && Objects.equals(idSub, that.idSub) && Objects.equals(review, that.review) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProduct, idUser, nameUser, avatarUser, idSub, review, createdAt, updatedAt);
    }
}
