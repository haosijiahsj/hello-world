package com.zzz.model.vo;

import lombok.Data;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
public class RolePermissionVo {

    private Integer id;
    private Integer permission;
    private Integer role;
    private PermissionVo permissionVo;

}
