package com.zzz.model.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
@Entity
@Table(name = "role_permission")
public class RolePermissionPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    private Integer role;

    @Column(name = "permission")
    private Integer permission;

}
