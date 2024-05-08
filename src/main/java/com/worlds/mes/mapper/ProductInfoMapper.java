package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.ProductInfo;
import com.worlds.mes.vo.ProductInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo>{

	/**
     * 查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<ProductInfo> listAll();
    
     /**
     * 根据条件查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(ProductInfoVo productInfoVo);

	/**
     * 根据主键查询产品信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	ProductInfo getById(Integer id);
	
	/**
     * 新增产品信息表，插入所有字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(ProductInfo productInfo);
	
	/**
     * 新增产品信息表，忽略null字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(ProductInfo productInfo);
	
	/**
     * 修改产品信息表，修改所有字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
	int update(ProductInfo productInfo);
	
	/**
     * 修改产品信息表，忽略null字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(ProductInfo productInfo);
	
}