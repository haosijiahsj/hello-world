package com.zzz.dao

import com.zzz.model.po.PermissionPo
import org.springframework.data.repository.Repository

/**
 * @author hushengjun
 * *
 * @date 2018/3/8
 */
interface PermissionRepository : Repository<PermissionPo, Int> {

    fun findById(id: Int?): PermissionPo

    fun findByIdIn(ids: List<Int>): List<PermissionPo>

}
