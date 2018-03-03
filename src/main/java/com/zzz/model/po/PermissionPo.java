package com.zzz.model.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
@Entity
@Table(name = "permission")
public class PermissionPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "parent_id")
    private Integer parentId;

}
