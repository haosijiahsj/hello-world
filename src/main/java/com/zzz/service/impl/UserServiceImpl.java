package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.zzz.dao.UserRepository;
import com.zzz.model.po.UserPo;
import com.zzz.model.vo.UserVo;
import com.zzz.service.UserService;
import com.zzz.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserVo userVo) {
        Preconditions.checkArgument(userVo != null, "入参userVo不能为空！");

        UserPo userPo = new UserPo();

        BeanUtils.copyProperties(userVo, userPo);

        userRepository.save(userPo);
    }

    @Override
    public UserVo findByUsername(String username) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "入参username不能为空！");

        UserPo userPo = userRepository.findByUsername(username);

        if (userPo == null) {
            log.info("通过username: [{}]没有查询到用户信息！", username);
            return null;
        }

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);

        return userVo;
    }

    @Override
    public void updatePassword(UserVo userVo) {
        Preconditions.checkArgument(userVo != null, "入参userVo不能为空！");

        userRepository.updatePassword(userVo.getUsername(), userVo.getPassword());
    }

    @Override
    public List<UserVo> findAll() {
        List<UserPo> userPos = userRepository.findAll();

        return CollectionUtils.isEmpty(userPos) ? Collections.emptyList()
                : ConvertUtils.convertPos2Vos(userPos, UserVo.class);
    }

}
