package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.OperationInfo;
import com.worlds.mes.vo.OperationInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface OperationInfoMapper extends BaseMapper<OperationInfo>{

	/**
     * 查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<OperationInfo> listAll();
    
     /**
     * 根据条件查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(OperationInfoVo operationInfoVo);

	/**
     * 根据主键查询工序信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	OperationInfo getById(Integer id);
	
	/**
     * 新增工序信息，插入所有字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(OperationInfo operationInfo);
	
	/**
     * 新增工序信息，忽略null字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(OperationInfo operationInfo);
	
	/**
     * 修改工序信息，修改所有字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
	int update(OperationInfo operationInfo);
	
	/**
     * 修改工序信息，忽略null字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(OperationInfo operationInfo);
	
}