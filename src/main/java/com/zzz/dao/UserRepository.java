package com.zzz.dao;

import com.zzz.model.po.UserPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
public interface UserRepository extends Repository<UserPo, Integer>, JpaSpecificationExecutor<UserPo> {

    void save(UserPo userPo);

    UserPo findByUsername(String username);

    @Modifying
    @Query("UPDATE UserPo u SET u.password = ?2 WHERE u.username = ?1")
    void updatePassword(String username, String password);

    List<UserPo> findAll();

    Page<UserPo> findAll(Pageable pageable);

    void deleteById(Integer id);

}
