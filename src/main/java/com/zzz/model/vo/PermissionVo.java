package com.zzz.model.vo;

import lombok.Data;

/**
 * @author 胡胜钧
 * @date 3/3 0003.
 */
@Data
public class PermissionVo {

    private Integer id;
    private String name;
    private String description;
    private String url;
    private Integer parentId;

}
