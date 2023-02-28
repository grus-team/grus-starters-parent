package com.rimlook.framework.core.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * API请求返回结果
 *
 * @author aircjm
 */
@ApiModel(value = "API请求返回结果")
@Data
public class Response<T> {

    /**
     * 成功
     */
    private static final Integer SUCCESS = 0;


    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty(value = "data")
    private T data;

    public static <T> com.rimlook.framework.core.pojo.Response<T> fail(Integer code, String msg) {
        return build(code, msg, null);
    }

    public static <T> com.rimlook.framework.core.pojo.Response<T> fail(Integer code, String msg, T data) {
        return build(code, msg, data);
    }

    public static <T> com.rimlook.framework.core.pojo.Response<T> success(T data) {
        return build(SUCCESS, "success", data);
    }


    public static com.rimlook.framework.core.pojo.Response success() {
        return build(SUCCESS, "success", null);
    }


    public static <T> com.rimlook.framework.core.pojo.Response<T> success(String msg, T data) {
        return build(SUCCESS, msg, data);
    }

    private static <T> com.rimlook.framework.core.pojo.Response<T> build(Integer code, String msg, T data) {
        com.rimlook.framework.core.pojo.Response<T> result = new com.rimlook.framework.core.pojo.Response<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
