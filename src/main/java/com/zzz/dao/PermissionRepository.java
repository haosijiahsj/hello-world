package com.zzz.dao;

import com.zzz.model.po.PermissionPo;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author hushengjun
 * @date 2018/3/8
 */
public interface PermissionRepository extends Repository<PermissionPo, Integer> {

    PermissionPo findById(Integer id);

    List<PermissionPo> findByIdIn(List<Integer> ids);

}
