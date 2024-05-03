package com.worlds.mes.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * @program: mes行政区划表实体
 * @author: joeWorlds
 * @create: 2024-04-30 14:26:02
 * @return: 行政区划表
 **/
@ApiModel(value = "行政区划表",description = "行政区划表实体")
@Data
public class SysRegionDto implements Serializable {
    
private static final long serialVersionUID = 1L;

/** 行政区划表 */
@ApiModelProperty(value = "行政区划表",required=true)
private String id;
@ApiModelProperty(value = "",required=true)
private String pid;
@ApiModelProperty(value = "",required=true)
private String name;
/** 全名，不同级别间以逗号隔开 */
@ApiModelProperty(value = "全名，不同级别间以逗号隔开",required=true)
private String fullname;
/** 节点级别，省、市、区 */
@ApiModelProperty(value = "节点级别，省、市、区",required=true)
private Integer level;

	
}