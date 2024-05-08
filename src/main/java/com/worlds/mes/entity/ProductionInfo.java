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
 * @program: mes生产信息实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 生产信息
 **/
@ApiModel(value = "生产信息",description = "生产信息实体")
@Data
public class ProductionInfo implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个生产单的编码 */
@ApiModelProperty(value = "唯一标识每个生产单的编码",required=false)
private String productionOrderNumber;
/** 对应产品信息表中的产品编号 */
@ApiModelProperty(value = "对应产品信息表中的产品编号",required=true)
private Integer productId;
/** 本次生产计划生产的产品数量 */
@ApiModelProperty(value = "本次生产计划生产的产品数量",required=true)
private Integer productionQuantity;
/** 本次生产的开始日期 */
@ApiModelProperty(value = "本次生产的开始日期",required=true)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date productionStartDate;
/** 本次生产计划的完成日期 */
@ApiModelProperty(value = "本次生产计划的完成日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date plannedCompletionDate;
/** 本次生产的实际完成日期 */
@ApiModelProperty(value = "本次生产的实际完成日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date actualCompletionDate;
/** 工艺id */
@ApiModelProperty(value = "工艺id",required=false)
private Integer processId;
/** 工序id */
@ApiModelProperty(value = "工序id",required=false)
private Integer operationId;
/** 检验信息id */
@ApiModelProperty(value = "检验信息id",required=false)
private Integer inspectionInfoId;
/** 生产的班次 */
@ApiModelProperty(value = "生产的班次",required=false)
private String workShift;
/** 生产的状态，如准备中、进行中、已完成、已暂停、已取消等 */
@ApiModelProperty(value = "生产的状态，如准备中、进行中、已完成、已暂停、已取消等",required=true)
private String productionStatus;
/** 产品的质量检验记录 */
@ApiModelProperty(value = "产品的质量检验记录",required=false)
private String qualityInspection;
/** 其他需要记录的生产信息 */
@ApiModelProperty(value = "其他需要记录的生产信息",required=false)
private String remarks;
	
}