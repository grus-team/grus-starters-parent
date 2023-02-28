package com.rimlook.framework.core.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 业务异常类
 *
 * @author aircjm
 */
@NoArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

    private Integer code = 999;

    /**
     * 仅错误信息
     *
     * @param msg 错误信息
     */
    public BusinessException(String msg) {
        super(msg);
    }

    /**
     * 错误码 + 错误信息
     *
     * @param code 错误码
     * @param msg  错误信息
     */
    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String msg, Throwable throwable) {
        // todo need to resolve this throwable
        super(msg);
        this.code = code;
    }
}
