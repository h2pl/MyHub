package com.cat.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 周杰伦 on 2018/1/12.
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

}
