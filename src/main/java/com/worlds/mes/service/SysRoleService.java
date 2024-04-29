package com.worlds.mes.service;

import com.worlds.mes.entity.SysRole;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.SysRoleVo;
import java.util.List;
import java.util.HashMap;

public interface SysRoleService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysRole> listAll();
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(SysRoleVo sysRoleVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public SysRole getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
    public int insert(SysRole sysRole);
    
    /**
     * 新增，忽略null字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(SysRole sysRole);
	
    /**
     * 修改，修改所有字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
    public int update(SysRole sysRole);
    
    /**
     * 修改，忽略null字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(SysRole sysRole);
    
    /**
     * 删除记录
     *
     * @param sysRole 待删除的记录
     * @return 返回影响行数
     */
    public int delete(SysRole sysRole);
    
}