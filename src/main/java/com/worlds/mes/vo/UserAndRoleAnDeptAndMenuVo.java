package com.worlds.mes.vo;

import com.worlds.mes.entity.SysUser;
import lombok.Data;

@Data
public class UserAndRoleAnDeptAndMenuVo {
    // 用户信息
    private SysUser user;
    //
    private String roleId;
    private String deptId;
    private String resourceId;
}
