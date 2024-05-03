package com.worlds.mes.vo;
import com.worlds.mes.commons.SimplePageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;




/**
 * @program: mes用户角色表实体
 * @author: joeWorlds
 * @create: 2024-04-30 17:01:56
 * @return: 用户角色表
 **/
@ApiModel(value = "用户角色表",description = "用户角色表实体")
@Data
public class SysUserRoleVo implements Serializable {

private static final long serialVersionUID = 1L;

/** id */
@ApiModelProperty(value = "id",required=true)
private Integer id;
/** 用户id */
@ApiModelProperty(value = "用户id",required=false)
private Integer userId;
/** 角色id */
@ApiModelProperty(value = "角色id",required=false)
private Integer roleId;
/** 分页信息 */
@ApiModelProperty(value = "分页信息",required=false)
private SimplePageInfo pageInfo;

public Map<String, Object> toMap() {
	Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("userId",this.userId);
        map.put("roleId",this.roleId);
    	return map;
}

	
}