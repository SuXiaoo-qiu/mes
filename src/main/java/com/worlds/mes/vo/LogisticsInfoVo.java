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
 * @program: mes物流信息表实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 物流信息表
 **/
@ApiModel(value = "物流信息表",description = "物流信息表实体")
@Data
public class LogisticsInfoVo implements Serializable {

private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个物流记录的编码 */
@ApiModelProperty(value = "唯一标识每个物流记录的编码",required=true)
private String logisticsId;
/** 对应MES订单表中的订单编号 */
@ApiModelProperty(value = "对应MES订单表中的订单编号",required=true)
private Integer orderId;
/** 对应MES产品信息表中的产品编号 */
@ApiModelProperty(value = "对应MES产品信息表中的产品编号",required=true)
private Integer productId;
/** 待运送产品的数量 */
@ApiModelProperty(value = "待运送产品的数量",required=true)
private Integer quantity;
/** 发货日期 */
@ApiModelProperty(value = "发货日期",required=true)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date shipDate;
/** 预计送达日期 */
@ApiModelProperty(value = "预计送达日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date estimatedArrivalDate;
/** 发货方式（例如空运、海运、陆运） */
@ApiModelProperty(value = "发货方式（例如空运、海运、陆运）",required=true)
private String shippingMethod;
/** 负责发货的物流公司名称 */
@ApiModelProperty(value = "负责发货的物流公司名称",required=true)
private String logisticsCompany;
/** 物流单号 */
@ApiModelProperty(value = "物流单号",required=false)
private String trackingNumber;
/** 1已发货, 2在途中,3已送达,4其他 */
@ApiModelProperty(value = "1已发货, 2在途中,3已送达,4其他",required=false)
private String shippingStatus;
/** 发货地址 */
@ApiModelProperty(value = "发货地址",required=true)
private String deliveryAddress;
/** 收货人姓名或公司名称 */
@ApiModelProperty(value = "收货人姓名或公司名称",required=true)
private String recipientName;
/** 收货人联系方式 */
@ApiModelProperty(value = "收货人联系方式",required=true)
private String contactInfo;
/** 关于发货的其他信息 */
@ApiModelProperty(value = "关于发货的其他信息",required=false)
private String remarks;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("logisticsId",this.logisticsId);
        map.put("orderId",this.orderId);
        map.put("productId",this.productId);
        map.put("quantity",this.quantity);
        map.put("shipDate",this.shipDate);
        map.put("estimatedArrivalDate",this.estimatedArrivalDate);
        map.put("shippingMethod",this.shippingMethod);
        map.put("logisticsCompany",this.logisticsCompany);
        map.put("trackingNumber",this.trackingNumber);
        map.put("shippingStatus",this.shippingStatus);
        map.put("deliveryAddress",this.deliveryAddress);
        map.put("recipientName",this.recipientName);
        map.put("contactInfo",this.contactInfo);
        map.put("remarks",this.remarks);
    	return map;
}

	
}