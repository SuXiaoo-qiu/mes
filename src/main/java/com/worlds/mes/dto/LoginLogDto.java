package com.worlds.mes.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

import java.util.Date;

/**
 * @program: mes登录日志表实体
 * @author: joeWorlds
 * @create: 2024-04-29 12:53:54
 * @return: 登录日志表
 **/
@ApiModel(value = "登录日志表",description = "登录日志表实体")
@Data
public class LoginLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "id",required=true)
    private Integer id;
    /** 登录id */
    @ApiModelProperty(value = "登录id",required=false)
    private String userId;
    /** 登录名称 */
    @ApiModelProperty(value = "登录名称",required=false)
    private String userName;
    /** 登录时间 */
    @ApiModelProperty(value = "登录时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginDate;
    /** ip */
    @ApiModelProperty(value = "ip",required=false)
    private String ip;
    /** 备注 */
    @ApiModelProperty(value = "备注",required=false)
    private String message;


}