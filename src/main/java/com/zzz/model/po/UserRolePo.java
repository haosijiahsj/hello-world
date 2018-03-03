package com.zzz.model.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
@Entity
@Table(name = "user_role")
public class UserRolePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_")
    private Integer user;

    @Column(name = "role")
    private Integer role;

}
