package com.zzz.dao;

import com.zzz.model.po.UserRolePo;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author hushengjun
 * @date 2018/3/8
 */
public interface UserRoleRepository extends Repository<UserRolePo, Integer> {

    List<UserRolePo> findByUser(Integer user);

}
