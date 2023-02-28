package com.rimlook.framework.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页查询结果
 *
 * @author aircjm
 */
@ApiModel(value = "分页查询结果")
@Data
public class PageResult<T> {


    @ApiModelProperty(value = "当前页")
    private int current;

    @ApiModelProperty(value = "当前页数量")
    private int size;

    @ApiModelProperty(value = "总量")
    private int total;

    @ApiModelProperty(value = "记录")
    private List<T> records;

}
