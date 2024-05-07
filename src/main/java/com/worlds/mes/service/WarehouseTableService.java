package com.worlds.mes.service;

import com.github.pagehelper.Page;
import com.worlds.mes.entity.WarehouseTable;
import com.worlds.mes.vo.WarehouseTableVo;

import java.util.HashMap;
import java.util.List;

public interface WarehouseTableService{

    /**
     * 查询仓库表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<WarehouseTable> listAll();

    /**
     * 根据条件分页查询仓库表所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(WarehouseTableVo warehouseTableVo);

    /**
     * 根据条件查询仓库表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    List<WarehouseTable> listAllByParamNoPage(WarehouseTable warehouseTable);

    /**
     * 根据主键查询仓库表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public WarehouseTable getById(Integer id);

    /**
     * 新增仓库表，插入所有字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    public int insert(WarehouseTable warehouseTable);

    /**
     * 新增仓库表，忽略null字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(WarehouseTable warehouseTable);

    /**
     * 修改仓库表，修改所有字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    public int update(WarehouseTable warehouseTable);

    /**
     * 修改仓库表，忽略null字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(WarehouseTable warehouseTable);

    /**
     * 删除仓库表记录
     *
     * @param warehouseTable 待删除的记录
     * @return 返回影响行数
     */
    public int delete(WarehouseTable warehouseTable);

    String isnetBatch();

}