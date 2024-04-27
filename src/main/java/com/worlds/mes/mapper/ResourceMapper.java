package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.Resource;
import com.worlds.mes.vo.ResourceVo;

import java.util.HashMap;

@Mapper
public interface ResourceMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Resource> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(ResourceVo resourceVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Resource getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param resource 新增的记录
     * @return 返回影响行数
     */
	int insert(Resource resource);
	
	/**
     * 新增，忽略null字段
     *
     * @param resource 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Resource resource);
	
	/**
     * 修改，修改所有字段
     *
     * @param resource 修改的记录
     * @return 返回影响行数
     */
	int update(Resource resource);
	
	/**
     * 修改，忽略null字段
     *
     * @param resource 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Resource resource);
	
	/**
     * 删除记录
     *
     * @param resource 待删除的记录
     * @return 返回影响行数
     */
	int delete(Resource resource);
	
}