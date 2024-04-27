package com.worlds.mes.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: mes部门表实体
 * @author: joeWorlds
 * @create: 2024-04-27 20:47:18
 * @return: 部门表
 **/
@ApiModel(value = "部门表",description = "部门表实体")
@Data
public class Department implements Serializable {
    
private static final long serialVersionUID = 1L;

/** 部门表 */
@ApiModelProperty(value = "部门表",required=true)
private Integer id;
/** 父部门id */
@ApiModelProperty(value = "父部门id",required=true)
private Integer pid;
/** 部门名称 */
@ApiModelProperty(value = "部门名称",required=true)
private String name;
/** 是否启用，0否1是 */
@ApiModelProperty(value = "是否启用，0否1是",required=true)
private Byte enable;
	
}