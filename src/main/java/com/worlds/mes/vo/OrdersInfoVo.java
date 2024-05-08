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
 * @program: mes订单信息表实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 订单信息表
 **/
@ApiModel(value = "订单信息表",description = "订单信息表实体")
@Data
public class OrdersInfoVo implements Serializable {

private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个订单的编码 */
@ApiModelProperty(value = "唯一标识每个订单的编码",required=true)
private String orderId;
/** 订单的客户名称 */
@ApiModelProperty(value = "订单的客户名称",required=true)
private String customerName;
/** 订单的创建日期 */
@ApiModelProperty(value = "订单的创建日期",required=true)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date orderDate;
/** 订单的预计交货日期 */
@ApiModelProperty(value = "订单的预计交货日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date deliveryDate;
/** 订单的类型，1生产订单、2销售订单 */
@ApiModelProperty(value = "订单的类型，1生产订单、2销售订单",required=true)
private String orderType;
/** 订单的状态，1已创建、2已审核、3已排产、4已生产、5已完成 */
@ApiModelProperty(value = "订单的状态，1已创建、2已审核、3已排产、4已生产、5已完成",required=true)
private String orderStatus;
/** 订单数量：订单中该产品的数量 */
@ApiModelProperty(value = "订单数量：订单中该产品的数量",required=true)
private String orderQuantity;
/** 产品信息id，外键指向产品信息表 */
@ApiModelProperty(value = "产品信息id，外键指向产品信息表",required=false)
private Integer productInfoId;
/** 生产信息id，外键指向生产信息表 */
@ApiModelProperty(value = "生产信息id，外键指向生产信息表",required=false)
private Integer productionInfoId;
/** 物流信息id，外键指向物流信息表 */
@ApiModelProperty(value = "物流信息id，外键指向物流信息表",required=false)
private Integer logisticsInfoId;
/** 物料信息id，外键指向物料信息表 */
@ApiModelProperty(value = "物料信息id，外键指向物料信息表",required=false)
private Integer materialInfoId;
/** 其他信息id，外键指向其他信息表 */
@ApiModelProperty(value = "其他信息id，外键指向其他信息表",required=false)
private Integer otherInfoId;
/** 其他需要记录的订单信息 */
@ApiModelProperty(value = "其他需要记录的订单信息",required=false)
private String remarks;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;



        public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("orderId",this.orderId);
        map.put("customerName",this.customerName);
        map.put("orderDate",this.orderDate);
        map.put("deliveryDate",this.deliveryDate);
        map.put("orderType",this.orderType);
        map.put("orderStatus",this.orderStatus);
        map.put("orderQuantity",this.orderQuantity);
        map.put("productInfoId",this.productInfoId);
        map.put("productionInfoId",this.productionInfoId);
        map.put("logisticsInfoId",this.logisticsInfoId);
        map.put("materialInfoId",this.materialInfoId);
        map.put("otherInfoId",this.otherInfoId);
        map.put("remarks",this.remarks);
    	return map;
}

	
}