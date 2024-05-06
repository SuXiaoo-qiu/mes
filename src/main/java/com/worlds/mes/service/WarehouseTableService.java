package com.worlds.mes.service;

import com.worlds.mes.entity.WarehouseTable;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.WarehouseTableVo;
import java.util.List;
import java.util.HashMap;

public interface WarehouseTableService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<WarehouseTable> listAll();
    
    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(WarehouseTableVo warehouseTableVo);
    
   /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<WarehouseTable> listAllByParamNoPage(WarehouseTable warehouseTable);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public WarehouseTable getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    public int insert(WarehouseTable warehouseTable);
    
    /**
     * 新增，忽略null字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(WarehouseTable warehouseTable);
	
    /**
     * 修改，修改所有字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    public int update(WarehouseTable warehouseTable);
    
    /**
     * 修改，忽略null字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(WarehouseTable warehouseTable);
    
    /**
     * 删除记录
     *
     * @param warehouseTable 待删除的记录
     * @return 返回影响行数
     */
    public int delete(WarehouseTable warehouseTable);
    
}