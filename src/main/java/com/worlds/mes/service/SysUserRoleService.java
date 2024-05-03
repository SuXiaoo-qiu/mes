package com.worlds.mes.service;

import com.worlds.mes.entity.SysUserRole;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.SysUserRoleVo;
import java.util.List;
import java.util.HashMap;

public interface SysUserRoleService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysUserRole> listAll();
    
    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(SysUserRoleVo sysUserRoleVo);
    
   /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<SysUserRole> listAllByParamNoPage(SysUserRole sysUserRole);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public SysUserRole getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param sysUserRole 新增的记录
     * @return 返回影响行数
     */
    public int insert(SysUserRole sysUserRole);
    
    /**
     * 新增，忽略null字段
     *
     * @param sysUserRole 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(SysUserRole sysUserRole);
	
    /**
     * 修改，修改所有字段
     *
     * @param sysUserRole 修改的记录
     * @return 返回影响行数
     */
    public int update(SysUserRole sysUserRole);
    
    /**
     * 修改，忽略null字段
     *
     * @param sysUserRole 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(SysUserRole sysUserRole);
    
    /**
     * 删除记录
     *
     * @param sysUserRole 待删除的记录
     * @return 返回影响行数
     */
    public int delete(SysUserRole sysUserRole);
    
}