package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.InventoryTable;
import com.worlds.mes.vo.InventoryTableVo;
import com.worlds.mes.service.InventoryTableService;
import com.worlds.mes.mapper.InventoryTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class InventoryTableServiceImpl implements  InventoryTableService  {
	
    private static Log log = LogFactory.getLog(InventoryTableServiceImpl.class);


   @Autowired
    private InventoryTableMapper inventoryTableMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<InventoryTable> listAll() {
    	return inventoryTableMapper.listAll();
    }
    /**
     * 查询所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(InventoryTableVo inventoryTableVo) {
        SimplePageInfo pageInfo = inventoryTableVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) inventoryTableMapper.listAllByParam(inventoryTableVo);
        return page;
    }
    /**
     * 查询所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<InventoryTable> listAllByParamNoPage(InventoryTable inventoryTable) {
        QueryWrapper<InventoryTable> inventoryTableQueryWrapper = new QueryWrapper<>();
        inventoryTableQueryWrapper.setEntity(inventoryTable);
        return inventoryTableMapper.selectList(inventoryTableQueryWrapper);
    }


/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public InventoryTable getById(Integer id) {
    	return inventoryTableMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(InventoryTable inventoryTable) {
    	return inventoryTableMapper.insert(inventoryTable);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(InventoryTable inventoryTable) {
    	return inventoryTableMapper.insertIgnoreNull(inventoryTable);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(InventoryTable inventoryTable) {
    	return inventoryTableMapper.update(inventoryTable);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(InventoryTable inventoryTable) {
    	return inventoryTableMapper.updateIgnoreNull(inventoryTable);
    }
	
    /**
     * 删除记录
     *
     * @param inventoryTable 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(InventoryTable inventoryTable) {
    	return inventoryTableMapper.deleteById(inventoryTable.getId());
    }
	
}