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
 * @program: mes员工信息表实体
 * @author: joeWorlds
 * @create: 2024-05-08 14:49:14
 * @return: 员工信息表
 **/
@ApiModel(value = "员工信息表",description = "员工信息表实体")
@Data
public class EmployeeInfoVo implements Serializable {

private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
@TableId(value = "id",type = IdType.AUTO)
private Integer id;
/** 唯一标识每个员工记录的编码 */
@ApiModelProperty(value = "唯一标识每个员工记录的编码",required=true)
private String employeeId;
/** 员工姓名 */
@ApiModelProperty(value = "员工姓名",required=true)
private String name;
/** 员工性别1男2女 */
@ApiModelProperty(value = "员工性别1男2女",required=true)
private String gender;
/** 员工出生日期 */
@ApiModelProperty(value = "员工出生日期",required=true)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date birthDate;
/** 员工所在部门 */
@ApiModelProperty(value = "员工所在部门",required=true)
private String department;
/** 员工职位 */
@ApiModelProperty(value = "员工职位",required=true)
private String position;
/** 员工入职日期 */
@ApiModelProperty(value = "员工入职日期",required=true)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date entryDate;
/** 员工离职日期（如果适用） */
@ApiModelProperty(value = "员工离职日期（如果适用）",required=false)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date departureDate;
/** 员工雇佣状态 */
@ApiModelProperty(value = "员工雇佣状态",required=true)
private String employmentStatus;
/** 员工联系方式（例如，电话号码、电子邮件地址） */
@ApiModelProperty(value = "员工联系方式（例如，电话号码、电子邮件地址）",required=false)
private String contactInfo;
/** 员工紧急联系人信息 */
@ApiModelProperty(value = "员工紧急联系人信息",required=false)
private String emergencyContactInfo;
/** 员工照片（如果可用） */
@ApiModelProperty(value = "员工照片（如果可用）",required=false)
private Byte[] photo;
/** 员工教育背景 */
@ApiModelProperty(value = "员工教育背景",required=false)
private String educationLevel;
/** 员工专业证书编号 */
@ApiModelProperty(value = "员工专业证书编号",required=false)
private String graduationCertificateNumber;
/** 员工技能和专业知识 */
@ApiModelProperty(value = "员工技能和专业知识",required=false)
private String skills;
/** 员工工作经验 */
@ApiModelProperty(value = "员工工作经验",required=false)
private String workExperience;
/** 员工培训历史 */
@ApiModelProperty(value = "员工培训历史",required=false)
private String trainingHistory;
/** 关于员工的其他信息 */
@ApiModelProperty(value = "关于员工的其他信息",required=false)
private String remarks;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("employeeId",this.employeeId);
        map.put("name",this.name);
        map.put("gender",this.gender);
        map.put("birthDate",this.birthDate);
        map.put("department",this.department);
        map.put("position",this.position);
        map.put("entryDate",this.entryDate);
        map.put("departureDate",this.departureDate);
        map.put("employmentStatus",this.employmentStatus);
        map.put("contactInfo",this.contactInfo);
        map.put("emergencyContactInfo",this.emergencyContactInfo);
        map.put("photo",this.photo);
        map.put("educationLevel",this.educationLevel);
        map.put("graduationCertificateNumber",this.graduationCertificateNumber);
        map.put("skills",this.skills);
        map.put("workExperience",this.workExperience);
        map.put("trainingHistory",this.trainingHistory);
        map.put("remarks",this.remarks);
    	return map;
}

	
}