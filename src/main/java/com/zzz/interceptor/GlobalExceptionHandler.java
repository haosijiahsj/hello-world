package com.zzz.interceptor;

import com.zzz.support.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest request, Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.serverError(ex.getMessage());
    }

}
