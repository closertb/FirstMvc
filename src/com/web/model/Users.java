package com.web.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicUpdate(true)
public class Users {
    private int id;
    private String name;
    private String pwd;
    private Timestamp updatedAt;
    private Timestamp createdAt;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd", nullable = true, length = 50)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "updatedAt", nullable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "createdAt", nullable = true)
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
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(pwd, users.pwd) &&
                Objects.equals(updatedAt, users.updatedAt) &&
                Objects.equals(createdAt, users.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pwd, updatedAt, createdAt);
    }
}
