package com.zzz.service;

import com.zzz.model.vo.UserVo;
import com.zzz.support.PageResult;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
public interface UserService {

    void save(UserVo userVo);

    UserVo findByUsername(String username);

    void updatePassword(UserVo userVo);

    List<UserVo> findAll();

    PageResult<UserVo> findAll(UserVo userVo, Pageable pageable);

    PageResult<UserVo> findUser(String username, Pageable pageable);

    void delete(Integer id);

}
