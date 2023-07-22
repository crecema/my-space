package com.crecema.my.space.common;

import lombok.Getter;

public class CommonException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    public CommonException(ErrorCode errorCode) {
        super(buildMessage(errorCode, null));
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCode errorCode, String message) {
        super(buildMessage(errorCode, message));
        this.errorCode = errorCode;
    }

    private static String buildMessage(ErrorCode errorCode, String message) {
        if (errorCode == null) {
            return message;
        }
        return errorCode.getCode() + " | " + errorCode.getDesc() + " | " + message;
    }

}
