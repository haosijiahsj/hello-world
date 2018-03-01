package com.zzz.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
@Data
public class UserVo {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private String tel;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime loginTime;
    private Integer status;

}
