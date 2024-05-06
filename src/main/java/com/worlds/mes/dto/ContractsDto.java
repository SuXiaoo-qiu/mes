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
 * @program: mes合同信息表实体
 * @author: joeWorlds
 * @create: 2024-05-06 17:20:30
 * @return: 合同信息表
 **/
@ApiModel(value = "合同信息表",description = "合同信息表实体")
@Data
public class ContractsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "id",required=true)
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /** 合同编号 */
    @ApiModelProperty(value = "合同编号",required=true)
    private String contractNum;
    /** 合同的简要名称 */
    @ApiModelProperty(value = "合同的简要名称",required=true)
    private String contractName;
    /** 合同的类型，1:销售合同、2:采购合同、3:服务合同 */
    @ApiModelProperty(value = "合同的类型，1:销售合同、2:采购合同、3:服务合同",required=true)
    private String contractType;
    /** 合同签订的日期 */
    @ApiModelProperty(value = "合同签订的日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date contractSignDate;
    /** 合同生效的日期 */
    @ApiModelProperty(value = "合同生效的日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date effectiveDate;
    /** 合同终止的日期 */
    @ApiModelProperty(value = "合同终止的日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date terminationDate;
    /** 合同的总金额 */
    @ApiModelProperty(value = "合同的总金额",required=true)
    private BigDecimal contractAmount;
    /** 合同金额的币种1:人名币、2:美元、3:欧元、4:俄币 */
    @ApiModelProperty(value = "合同金额的币种1:人名币、2:美元、3:欧元、4:俄币",required=true)
    private String currency;
    /** 合同文本的存储路径或内容 */
    @ApiModelProperty(value = "合同文本的存储路径或内容",required=false)
    private String contractText;
    /** 合同附件的存储路径或内容 */
    @ApiModelProperty(value = "合同附件的存储路径或内容",required=false)
    private String attachment;
    /** 合同甲方的名称 */
    @ApiModelProperty(value = "合同甲方的名称",required=true)
    private String partyAName;
    /** 合同甲方的地址 */
    @ApiModelProperty(value = "合同甲方的地址",required=false)
    private String partyAAddress;
    /** 合同甲方的联系人信息 */
    @ApiModelProperty(value = "合同甲方的联系人信息",required=false)
    private String partyAContactInfo;
    /** 合同乙方的名称 */
    @ApiModelProperty(value = "合同乙方的名称",required=true)
    private String partyBName;
    /** 合同乙方的地址 */
    @ApiModelProperty(value = "合同乙方的地址",required=false)
    private String partyBAddress;
    /** 合同乙方的联系人信息 */
    @ApiModelProperty(value = "合同乙方的联系人信息",required=false)
    private String partyBContactInfo;
    /** 合同履约的期限 */
    @ApiModelProperty(value = "合同履约的期限",required=false)
    private String fulfillmentTerm;
    /** 合同双方的履约责任 */
    @ApiModelProperty(value = "合同双方的履约责任",required=false)
    private String fulfillmentResponsibility;
    /** 合同的付款方式 */
    @ApiModelProperty(value = "合同的付款方式",required=false)
    private String paymentMethod;
    /** 合同的付款期限 */
    @ApiModelProperty(value = "合同的付款期限",required=false)
    private String paymentTerm;
    /** 合同的验收标准 */
    @ApiModelProperty(value = "合同的验收标准",required=false)
    private String acceptanceCriteria;
    /** 合同的违约责任 */
    @ApiModelProperty(value = "合同的违约责任",required=false)
    private String breachLiability;
    /** 合同的状态，1生效、2终止、3履行中、4争议、5:合同完成(生效和争议可以变更) */
    @ApiModelProperty(value = "合同的状态，1生效、2终止、3履行中、4争议、5:合同完成(生效和争议可以变更)",required=true)
    private String contractStatus;
    /** 负责合同管理的人员信息 */
    @ApiModelProperty(value = "负责合同管理的人员信息",required=false)
    private String contractManager;
    /** 合同评审的意见 */
    @ApiModelProperty(value = "合同评审的意见",required=false)
    private String reviewOpinion;
    /** 合同变更的记录 */
    @ApiModelProperty(value = "合同变更的记录",required=false)
    private String changeLog;
    /** 合同争议的记录 */
    @ApiModelProperty(value = "合同争议的记录",required=false)
    private String disputeRecord;
    /** 创建合同记录的人员信息 */
    @ApiModelProperty(value = "创建合同记录的人员信息",required=true)
    private String createdBy;
    /** 创建合同记录的时间 */
    @ApiModelProperty(value = "创建合同记录的时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /** 修改合同记录的人员信息 */
    @ApiModelProperty(value = "修改合同记录的人员信息",required=false)
    private String modifiedBy;
    /** 修改合同记录的时间 */
    @ApiModelProperty(value = "修改合同记录的时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;
    /** 物料编号 */
    @ApiModelProperty(value = "物料编号",required=false)
    private String materialNum;
    /** 物料名称 */
    @ApiModelProperty(value = "物料名称",required=false)
    private String materialName;
    /** 计量单位1:吨2:件3:包4:车 */
    @ApiModelProperty(value = "计量单位1:吨2:件3:包4:车",required=false)
    private String unitOfMeasurement;


}