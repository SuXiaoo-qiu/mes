package com.worlds.mes.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: mes用户角色表实体
 * @author: joeWorlds
 * @create: 2024-04-30 17:01:56
 * @return: 用户角色表
 **/
@ApiModel(value = "用户角色表",description = "用户角色表实体")
@Data
public class SysUserRoleDto implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
private Integer id;
/** 用户id */
@ApiModelProperty(value = "用户id",required=false)
private Integer userId;
/** 角色id */
@ApiModelProperty(value = "角色id",required=false)
private Integer roleId;

	
}