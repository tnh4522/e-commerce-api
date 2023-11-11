package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "oauth_clients")
public class OauthClientsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "secret")
    private String secret;
    @Column(name = "redirect")
    private String redirect;
    @Column(name = "personal_access_client")
    private byte personalAccessClient;
    @Column(name = "password_client")
    private byte passwordClient;
    @Column(name = "revoked")
    private byte revoked;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public byte getPersonalAccessClient() {
        return personalAccessClient;
    }

    public void setPersonalAccessClient(byte personalAccessClient) {
        this.personalAccessClient = personalAccessClient;
    }

    public byte getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(byte passwordClient) {
        this.passwordClient = passwordClient;
    }

    public byte getRevoked() {
        return revoked;
    }

    public void setRevoked(byte revoked) {
        this.revoked = revoked;
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
        OauthClientsEntity that = (OauthClientsEntity) o;
        return id == that.id && personalAccessClient == that.personalAccessClient && passwordClient == that.passwordClient && revoked == that.revoked && Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(secret, that.secret) && Objects.equals(redirect, that.redirect) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, secret, redirect, personalAccessClient, passwordClient, revoked, createdAt, updatedAt);
    }
}
