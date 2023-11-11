package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "password_resets")
public class PasswordResetsEntity {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "token")
    private String token;
    @Column(name = "created_at")
    private Timestamp createdAt;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetsEntity that = (PasswordResetsEntity) o;
        return Objects.equals(email, that.email) && Objects.equals(token, that.token) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, token, createdAt);
    }
}
