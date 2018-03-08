package com.zzz.dao;

import com.zzz.model.po.RolePermissionPo;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author hushengjun
 * @date 2018/3/8
 */
public interface RolePermissionRepository extends Repository<RolePermissionPo, Integer> {

    List<RolePermissionPo> findByRole(Integer role);

}
