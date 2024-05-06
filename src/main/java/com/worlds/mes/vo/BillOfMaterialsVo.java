package com.worlds.mes.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.worlds.mes.commons.SimplePageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * @program: mes物料表实体
 * @author: joeWorlds
 * @create: 2024-05-07 06:51:21
 * @return: 物料表
 **/
@ApiModel(value = "物料表",description = "物料表实体")
@Data
public class BillOfMaterialsVo implements Serializable {

private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 物料的唯一标识符 */
@ApiModelProperty(value = "物料的唯一标识符",required=true)
private String materialId;
/** 物料编号，唯一标识每个物料的编码 */
@ApiModelProperty(value = "物料编号，唯一标识每个物料的编码",required=true)
private String materialCode;
/** 物料名称，物料的描述性名称 */
@ApiModelProperty(value = "物料名称，物料的描述性名称",required=true)
private String materialName;
/** 物料规格，物料的技术参数，如尺寸、重量、材质等 */
@ApiModelProperty(value = "物料规格，物料的技术参数，如尺寸、重量、材质等",required=false)
private String materialSpecification;
/** 计量单位，物料的计量单位 */
@ApiModelProperty(value = "计量单位，物料的计量单位",required=true)
private String measurementUnit;
/** 物料类别，物料的分类，如原材料、半成品、成品等 */
@ApiModelProperty(value = "物料类别，物料的分类，如原材料、半成品、成品等",required=true)
private String materialCategory;
/** 供应商id，物料的供应商信息（建议为外键） */
@ApiModelProperty(value = "供应商id，物料的供应商信息（建议为外键）",required=false)
private Integer supplierId;
/** 供应商名称，物料的供应商信息（建议只存储供应商id） */
@ApiModelProperty(value = "供应商名称，物料的供应商信息（建议只存储供应商id）",required=false)
private String supplierName;
/** 库存编号，唯一标识每个库存记录的编码 */
@ApiModelProperty(value = "库存编号，唯一标识每个库存记录的编码",required=false)
private Integer inventoryNum;
/** 库存名称，标识每个库存名称 */
@ApiModelProperty(value = "库存名称，标识每个库存名称",required=false)
private String inventoryName;
/** 仓库编号，唯一标识每个仓库的编码（建议为外键） */
@ApiModelProperty(value = "仓库编号，唯一标识每个仓库的编码（建议为外键）",required=false)
private Integer warehouseId;
/** 仓库名称，仓库的描述性名称（建议只存储仓库id） */
@ApiModelProperty(value = "仓库名称，仓库的描述性名称（建议只存储仓库id）",required=false)
private String warehouseName;
/** 保质期，物料的有效期 */
@ApiModelProperty(value = "保质期，物料的有效期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date expirationDate;
/** 生产日期，物料的生产日期 */
@ApiModelProperty(value = "生产日期，物料的生产日期",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date productionDate;
/** 批号，物料的批次号 */
@ApiModelProperty(value = "批号，物料的批次号",required=false)
private String batchNumber;
/** 状态，物料的状态，如可用、待检、已出库等 */
@ApiModelProperty(value = "状态，物料的状态，如可用、待检、已出库等",required=true)
private String status;
/** 备注，其他需要记录的物料信息 */
@ApiModelProperty(value = "备注，其他需要记录的物料信息",required=false)
private String remarks;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("materialId",this.materialId);
        map.put("materialCode",this.materialCode);
        map.put("materialName",this.materialName);
        map.put("materialSpecification",this.materialSpecification);
        map.put("measurementUnit",this.measurementUnit);
        map.put("materialCategory",this.materialCategory);
        map.put("supplierId",this.supplierId);
        map.put("supplierName",this.supplierName);
        map.put("inventoryNum",this.inventoryNum);
        map.put("inventoryName",this.inventoryName);
        map.put("warehouseId",this.warehouseId);
        map.put("warehouseName",this.warehouseName);
        map.put("expirationDate",this.expirationDate);
        map.put("productionDate",this.productionDate);
        map.put("batchNumber",this.batchNumber);
        map.put("status",this.status);
        map.put("remarks",this.remarks);
    	return map;
}

	
}