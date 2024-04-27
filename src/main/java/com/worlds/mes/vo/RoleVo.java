package com.worlds.mes.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.worlds.mes.commons.SimplePageInfo;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import java.util.Date;


/**
 * @program: mes角色表实体
 * @author: joeWorlds
 * @create: 2024-04-27 15:24:24
 * @return: 角色表
 **/
@ApiModel(value = "角色表",description = "角色表实体")
@Data
public class RoleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 角色表 */
    @ApiModelProperty(value = "角色表",required=true)
    private Integer id;
    /** 角色名称 */
    @ApiModelProperty(value = "角色名称",required=true)
    private String name;
    /** 创建人 */
    @ApiModelProperty(value = "创建人",required=true)
    private Integer createId;
    /** 创建人名称 */
    @ApiModelProperty(value = "创建人名称",required=true)
    private String createName;
    /** 创建时间 */
    @ApiModelProperty(value = "创建时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /** 是否启用，0否1是 */
    @ApiModelProperty(value = "是否启用，0否1是",required=true)
    private Byte enable;
    /** 数据范围，1全部、2本部门、3指定部门 */
    @ApiModelProperty(value = "数据范围，1全部、2本部门、3指定部门",required=true)
    private Integer scope;
    /** 数据范围中指定部门时的ID串 */
    @ApiModelProperty(value = "数据范围中指定部门时的ID串",required=false)
    private String departmentId;
    /** 角色具有的权限ID串 */
    @ApiModelProperty(value = "角色具有的权限ID串",required=false)
    private String resourceId;
    /** 分页信息 */
    @ApiModelProperty(value = "分页信息",required=false)
    private SimplePageInfo pageInfo;

    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("name",this.name);
        map.put("createId",this.createId);
        map.put("createName",this.createName);
        map.put("createTime",this.createTime);
        map.put("enable",this.enable);
        map.put("scope",this.scope);
        map.put("departmentId",this.departmentId);
        map.put("resourceId",this.resourceId);
        return map;
    }


}