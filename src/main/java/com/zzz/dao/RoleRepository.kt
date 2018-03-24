package com.zzz.dao

import com.zzz.model.po.RolePo
import org.springframework.data.repository.Repository

/**
 * @author hushengjun
 * *
 * @date 2018/3/8
 */
interface RoleRepository : Repository<RolePo, Int> {

    fun findById(id: Int?): RolePo?

}
