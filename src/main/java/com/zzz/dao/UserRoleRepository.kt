package com.zzz.dao

import com.zzz.model.po.UserRolePo
import org.springframework.data.repository.Repository

/**
 * @author hushengjun
 * *
 * @date 2018/3/8
 */
interface UserRoleRepository : Repository<UserRolePo, Int> {

    fun findByUser(user: Int?): List<UserRolePo>

}
