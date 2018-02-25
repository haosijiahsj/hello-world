package com.zzz.controller;

import com.zzz.support.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest request, Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.serverError(ex.getMessage());
    }

}
