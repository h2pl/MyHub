package com.cat.model;
import lombok.Data;
import javax.persistence.*;
/**
 * Created by 周杰伦 on 2018/1/12.
 */


/**
 * Created by XRog
 * On 2/2/2017.2:03 PM
 */
@Data
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created")
    private Long created = System.currentTimeMillis();

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remark")
    private String remark;
}