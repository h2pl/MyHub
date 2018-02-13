package com.cat.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by 周杰伦 on 2018/1/12.
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

}
