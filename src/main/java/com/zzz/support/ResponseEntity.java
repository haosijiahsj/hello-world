package com.zzz.support;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author hushengjun
 * @date 2018/1/17
 */
@Data
@Builder
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = 383578243227855964L;

    private Integer code;
    private String msg;
    private Object content;

    public static ResponseEntity ok() {
        return ResponseEntity.builder()
                .code(HttpStatus.OK.value())
                .msg(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    public static ResponseEntity ok(Object content) {
        return ResponseEntity.builder()
                .code(HttpStatus.OK.value())
                .msg(HttpStatus.OK.getReasonPhrase())
                .content(content)
                .build();
    }

    public static ResponseEntity noContent() {
        return ResponseEntity.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .msg(HttpStatus.NO_CONTENT.getReasonPhrase())
                .build();
    }

    public static ResponseEntity serverError() {
        return ResponseEntity.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .msg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
    }

    public static ResponseEntity serverError(String exceptionMsg) {
        return ResponseEntity.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .msg(exceptionMsg)
                .build();
    }

    public static ResponseEntity of(HttpStatus status) {
        return ResponseEntity.builder()
                .code(status.value())
                .msg(status.getReasonPhrase())
                .build();
    }

    public static ResponseEntity of(HttpStatus status, Object content) {
        return ResponseEntity.builder()
                .code(status.value())
                .msg(status.getReasonPhrase())
                .content(content)
                .build();
    }

    public static ResponseEntity of(int code, String msg) {
        return ResponseEntity.builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static ResponseEntity of(int code, String msg, Object content) {
        return ResponseEntity.builder()
                .code(code)
                .msg(msg)
                .content(content)
                .build();
    }

}
