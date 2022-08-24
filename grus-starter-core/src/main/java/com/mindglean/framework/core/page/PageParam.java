package com.mindglean.framework.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页查询参数
 *
 * @author aircjm
 */
@ApiModel(value = "分页查询参数")
@Data
public class PageParam {

    @ApiModelProperty(value = "当前页")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "当前页大小")
    private Integer pageSize = 10;

}
