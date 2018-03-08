package com.zzz.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
public class RoleVo {

    private Integer id;
    private String name;
    private List<RolePermissionVo> rolePermissions;

}
