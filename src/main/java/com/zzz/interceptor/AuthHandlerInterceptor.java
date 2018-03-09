package com.zzz.interceptor;

import com.zzz.model.vo.UserVo;
import com.zzz.service.AuthService;
import com.zzz.support.AuthContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hushengjun
 * @date 2018/3/6
 */
@Slf4j
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String currentUri = request.getRequestURI();
        HttpSession session = request.getSession();
        UserVo userVo = (UserVo) session.getAttribute("user");

        if (userVo == null) {
            log.info("用户未登录！");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
            return false;
        }

        AuthContext authContext = new AuthContext();
        authContext.setUserVo(userVo);
        authContext.setUri(currentUri);

        boolean isPermission = authService.authenticate(authContext);
        if (!isPermission) {
            response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        }
        return isPermission;
    }

}
