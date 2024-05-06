package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.BillOfMaterials;
import com.worlds.mes.vo.BillOfMaterialsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface BillOfMaterialsMapper extends BaseMapper<BillOfMaterials>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<BillOfMaterials> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(BillOfMaterialsVo billOfMaterialsVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	BillOfMaterials getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
	int insert(BillOfMaterials billOfMaterials);
	
	/**
     * 新增，忽略null字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(BillOfMaterials billOfMaterials);
	
	/**
     * 修改，修改所有字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
	int update(BillOfMaterials billOfMaterials);
	
	/**
     * 修改，忽略null字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(BillOfMaterials billOfMaterials);
	
}