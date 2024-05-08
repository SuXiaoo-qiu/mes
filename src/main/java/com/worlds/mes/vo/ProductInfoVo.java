package com.worlds.mes.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import java.util.Date;



/**
 * @program: mes产品信息表实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 产品信息表
 **/
@ApiModel(value = "产品信息表",description = "产品信息表实体")
@Data
public class ProductInfoVo implements Serializable {

private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 对应产品管理表中的产品编号 */
@ApiModelProperty(value = "对应产品管理表中的产品编号",required=true)
private String productId;
/** 产品的描述性名称 */
@ApiModelProperty(value = "产品的描述性名称",required=true)
private String productName;
/** 产品的技术参数，如尺寸、重量、材质等 */
@ApiModelProperty(value = "产品的技术参数，如尺寸、重量、材质等",required=false)
private String productSpecification;
/** 产品的分类，如原材料、半成品、成品等 */
@ApiModelProperty(value = "产品的分类，如原材料、半成品、成品等",required=true)
private String productCategory;
/** 产品的状态，如开发中、生产中、停产等 */
@ApiModelProperty(value = "产品的状态，如开发中、生产中、停产等",required=true)
private String productStatus;
/** 产品的计量单位 */
@ApiModelProperty(value = "产品的计量单位",required=true)
private String measurementUnit;
/** 产品的检验标准 */
@ApiModelProperty(value = "产品的检验标准",required=false)
private String inspectionStandard;
/** 产品的安全标准 */
@ApiModelProperty(value = "产品的安全标准",required=false)
private String safetyStandard;
/** 生产信息的外键ID */
@ApiModelProperty(value = "生产信息的外键ID",required=false)
private Integer productionInfoId;
/** 该产品预计的交货日期 */
@ApiModelProperty(value = "该产品预计的交货日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date expectedDeliveryDate;
/** 其他需要记录的产品信息 */
@ApiModelProperty(value = "其他需要记录的产品信息",required=false)
private String remarks;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("productId",this.productId);
        map.put("productName",this.productName);
        map.put("productSpecification",this.productSpecification);
        map.put("productCategory",this.productCategory);
        map.put("productStatus",this.productStatus);
        map.put("measurementUnit",this.measurementUnit);
        map.put("inspectionStandard",this.inspectionStandard);
        map.put("safetyStandard",this.safetyStandard);
        map.put("productionInfoId",this.productionInfoId);
        map.put("expectedDeliveryDate",this.expectedDeliveryDate);
        map.put("remarks",this.remarks);
    	return map;
}

	
}