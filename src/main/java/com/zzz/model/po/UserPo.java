package com.zzz.model.po;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "name_")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "login_time")
    private LocalDateTime loginTime;

    @Column(name = "status_")
    private Integer status;

}
