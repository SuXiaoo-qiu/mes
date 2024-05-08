package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.LogisticsInfo;
import com.worlds.mes.vo.LogisticsInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface LogisticsInfoMapper extends BaseMapper<LogisticsInfo>{

	/**
     * 查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<LogisticsInfo> listAll();
    
     /**
     * 根据条件查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(LogisticsInfoVo logisticsInfoVo);

	/**
     * 根据主键查询物流信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	LogisticsInfo getById(Integer id);
	
	/**
     * 新增物流信息表，插入所有字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(LogisticsInfo logisticsInfo);
	
	/**
     * 新增物流信息表，忽略null字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(LogisticsInfo logisticsInfo);
	
	/**
     * 修改物流信息表，修改所有字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
	int update(LogisticsInfo logisticsInfo);
	
	/**
     * 修改物流信息表，忽略null字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(LogisticsInfo logisticsInfo);
	
}