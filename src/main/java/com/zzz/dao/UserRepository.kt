package com.zzz.dao

import com.zzz.model.po.RolePo
import com.zzz.model.po.UserPo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository

import java.time.LocalDateTime

/**
 * @author 胡胜钧
 * *
 * @date 2/25 0025.
 */
interface UserRepository : Repository<UserPo, Int>, JpaSpecificationExecutor<UserPo> {

    fun save(userPo: UserPo)

    fun findByUsername(username: String): UserPo

    @Modifying
    @Query("UPDATE UserPo u SET u.password = ?2 WHERE u.username = ?1")
    fun updatePassword(username: String, password: String)

    fun findAll(): List<UserPo>

    fun findAll(pageable: Pageable): Page<UserPo>

    fun deleteById(id: Int?)

    @Modifying
    @Query("UPDATE UserPo u " +
            "SET u.username = ?2, u.password = ?3, u.name = ?4, u.sex = ?5, u.tel = ?6, u.updateTime = ?7 , u.status = ?8 " +
            "WHERE u.id = ?1")
    fun update(id: Int?, username: String, password: String, name: String, sex: Int?, tel: String, updateTime: LocalDateTime, status: Int?)

    fun findById(id: Int?): UserPo

}
