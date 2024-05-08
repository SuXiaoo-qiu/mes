package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.ProductionInfo;
import com.worlds.mes.vo.ProductionInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface ProductionInfoMapper extends BaseMapper<ProductionInfo>{

	/**
     * 查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<ProductionInfo> listAll();
    
     /**
     * 根据条件查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(ProductionInfoVo productionInfoVo);

	/**
     * 根据主键查询生产信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	ProductionInfo getById(Integer id);
	
	/**
     * 新增生产信息，插入所有字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(ProductionInfo productionInfo);
	
	/**
     * 新增生产信息，忽略null字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(ProductionInfo productionInfo);
	
	/**
     * 修改生产信息，修改所有字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
	int update(ProductionInfo productionInfo);
	
	/**
     * 修改生产信息，忽略null字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(ProductionInfo productionInfo);
	
}