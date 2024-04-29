package com.worlds.mes.service;

import com.worlds.mes.entity.SysResource;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.SysResourceVo;
import java.util.List;
import java.util.HashMap;

public interface SysResourceService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysResource> listAll();
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(SysResourceVo sysResourceVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public SysResource getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
    public int insert(SysResource sysResource);
    
    /**
     * 新增，忽略null字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(SysResource sysResource);
	
    /**
     * 修改，修改所有字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
    public int update(SysResource sysResource);
    
    /**
     * 修改，忽略null字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(SysResource sysResource);
    
    /**
     * 删除记录
     *
     * @param sysResource 待删除的记录
     * @return 返回影响行数
     */
    public int delete(SysResource sysResource);
    
}