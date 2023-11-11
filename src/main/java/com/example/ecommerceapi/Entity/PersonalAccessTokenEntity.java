package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "personal_access_token")
public class PersonalAccessTokenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "token")
    private String token;
    @Column(name = "abilities")
    private String abilities;
    @Column(name = "tokenable_id")
    private String tokenableId;
    @Column(name = "tokenable_type")
    private String tokenableType;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getTokenableId() {
        return tokenableId;
    }

    public void setTokenableId(String tokenableId) {
        this.tokenableId = tokenableId;
    }

    public String getTokenableType() {
        return tokenableType;
    }

    public void setTokenableType(String tokenableType) {
        this.tokenableType = tokenableType;
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
        PersonalAccessTokenEntity that = (PersonalAccessTokenEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(token, that.token) && Objects.equals(abilities, that.abilities) && Objects.equals(tokenableId, that.tokenableId) && Objects.equals(tokenableType, that.tokenableType) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, token, abilities, tokenableId, tokenableType, createdAt, updatedAt);
    }
}
