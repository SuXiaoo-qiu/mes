package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.SysDepartment;
import com.worlds.mes.vo.SysDepartmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface SysDepartmentMapper extends BaseMapper<SysDepartment>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<SysDepartment> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(SysDepartmentVo sysDepartmentVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	SysDepartment getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
	int insert(SysDepartment sysDepartment);
	
	/**
     * 新增，忽略null字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(SysDepartment sysDepartment);
	
	/**
     * 修改，修改所有字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
	int update(SysDepartment sysDepartment);
	
	/**
     * 修改，忽略null字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(SysDepartment sysDepartment);
	
}