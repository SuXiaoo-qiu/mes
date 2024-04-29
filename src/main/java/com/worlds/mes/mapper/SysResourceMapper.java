package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.SysResource;
import com.worlds.mes.vo.SysResourceVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SysResourceMapper extends BaseMapper<SysResource>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<SysResource> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(SysResourceVo sysResourceVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	SysResource getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
	int insert(SysResource sysResource);
	
	/**
     * 新增，忽略null字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(SysResource sysResource);
	
	/**
     * 修改，修改所有字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
	int update(SysResource sysResource);
	
	/**
     * 修改，忽略null字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(SysResource sysResource);
	
}