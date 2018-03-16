package com.zzz.model.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
@Entity
@Table(name = "role")
public class RolePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "available")
    private Boolean available;

}
