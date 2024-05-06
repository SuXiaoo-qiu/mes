package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.InventoryTable;
import com.worlds.mes.vo.InventoryTableVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface InventoryTableMapper extends BaseMapper<InventoryTable>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<InventoryTable> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(InventoryTableVo inventoryTableVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	InventoryTable getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
	int insert(InventoryTable inventoryTable);
	
	/**
     * 新增，忽略null字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(InventoryTable inventoryTable);
	
	/**
     * 修改，修改所有字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
	int update(InventoryTable inventoryTable);
	
	/**
     * 修改，忽略null字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(InventoryTable inventoryTable);
	
}