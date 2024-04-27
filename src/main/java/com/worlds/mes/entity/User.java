package com.worlds.mes.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;


/**
 * @program: mes用户表实体
 * @author: joeWorlds
 * @create: 2024-04-26 15:41:41
 * @return: 用户表
 **/
@ApiModel(value = "用户表",description = "用户表实体")
@Data
public class User implements Serializable {

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


}