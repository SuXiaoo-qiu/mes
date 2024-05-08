package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.EmployeeInfo;
import com.worlds.mes.vo.EmployeeInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo>{

	/**
     * 查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<EmployeeInfo> listAll();
    
     /**
     * 根据条件查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(EmployeeInfoVo employeeInfoVo);

	/**
     * 根据主键查询员工信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	EmployeeInfo getById(Integer id);
	
	/**
     * 新增员工信息表，插入所有字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(EmployeeInfo employeeInfo);
	
	/**
     * 新增员工信息表，忽略null字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(EmployeeInfo employeeInfo);
	
	/**
     * 修改员工信息表，修改所有字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
	int update(EmployeeInfo employeeInfo);
	
	/**
     * 修改员工信息表，忽略null字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(EmployeeInfo employeeInfo);
	
}