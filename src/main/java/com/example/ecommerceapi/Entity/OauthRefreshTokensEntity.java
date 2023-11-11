package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "oauth_refresh_tokens")
public class OauthRefreshTokensEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "access_token_id")
    private String accessTokenId;
    @Column(name = "revoked")
    private byte revoked;
    @Column(name = "expires_at")
    private Timestamp expiresAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessTokenId() {
        return accessTokenId;
    }

    public void setAccessTokenId(String accessTokenId) {
        this.accessTokenId = accessTokenId;
    }

    public byte getRevoked() {
        return revoked;
    }

    public void setRevoked(byte revoked) {
        this.revoked = revoked;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthRefreshTokensEntity that = (OauthRefreshTokensEntity) o;
        return revoked == that.revoked && Objects.equals(id, that.id) && Objects.equals(accessTokenId, that.accessTokenId) && Objects.equals(expiresAt, that.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accessTokenId, revoked, expiresAt);
    }
}
