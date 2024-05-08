package com.worlds.mes.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;


/**
 * @program: mes工艺信息实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 工艺信息
 **/
@ApiModel(value = "工艺信息",description = "工艺信息实体")
@Data
public class ProcessInfoDto implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个工艺的编码 */
@ApiModelProperty(value = "唯一标识每个工艺的编码",required=true)
private String processId;
/** 工艺的描述性名称 */
@ApiModelProperty(value = "工艺的描述性名称",required=true)
private String processName;
/** 工艺的版本号 */
@ApiModelProperty(value = "工艺的版本号",required=true)
private String processVersion;
/** 工艺的类型，如装配工艺、加工工艺、检测工艺等 */
@ApiModelProperty(value = "工艺的类型，如装配工艺、加工工艺、检测工艺等",required=true)
private String processType;
/** 该工艺适用的产品 */
@ApiModelProperty(value = "该工艺适用的产品",required=false)
private String applicableProduct;
/** 工艺的状态，如开发中、试用中、生产中、停用等 */
@ApiModelProperty(value = "工艺的状态，如开发中、试用中、生产中、停用等",required=true)
private String processStatus;
/** 工艺的详细流程 */
@ApiModelProperty(value = "工艺的详细流程",required=false)
private String processFlow;
/** 工艺的相关文件，如工艺图纸、工艺说明书等 */
@ApiModelProperty(value = "工艺的相关文件，如工艺图纸、工艺说明书等",required=false)
private String processFile;
/** 其他需要记录的工艺信息 */
@ApiModelProperty(value = "其他需要记录的工艺信息",required=false)
private String remarks;

	
}