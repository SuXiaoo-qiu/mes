package com.worlds.mes.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleAnDeptAndMenuVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 登录名 */
    @ApiModelProperty(value = "登录名",required=true)
    private String loginName;
    /** 用户id */
    @ApiModelProperty(value = "用户id",required=true)
    private String userId;
}
