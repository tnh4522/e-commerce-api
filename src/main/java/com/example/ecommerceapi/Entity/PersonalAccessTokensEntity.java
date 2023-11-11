package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "personal_access_tokens")
public class PersonalAccessTokensEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "tokenable_type")
    private String tokenableType;
    @Column(name = "tokenable_id")
    private long tokenableId;
    @Column(name = "name")
    private String name;
    @Column(name = "token")
    private String token;
    @Column(name = "abilities")
    private String abilities;
    @Column(name = "last_used_at")
    private Timestamp lastUsedAt;
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

    public String getTokenableType() {
        return tokenableType;
    }

    public void setTokenableType(String tokenableType) {
        this.tokenableType = tokenableType;
    }

    public long getTokenableId() {
        return tokenableId;
    }

    public void setTokenableId(long tokenableId) {
        this.tokenableId = tokenableId;
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

    public Timestamp getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(Timestamp lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
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
        PersonalAccessTokensEntity that = (PersonalAccessTokensEntity) o;
        return id == that.id && tokenableId == that.tokenableId && Objects.equals(tokenableType, that.tokenableType) && Objects.equals(name, that.name) && Objects.equals(token, that.token) && Objects.equals(abilities, that.abilities) && Objects.equals(lastUsedAt, that.lastUsedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tokenableType, tokenableId, name, token, abilities, lastUsedAt, createdAt, updatedAt);
    }
}
