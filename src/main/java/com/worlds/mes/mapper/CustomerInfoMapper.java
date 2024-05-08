package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.CustomerInfo;
import com.worlds.mes.vo.CustomerInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo>{

	/**
     * 查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<CustomerInfo> listAll();
    
     /**
     * 根据条件查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(CustomerInfoVo customerInfoVo);

	/**
     * 根据主键查询客户信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	CustomerInfo getById(Integer id);
	
	/**
     * 新增客户信息表，插入所有字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(CustomerInfo customerInfo);
	
	/**
     * 新增客户信息表，忽略null字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(CustomerInfo customerInfo);
	
	/**
     * 修改客户信息表，修改所有字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
	int update(CustomerInfo customerInfo);
	
	/**
     * 修改客户信息表，忽略null字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(CustomerInfo customerInfo);
	
}