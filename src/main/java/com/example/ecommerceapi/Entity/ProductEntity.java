package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "id_category")
    private int idCategory;
    @Column(name = "id_brand")
    private int idBrand;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "web_id")
    private String webId;
    @Column(name = "price")
    private int price;
    @Column(name = "status")
    private byte status;
    @Column(name = "sale")
    private Integer sale;
    @Column(name = "`condition`")
    private String condition;
    @Column(name = "detail")
    private String detail;
    @Column(name = "company_profile")
    private String companyProfile;
    @Column(name = "highlight")
    private byte highlight;
    @Column(name = "active")
    private byte active;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Transient
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id && idCategory == that.idCategory && idBrand == that.idBrand && price == that.price && status == that.status && highlight == that.highlight && active == that.active && Objects.equals(idUser, that.idUser) && Objects.equals(name, that.name) && Objects.equals(image, that.image) && Objects.equals(webId, that.webId) && Objects.equals(sale, that.sale) && Objects.equals(condition, that.condition) && Objects.equals(detail, that.detail) && Objects.equals(companyProfile, that.companyProfile) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCategory, idBrand, idUser, name, image, webId, price, status, sale, condition, detail, companyProfile, highlight, active, createdAt, updatedAt);
    }
}
