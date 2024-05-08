package com.worlds.mes.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;


/**
 * @program: mes客户信息表实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 客户信息表
 **/
@ApiModel(value = "客户信息表",description = "客户信息表实体")
@Data
public class CustomerInfo implements Serializable {
    
private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个客户记录的编码 */
@ApiModelProperty(value = "唯一标识每个客户记录的编码",required=true)
private String customerId;
/** 客户公司或组织的名称 */
@ApiModelProperty(value = "客户公司或组织的名称",required=true)
private String customerName;
/** 客户类型 */
@ApiModelProperty(value = "客户类型",required=true)
private String customerType;
/** 客户所在行业 */
@ApiModelProperty(value = "客户所在行业",required=false)
private String industry;
/** 客户位置（地址、城市、州、国家） */
@ApiModelProperty(value = "客户位置（地址、城市、州、国家）",required=false)
private String location;
/** 客户联系信息（电话号码、电子邮件地址、网站） */
@ApiModelProperty(value = "客户联系信息（电话号码、电子邮件地址、网站）",required=false)
private String contactInfo;
/** 主要联系人姓名 */
@ApiModelProperty(value = "主要联系人姓名",required=false)
private String primaryContactName;
/** 主要联系人联系信息 */
@ApiModelProperty(value = "主要联系人联系信息",required=false)
private String primaryContactInfo;
/** 客户状态 */
@ApiModelProperty(value = "客户状态",required=true)
private String customerStatus;
/** 客户信用条款 */
@ApiModelProperty(value = "客户信用条款",required=false)
private String creditTerms;
/** 客户付款历史记录 */
@ApiModelProperty(value = "客户付款历史记录",required=false)
private String paymentHistory;
/** 分配给客户的销售代表 */
@ApiModelProperty(value = "分配给客户的销售代表",required=false)
private String salesRepresentative;
	
}