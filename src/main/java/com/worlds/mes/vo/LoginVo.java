package com.worlds.mes.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: mes登录vo
 * @author: joeWorlds
 * @create: 2024-04-29 10:55:34
 * @return: 登录vo
 **/
@ApiModel(value = "登录vo",description = "登录vo实体")
@Data
public class LoginVo implements Serializable {

private static final long serialVersionUID = 1L;

/** 登录名 */
@ApiModelProperty(value = "登录名",required=true)
private String loginName;
/** 密码 */
@ApiModelProperty(value = "密码",required=false)
private String pwd;
/** token */
@ApiModelProperty(value = "token",required=true)
private String token;
/** 昵称 */
@ApiModelProperty(value = "昵称",required=true)
private String nickName;

}