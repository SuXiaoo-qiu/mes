package com.worlds.mes.service;

import com.worlds.mes.entity.InventoryTable;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.InventoryTableVo;
import java.util.List;
import java.util.HashMap;

public interface InventoryTableService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<InventoryTable> listAll();
    
    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(InventoryTableVo inventoryTableVo);
    
   /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<InventoryTable> listAllByParamNoPage(InventoryTable inventoryTable);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public InventoryTable getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
    public int insert(InventoryTable inventoryTable);
    
    /**
     * 新增，忽略null字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(InventoryTable inventoryTable);
	
    /**
     * 修改，修改所有字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
    public int update(InventoryTable inventoryTable);
    
    /**
     * 修改，忽略null字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(InventoryTable inventoryTable);
    
    /**
     * 删除记录
     *
     * @param inventoryTable 待删除的记录
     * @return 返回影响行数
     */
    public int delete(InventoryTable inventoryTable);
    
}