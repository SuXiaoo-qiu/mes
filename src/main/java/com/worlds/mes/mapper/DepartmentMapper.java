package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.Department;
import com.worlds.mes.vo.DepartmentVo;

import java.util.HashMap;

@Mapper
public interface DepartmentMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Department> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(DepartmentVo departmentVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Department getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
	int insert(Department department);
	
	/**
     * 新增，忽略null字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Department department);
	
	/**
     * 修改，修改所有字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
	int update(Department department);
	
	/**
     * 修改，忽略null字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Department department);
	
	/**
     * 删除记录
     *
     * @param department 待删除的记录
     * @return 返回影响行数
     */
	int delete(Department department);
	
}