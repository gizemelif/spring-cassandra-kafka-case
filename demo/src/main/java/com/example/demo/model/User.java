package com.example.demo.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@AllArgsConstructor
@Table(value = "user")
public class User {

    @PrimaryKey
    private int id;
    private String name;
    private String surname;
    private int[] FollowerList;
    private String createdAt;

    public User() {
    }

    public User(int id, String name, String surname, String createdAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int[] getFollowerList() {
        return FollowerList;
    }

    public void setFollowerList(int[] followerList) {
        FollowerList = followerList;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
