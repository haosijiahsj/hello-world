package com.zzz.dao

import com.zzz.model.po.RolePermissionPo
import org.springframework.data.repository.Repository

/**
 * @author hushengjun
 * *
 * @date 2018/3/8
 */
interface RolePermissionRepository : Repository<RolePermissionPo, Int> {

    fun findByRole(role: Int?): List<RolePermissionPo>

}
