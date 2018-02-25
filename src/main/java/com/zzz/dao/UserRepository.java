package com.zzz.dao;

import com.zzz.model.po.UserPo;
import org.springframework.data.repository.Repository;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
public interface UserRepository extends Repository<UserPo, Integer> {

    void save(UserPo userPo);

    UserPo findByUsername(String username);

    UserPo findByUsernameAndPassword(String username, String password);

}
