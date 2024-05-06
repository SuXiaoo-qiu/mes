package com.worlds.mes.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: mes库存表实体
 * @author: joeWorlds
 * @create: 2024-05-07 06:51:21
 * @return: 库存表
 **/
@ApiModel(value = "库存表",description = "库存表实体")
@Data
public class InventoryTableDto implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 库存编号，唯一标识每个库存记录的编码 */
@ApiModelProperty(value = "库存编号，唯一标识每个库存记录的编码",required=false)
private String inventoryId;
/** 库存名称，标识每个库存名称 */
@ApiModelProperty(value = "库存名称，标识每个库存名称",required=false)
private String inventoryName;
/** 物料编号，对应物料管理表中的物料编号 */
@ApiModelProperty(value = "物料编号，对应物料管理表中的物料编号",required=true)
private Integer materialId;
/** 仓库编号，对应仓库管理表中的仓库编号 */
@ApiModelProperty(value = "仓库编号，对应仓库管理表中的仓库编号",required=true)
private Integer warehouseId;
/** 入库单号，唯一标识每次入库操作的编码 */
@ApiModelProperty(value = "入库单号，唯一标识每次入库操作的编码",required=false)
private String inOrderId;
/** 出库单号，唯一标识每次出库操作的编码 */
@ApiModelProperty(value = "出库单号，唯一标识每次出库操作的编码",required=false)
private String outOrderId;
/** 入库日期，物料入库日期 */
@ApiModelProperty(value = "入库日期，物料入库日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date inDate;
/** 出库日期，物料出库日期 */
@ApiModelProperty(value = "出库日期，物料出库日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date outDate;
/** 入库数量，入库物料的数量 */
@ApiModelProperty(value = "入库数量，入库物料的数量",required=true)
private BigDecimal inQuantity;
/** 出库数量，出库物料的数量 */
@ApiModelProperty(value = "出库数量，出库物料的数量",required=true)
private BigDecimal outQuantity;
/** 入库单价，入库物料的单价 */
@ApiModelProperty(value = "入库单价，入库物料的单价",required=false)
private BigDecimal inPrice;
/** 出库单价，出库物料的单价 */
@ApiModelProperty(value = "出库单价，出库物料的单价",required=false)
private BigDecimal outPrice;
/** 最大库存 */
@ApiModelProperty(value = "最大库存",required=false)
private BigDecimal maxStock;
/** 安全库存 */
@ApiModelProperty(value = "安全库存",required=false)
private BigDecimal safeStock;
/** 剩余库存 */
@ApiModelProperty(value = "剩余库存",required=false)
private BigDecimal remainingStock;
/** 类型：1入库2出库 */
@ApiModelProperty(value = "类型：1入库2出库",required=true)
private Byte type;
/** 批次号，库存批次号 */
@ApiModelProperty(value = "批次号，库存批次号",required=false)
private String batchNumber;
/** 备注，其他需要记录的库存信息 */
@ApiModelProperty(value = "备注，其他需要记录的库存信息",required=false)
private String remarks;
/** 状态，库存状态，如可用、待检、已锁定 */
@ApiModelProperty(value = "状态，库存状态，如可用、待检、已锁定",required=true)
private String status;

	
}