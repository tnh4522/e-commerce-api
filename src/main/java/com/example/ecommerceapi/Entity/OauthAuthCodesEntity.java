package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "oauth_auth_codes")
public class OauthAuthCodesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "scopes")
    private String scopes;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
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
        OauthAuthCodesEntity that = (OauthAuthCodesEntity) o;
        return userId == that.userId && clientId == that.clientId && revoked == that.revoked && Objects.equals(id, that.id) && Objects.equals(scopes, that.scopes) && Objects.equals(expiresAt, that.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, clientId, scopes, revoked, expiresAt);
    }
}
