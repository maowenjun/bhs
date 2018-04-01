package com.bhs.app.model;

import org.springframework.data.annotation.Id;

/**
 * Created by ThinkPad on 2018/3/17.
 */
public class User {

    @Id
    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
