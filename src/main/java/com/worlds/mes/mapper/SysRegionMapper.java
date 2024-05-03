package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.SysRegion;
import com.worlds.mes.vo.SysRegionVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface SysRegionMapper extends BaseMapper<SysRegion>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<SysRegion> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(SysRegionVo sysRegionVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	SysRegion getById(String id);
	
	/**
     * 新增，插入所有字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
	int insert(SysRegion sysRegion);
	
	/**
     * 新增，忽略null字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(SysRegion sysRegion);
	
	/**
     * 修改，修改所有字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
	int update(SysRegion sysRegion);
	
	/**
     * 修改，忽略null字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(SysRegion sysRegion);
	
}