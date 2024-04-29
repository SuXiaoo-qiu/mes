package com.worlds.mes.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: mes登录实体
 * @author: joeWorlds
 * @create: 2024-04-29 10:55:34
 * @return: 登录
 **/
@ApiModel(value = "登录",description = "登录vo")
@Data
public class UserRegisterVo implements Serializable {

private static final long serialVersionUID = 1L;

/** 用户表 */
@ApiModelProperty(value = "用户表",required=true)
private Integer id;
/** 登录名 */
@ApiModelProperty(value = "登录名",required=true)
private String loginName;
/** 昵称 */
@ApiModelProperty(value = "昵称",required=true)
private String nickName;
/** 密码 */
@ApiModelProperty(value = "密码",required=true)
private String pwd;
/** 角色 */
@ApiModelProperty(value = "角色",required=false)
private Integer roleId;
/** 部门id */
@ApiModelProperty(value = "部门id",required=false)
private Integer deptId;
/** 头像url */
@ApiModelProperty(value = "头像url",required=false)
private String avatarUrl;
/** 创建时间 */
@ApiModelProperty(value = "创建时间",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date createTime;
/** 修改时间 */
@ApiModelProperty(value = "修改时间",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date updateTime;
/** 创建人 */
@ApiModelProperty(value = "创建人",required=false)
private String createPeople;
/** 修改人 */
@ApiModelProperty(value = "修改人",required=false)
private String updatePeople;
/** 是否为超级管理员 0否1是 */
@ApiModelProperty(value = "是否为超级管理员 0否1是",required=true)
private Byte admin;
/** 是否启用，0否1是 */
@ApiModelProperty(value = "是否启用，0否1是",required=true)
private Byte enable;
/** 明文密码 */
@ApiModelProperty(value = "明文密码",required=false)
private String pD;
/** 手机号 */
@ApiModelProperty(value = "手机号",required=false)
private String phoneNum;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("loginName",this.loginName);
        map.put("nickName",this.nickName);
        map.put("pwd",this.pwd);
        map.put("roleId",this.roleId);
        map.put("deptId",this.deptId);
        map.put("avatarUrl",this.avatarUrl);
        map.put("createTime",this.createTime);
        map.put("updateTime",this.updateTime);
        map.put("createPeople",this.createPeople);
        map.put("updatePeople",this.updatePeople);
        map.put("admin",this.admin);
        map.put("enable",this.enable);
        map.put("pD",this.pD);
        map.put("phoneNum",this.phoneNum);
    	return map;
}

	
}