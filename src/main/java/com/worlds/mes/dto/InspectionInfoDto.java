package com.worlds.mes.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import java.util.Date;

/**
 * @program: mes检验信息实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 检验信息
 **/
@ApiModel(value = "检验信息",description = "检验信息实体")
@Data
public class InspectionInfoDto implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个检验单的编码 */
@ApiModelProperty(value = "唯一标识每个检验单的编码",required=true)
private Integer inspectionId;
/** 对应产品信息表中的产品编号 */
@ApiModelProperty(value = "对应产品信息表中的产品编号",required=true)
private Integer productId;
/** 产品的生产批号 */
@ApiModelProperty(value = "产品的生产批号",required=true)
private String productionBatchNumber;
/** 检验的日期 */
@ApiModelProperty(value = "检验的日期",required=true)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date inspectionDate;
/** 检验的人员 */
@ApiModelProperty(value = "检验的人员",required=true)
private String inspector;
/** 检验的项目 */
@ApiModelProperty(value = "检验的项目",required=true)
private String inspectionItem;
/** 检验的方法 */
@ApiModelProperty(value = "检验的方法",required=false)
private String inspectionMethod;
/** 检验的结果 */
@ApiModelProperty(value = "检验的结果",required=false)
private String inspectionResult;
/** 检验的结论，如合格、不合格、待检、返工等 */
@ApiModelProperty(value = "检验的结论，如合格、不合格、待检、返工等",required=true)
private String inspectionConclusion;
/** 其他需要记录的质量信息 */
@ApiModelProperty(value = "其他需要记录的质量信息",required=false)
private String remarks;

	
}