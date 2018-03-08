package com.zzz.exceptions;

/**
 * @author hushengjun
 * @date 2018/3/8
 */
public class AuthException extends RuntimeException {

    private static final long serialVersionUID = -1552759653113252964L;

    public AuthException() {super();}

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

}
