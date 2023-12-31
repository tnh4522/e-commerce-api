package com.example.ecommerceapi.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "migrations")
public class MigrationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "migration")
    private String migration;
    @Column(name = "batch")
    private int batch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMigration() {
        return migration;
    }

    public void setMigration(String migration) {
        this.migration = migration;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MigrationsEntity that = (MigrationsEntity) o;
        return id == that.id && batch == that.batch && Objects.equals(migration, that.migration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, migration, batch);
    }
}
