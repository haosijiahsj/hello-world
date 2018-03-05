package com.zzz.shiro;

import com.zzz.model.vo.UserVo;
import com.zzz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hushengjun
 * @date 2018/3/5
 */
@Slf4j
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        log.info("当前用户获取的token：{}", token);

        UserVo userVo = userService.findByUsername(token.getUsername());
        if (userVo == null) {
            throw new UnknownAccountException("该用户不存在！");
        }

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", userVo);
        // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        return new SimpleAuthenticationInfo(userVo.getUsername(), userVo.getPassword(), getName());
    }

}
