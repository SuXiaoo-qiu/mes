package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.WarehouseTable;
import com.worlds.mes.vo.WarehouseTableVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface WarehouseTableMapper extends BaseMapper<WarehouseTable>{

	/**
	 * 查询仓库表所有记录
	 *
	 * @return 返回集合，没有返回空List
	 */
	List<WarehouseTable> listAll();

	/**
	 * 根据条件查询仓库表所有记录
	 *
	 * @return 返回集合，没有返回空List
	 */
	List<HashMap<String, Object>> listAllByParam(WarehouseTableVo warehouseTableVo);

	/**
	 * 根据主键查询仓库表
	 *
	 * @param id 主键
	 * @return 返回记录，没有返回null
	 */
	WarehouseTable getById(Integer id);

	/**
	 * 新增仓库表，插入所有字段
	 *
	 * @param warehouseTable 新增的记录
	 * @return 返回影响行数
	 */
	int insert(WarehouseTable warehouseTable);

	/**
	 * 新增仓库表，忽略null字段
	 *
	 * @param warehouseTable 新增的记录
	 * @return 返回影响行数
	 */
	int insertIgnoreNull(WarehouseTable warehouseTable);

	/**
	 * 修改仓库表，修改所有字段
	 *
	 * @param warehouseTable 修改的记录
	 * @return 返回影响行数
	 */
	int update(WarehouseTable warehouseTable);

	/**
	 * 修改仓库表，忽略null字段
	 *
	 * @param warehouseTable 修改的记录
	 * @return 返回影响行数
	 */
	int updateIgnoreNull(WarehouseTable warehouseTable);

	/**
	 * 批量新增仓库表，忽略null字段
	 *
	 * @param warehouseTable 修改的记录
	 * @return 返回影响行数
	 */
	int isnetBatch(List<WarehouseTable> warehouseTable);

}