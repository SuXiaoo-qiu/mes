package com.worlds.mes.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@ApiModel(value = "返回信息",description = "返回信息实体")
@Data
public class ResultDto <T> implements Serializable {
    @ApiModelProperty(value = "是否成功 true:成功 false:失败")
    private Boolean success;
    @ApiModelProperty(value = "状态码 200:OK 400:错误的请求 401:未经授权 403:被禁止的 404:未找到 500:内部服务器错误")
    private Integer code;
    @ApiModelProperty(value = "附加信息")
    private String message;
    @ApiModelProperty(value = "当前页码")
    private Integer pageNum;
    @ApiModelProperty(value = "每页显示的记录数量")
    private Integer pageSize;
    @ApiModelProperty(value = "总页数")
    private Integer pageCount;
    @ApiModelProperty(value = "数据总数")
    private Long total;
    @ApiModelProperty(value = "分页查询结果的实际内容")
    private T data;

        public ResultDto() {
            this.success = Boolean.TRUE;
        }

        public ResultDto(T data) {
            this.success = Boolean.TRUE;
            this.data = data;
        }

        public static <T> ResultDto<T> newResult() {
            return new ResultDto();
        }

        public static <T> ResultDto<T> newResult(T data) {
            return new ResultDto(data);
        }



    }

