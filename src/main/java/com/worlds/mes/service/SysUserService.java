package com.worlds.mes.service;

import com.github.pagehelper.Page;
import com.worlds.mes.dto.PermissionsMenuDto;
import com.worlds.mes.dto.ResultNoPageDto;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.vo.RoleAnDeptAndMenuVo;
import com.worlds.mes.vo.SysUserVo;

import java.util.HashMap;
import java.util.List;


public interface SysUserService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysUser> listAll();

    /**
     * 查询一条记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysUser> testPlus(SysUser user);
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(SysUserVo sysUserVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public SysUser getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    public int insert(SysUser sysUser);
    
    /**
     * 新增，忽略null字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(SysUser sysUser);
	
    /**
     * 修改，修改所有字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    public int update(SysUser sysUser);
    
    /**
     * 修改，忽略null字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(SysUser sysUser);
    
    /**
     * 删除记录
     *
     * @param sysUser 待删除的记录
     * @return 返回影响行数
     */
    public int delete(SysUser sysUser);

    /**
     * 根据用户名和用户id查询该用户的角色和菜单和部门
     * @param roleAnDeptAndMenuVo
     * @return
     */
    List<PermissionsMenuDto> getRoleAnDeptAndMenu(RoleAnDeptAndMenuVo roleAnDeptAndMenuVo);

    ResultNoPageDto insertUserAndRoleAnDeptAndMenu(SysUserVo sysUserVo);
}