package com.zzz.service;

import com.zzz.model.vo.UserVo;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
public interface UserService {

    UserVo findByUsername(String username);

}
