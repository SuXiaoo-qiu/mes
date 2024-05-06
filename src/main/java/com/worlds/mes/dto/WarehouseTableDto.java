package com.worlds.mes.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: mes库存表实体
 * @author: joeWorlds
 * @create: 2024-05-07 06:51:21
 * @return: 库存表
 **/
@ApiModel(value = "库存表",description = "库存表实体")
@Data
public class WarehouseTableDto implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 仓库编号，唯一标识每个仓库的编码 */
@ApiModelProperty(value = "仓库编号，唯一标识每个仓库的编码",required=true)
private String warehouseId;
/** 仓库名称，仓库的描述性名称 */
@ApiModelProperty(value = "仓库名称，仓库的描述性名称",required=true)
private String warehouseName;
/** 仓库地址，仓库的实际地址 */
@ApiModelProperty(value = "仓库地址，仓库的实际地址",required=true)
private String warehouseAddress;
/** 仓库类型，仓库的分类，1原材料仓库、2成品仓库等 */
@ApiModelProperty(value = "仓库类型，仓库的分类，1原材料仓库、2成品仓库等",required=true)
private String warehouseType;
/** 仓库面积，仓库的占地面积 */
@ApiModelProperty(value = "仓库面积，仓库的占地面积",required=true)
private BigDecimal warehouseArea;
/** 仓容，仓库的最大存储容量 */
@ApiModelProperty(value = "仓容，仓库的最大存储容量",required=true)
private BigDecimal storageCapacity;
/** 负责人，仓库负责人的姓名 */
@ApiModelProperty(value = "负责人，仓库负责人的姓名",required=true)
private String responsiblePerson;
/** 联系电话，仓库负责人的联系电话 */
@ApiModelProperty(value = "联系电话，仓库负责人的联系电话",required=true)
private String contactPhone;
/** 备注，其他需要记录的仓库信息 */
@ApiModelProperty(value = "备注，其他需要记录的仓库信息",required=false)
private String remarks;

	
}