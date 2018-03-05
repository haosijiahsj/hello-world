package com.zzz.shiro;

import com.google.common.collect.Maps;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Map;

/**
 * @author hushengjun
 * @date 2018/3/5
 */
@Configuration
public class ShrioConfig {

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(MyShiroRealm myShiroRealm) {
        myShiroRealm.setCredentialsMatcher(new SimpleCredentialsMatcher());
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        // 采用EhCache 缓存
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        Map<String, String> filterChainDefinitionManager = Maps.newLinkedHashMap();
//
//        filterChainDefinitionManager.put("/user/logout", "logout");
//        filterChainDefinitionManager.put("/user/login", "anon");
//        // 可以理解为不拦截
//        filterChainDefinitionManager.put("/static/**", "anon");
//        filterChainDefinitionManager.put("/**", "authc");
//        shiroFilterFactoryBean
//                .setFilterChainDefinitionMap(filterChainDefinitionManager);
//
//        shiroFilterFactoryBean.setLoginUrl("/#/login");
//        shiroFilterFactoryBean.setSuccessUrl("/#/mian/");
        // shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        return shiroFilterFactoryBean;
    }

}
