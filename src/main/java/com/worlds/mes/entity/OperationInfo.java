package com.worlds.mes.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;


/**
 * @program: mes工序信息实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 工序信息
 **/
@ApiModel(value = "工序信息",description = "工序信息实体")
@Data
public class OperationInfo implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个工序的编码 */
@ApiModelProperty(value = "唯一标识每个工序的编码",required=true)
private String operationId;
/** 工序的描述性名称 */
@ApiModelProperty(value = "工序的描述性名称",required=true)
private String operationName;
/** 完成该工序所需的标准时间 */
@ApiModelProperty(value = "完成该工序所需的标准时间",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date standardTime;
/** 完成该工序的实际用时 */
@ApiModelProperty(value = "完成该工序的实际用时",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date actualTime;
/** 该工序的负责人 */
@ApiModelProperty(value = "该工序的负责人",required=false)
private String responsiblePerson;
/** 完成该工序所需的设备 */
@ApiModelProperty(value = "完成该工序所需的设备",required=false)
private String equipmentNeeded;
/** 完成该工序的人员 */
@ApiModelProperty(value = "完成该工序的人员",required=false)
private String personnelInvolved;
/** 该工序的质量检验记录 */
@ApiModelProperty(value = "该工序的质量检验记录",required=false)
private String qualityInspection;
/** 工序的状态，如准备中、进行中、已完成、已暂停、已取消等 */
@ApiModelProperty(value = "工序的状态，如准备中、进行中、已完成、已暂停、已取消等",required=true)
private String operationStatus;
/** 其他需要记录的工序信息 */
@ApiModelProperty(value = "其他需要记录的工序信息",required=false)
private String remarks;
/** 工艺id */
@ApiModelProperty(value = "工艺id",required=false)
private Integer processId;
	
}