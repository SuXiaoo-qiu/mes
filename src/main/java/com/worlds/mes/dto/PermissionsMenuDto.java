package com.worlds.mes.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "返回信息",description = "返回信息实体")
@Data
public class PermissionsMenuDto<T> implements Serializable {
    @ApiModelProperty(value = "是否成功 true:成功 false:失败")
    private Boolean success;
    @ApiModelProperty(value = "状态码 200:OK 400:错误的请求 401:未经授权 403:被禁止的 404:未找到 500:内部服务器错误 5000:没查询到数据")
    private Integer code;
    @ApiModelProperty(value = "附加信息")
    private String message;
    @ApiModelProperty(value = "实际内容")
    private T data;
    @ApiModelProperty(value = "部门信息")
    private T deptList;
    @ApiModelProperty(value = "角色信息")
    private T roleList;
    @ApiModelProperty(value = "菜单信息")
    private T resourceList;
    @ApiModelProperty(value = "用户信息")
    private T userList;


        public PermissionsMenuDto() {
            this.success = Boolean.TRUE;
        }

        public PermissionsMenuDto(T data) {
            this.success = Boolean.TRUE;
            this.data = data;
        }

        public static <T> PermissionsMenuDto<T> newResult() {
            return new PermissionsMenuDto();
        }

        public static <T> PermissionsMenuDto<T> newResult(T data) {
            return new PermissionsMenuDto(data);
        }



    }

