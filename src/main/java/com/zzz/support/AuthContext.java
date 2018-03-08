package com.zzz.support;

import com.zzz.model.vo.UserVo;
import lombok.Data;

/**
 * @author hushengjun
 * @date 2018/3/6
 */
@Data
public class AuthContext {

    private UserVo userVo;
    private String uri;

}
