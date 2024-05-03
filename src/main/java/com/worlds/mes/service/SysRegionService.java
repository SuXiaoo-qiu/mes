package com.worlds.mes.service;

import com.github.pagehelper.Page;
import com.worlds.mes.entity.SysRegion;
import com.worlds.mes.vo.SysRegionVo;

import java.util.HashMap;
import java.util.List;

public interface SysRegionService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysRegion> listAll();
    
    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(SysRegionVo sysRegionVo);
    
   /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<SysRegion> listAllByParamNoPage(SysRegion sysRegion);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public SysRegion getById(String id);
	
    /**
     * 新增，插入所有字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
    public int insert(SysRegion sysRegion);
    
    /**
     * 新增，忽略null字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(SysRegion sysRegion);
	
    /**
     * 修改，修改所有字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
    public int update(SysRegion sysRegion);
    
    /**
     * 修改，忽略null字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(SysRegion sysRegion);
    
    /**
     * 删除记录
     *
     * @param sysRegion 待删除的记录
     * @return 返回影响行数
     */
    public int delete(SysRegion sysRegion);

}