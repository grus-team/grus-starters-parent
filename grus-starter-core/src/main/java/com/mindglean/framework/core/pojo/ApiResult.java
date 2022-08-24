package com.mindglean.framework.core.pojo;

import cn.hutool.http.HttpStatus;
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
public class ApiResult<T> {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty(value = "承载数据")
    private T data;

    public static <T> ApiResult<T> success() {
        return build(HttpStatus.HTTP_OK, "success", null);
    }

    public static <T> ApiResult<T> success(String msg) {
        return build(HttpStatus.HTTP_OK, msg, null);
    }

    public static <T> ApiResult<T> fail(Integer code, String msg) {
        return build(code, msg, null);
    }

    public static <T> ApiResult<T> fail(Integer code, String msg, T data) {
        return build(code, msg, data);
    }

    public static <T> ApiResult<T> data(T data) {
        return build(HttpStatus.HTTP_OK, "success", data);
    }

    public static <T> ApiResult<T> data(String msg, T data) {
        return build(HttpStatus.HTTP_OK, msg, data);
    }

    private static <T> ApiResult<T> build(Integer code, String msg, T data) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
