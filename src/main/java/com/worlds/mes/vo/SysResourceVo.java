package com.worlds.mes.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.worlds.mes.commons.SimplePageInfo;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;




/**
 * @program: mes菜单权限表实体
 * @author: joeWorlds
 * @create: 2024-04-29 10:55:34
 * @return: 菜单权限表
 **/
@ApiModel(value = "菜单权限表",description = "菜单权限表实体")
@Data
public class SysResourceVo implements Serializable {

private static final long serialVersionUID = 1L;

/** 菜单权限表 */
@ApiModelProperty(value = "菜单权限表",required=true)
private Integer id;
/** 父级id */
@ApiModelProperty(value = "父级id",required=true)
private Integer pid;
/** 菜单类型，0顶部菜单、1聚合菜单、2页面菜单、3接口 */
@ApiModelProperty(value = "菜单类型，0顶部菜单、1聚合菜单、2页面菜单、3接口",required=true)
private Integer type;
/** 路由名称或接口名称 */
@ApiModelProperty(value = "路由名称或接口名称",required=false)
private String name;
/** 菜单路径(以http开头时，视为打开外部链接) 或 请求接口的地址 */
@ApiModelProperty(value = "菜单路径(以http开头时，视为打开外部链接) 或 请求接口的地址",required=true)
private String path;
/** 菜单组件，只有叶子菜单才可配置 */
@ApiModelProperty(value = "菜单组件，只有叶子菜单才可配置",required=false)
private String component;
/** 菜单的route.meta配置项，json格式 */
@ApiModelProperty(value = "菜单的route.meta配置项，json格式",required=false)
private String meta;
/** 0默认，1只有超级管理员才能使用 */
@ApiModelProperty(value = "0默认，1只有超级管理员才能使用",required=true)
private Byte admin;
/** 是否启用，0否1是 */
@ApiModelProperty(value = "是否启用，0否1是",required=true)
private Byte enable;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("pid",this.pid);
        map.put("type",this.type);
        map.put("name",this.name);
        map.put("path",this.path);
        map.put("component",this.component);
        map.put("meta",this.meta);
        map.put("admin",this.admin);
        map.put("enable",this.enable);
    	return map;
}

	
}