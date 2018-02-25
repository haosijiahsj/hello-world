package com.zzz.model.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
@Data
@Entity
@Table(name = "user_")
public class UserPo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
