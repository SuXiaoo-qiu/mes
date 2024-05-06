package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.WarehouseTable;
import com.worlds.mes.vo.WarehouseTableVo;
import com.worlds.mes.service.WarehouseTableService;
import com.worlds.mes.mapper.WarehouseTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class WarehouseTableServiceImpl implements  WarehouseTableService  {
	
    private static Log log = LogFactory.getLog(WarehouseTableServiceImpl.class);


   @Autowired
    private WarehouseTableMapper warehouseTableMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<WarehouseTable> listAll() {
    	return warehouseTableMapper.listAll();
    }
    /**
     * 查询所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(WarehouseTableVo warehouseTableVo) {
        SimplePageInfo pageInfo = warehouseTableVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) warehouseTableMapper.listAllByParam(warehouseTableVo);
        return page;
    }
    /**
     * 查询所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<WarehouseTable> listAllByParamNoPage(WarehouseTable warehouseTable) {
        QueryWrapper<WarehouseTable> warehouseTableQueryWrapper = new QueryWrapper<>();
        warehouseTableQueryWrapper.setEntity(warehouseTable);
        return warehouseTableMapper.selectList(warehouseTableQueryWrapper);
    }


/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public WarehouseTable getById(Integer id) {
    	return warehouseTableMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(WarehouseTable warehouseTable) {
    	return warehouseTableMapper.insert(warehouseTable);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(WarehouseTable warehouseTable) {
    	return warehouseTableMapper.insertIgnoreNull(warehouseTable);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(WarehouseTable warehouseTable) {
    	return warehouseTableMapper.update(warehouseTable);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(WarehouseTable warehouseTable) {
    	return warehouseTableMapper.updateIgnoreNull(warehouseTable);
    }
	
    /**
     * 删除记录
     *
     * @param warehouseTable 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(WarehouseTable warehouseTable) {
    	return warehouseTableMapper.deleteById(warehouseTable.getId());
    }
	
}