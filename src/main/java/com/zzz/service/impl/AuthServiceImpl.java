package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zzz.dao.*;
import com.zzz.exceptions.IncorrectCredentialsException;
import com.zzz.exceptions.UnknownAccountException;
import com.zzz.model.po.*;
import com.zzz.model.vo.*;
import com.zzz.service.AuthService;
import com.zzz.support.AuthContext;
import com.zzz.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hushengjun
 * @date 2018/3/6
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public void login(HttpSession session, String username, String password) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "入参username不能为空！");

        UserPo userPo = userRepository.findByUsername(username);

        if (userPo == null) {
            log.info("通过username: [{}]没有查询到用户信息！", username);
            throw new UnknownAccountException();
        }

        if (!password.equals(userPo.getPassword())) {
            log.info("username: {}的密码不匹配！", username);
            throw new IncorrectCredentialsException();
        }

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);

        session.setAttribute("user", this.buildUserVo(userVo));
    }

    @Override
    public void logout(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        session.removeAttribute("user");
        log.info("用户：{}退出登录成功！", userVo.getUsername());
    }

    @Override
    public boolean authenticate(AuthContext authContext) {
        log.info("鉴定用户：{}是否拥有uri：{}的权限", authContext.getUserVo().getUsername(), authContext.getUri());

        if (CollectionUtils.isEmpty(authContext.getUserVo().getUserRoles())) {
            log.info("用户：{}没有任何权限！", authContext.getUserVo().getUsername());
            return false;
        }

        List<String> urls = Lists.newArrayList();
        authContext.getUserVo().getUserRoles().forEach(userRoleVo -> {
            userRoleVo.getRoleVo().getRolePermissions().forEach(rolePermissionVo -> {
                urls.add(rolePermissionVo.getPermissionVo().getUrl());
            });
        });

        if (CollectionUtils.isEmpty(urls)) {
            log.info("用户：{}没有任何权限！", authContext.getUserVo().getUsername());
            return false;
        } else {
            if (!urls.contains(authContext.getUri())) {
                log.info("用户：{}没有当前uri：{}的权限", authContext.getUserVo().getUsername(), authContext.getUri());
                return false;
            }
        }

        log.info("鉴权通过！");
        return true;
    }

    /**
     * 找到用户所有角色，权限
     * @param userVo
     * @return
     */
    private UserVo buildUserVo(UserVo userVo) {
        List<UserRolePo> userRolePos = userRoleRepository.findByUser(userVo.getId());
        if (CollectionUtils.isNotEmpty(userRolePos)) {
            List<UserRoleVo> userRoleVos = ConvertUtils.convertPos2Vos(userRolePos, UserRoleVo.class);

            userRoleVos.forEach(userRoleVo -> {
                RolePo rolePo = roleRepository.findById(userRoleVo.getRole());
                if (rolePo != null) {
                    RoleVo roleVo = new RoleVo();
                    BeanUtils.copyProperties(rolePo, roleVo);
                    userRoleVo.setRoleVo(roleVo);

                    List<RolePermissionPo> rolePermissionPos = rolePermissionRepository.findByRole(rolePo.getId());
                    if (CollectionUtils.isNotEmpty(rolePermissionPos)) {
                        List<RolePermissionVo> rolePermissionVos = ConvertUtils.convertPos2Vos(rolePermissionPos, RolePermissionVo.class);
                        roleVo.setRolePermissions(rolePermissionVos);

                        rolePermissionVos.forEach(rolePermissionVo -> {
                            PermissionPo permissionPo = permissionRepository.findById(rolePermissionVo.getPermission());
                            if (permissionPo != null) {
                                PermissionVo permissionVo = new PermissionVo();
                                BeanUtils.copyProperties(permissionPo, permissionVo);
                                rolePermissionVo.setPermissionVo(permissionVo);
                            }
                        });

                    }

                }
            });

            userVo.setUserRoles(userRoleVos);
        }

        return userVo;
    }

}
