package com.example.demo.model;

import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@Table(value = "UserFollowers")
public class UserFollowers {

    @PrimaryKey
    private int id;
    private int[] followerList;
    private int userId;

}
