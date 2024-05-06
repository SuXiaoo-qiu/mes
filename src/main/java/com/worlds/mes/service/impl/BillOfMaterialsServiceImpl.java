package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.BillOfMaterials;
import com.worlds.mes.vo.BillOfMaterialsVo;
import com.worlds.mes.service.BillOfMaterialsService;
import com.worlds.mes.mapper.BillOfMaterialsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class BillOfMaterialsServiceImpl implements  BillOfMaterialsService  {
	
    private static Log log = LogFactory.getLog(BillOfMaterialsServiceImpl.class);


   @Autowired
    private BillOfMaterialsMapper billOfMaterialsMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<BillOfMaterials> listAll() {
    	return billOfMaterialsMapper.listAll();
    }
    /**
     * 查询所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(BillOfMaterialsVo billOfMaterialsVo) {
        SimplePageInfo pageInfo = billOfMaterialsVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) billOfMaterialsMapper.listAllByParam(billOfMaterialsVo);
        return page;
    }
    /**
     * 查询所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<BillOfMaterials> listAllByParamNoPage(BillOfMaterials billOfMaterials) {
        QueryWrapper<BillOfMaterials> billOfMaterialsQueryWrapper = new QueryWrapper<>();
        billOfMaterialsQueryWrapper.setEntity(billOfMaterials);
        return billOfMaterialsMapper.selectList(billOfMaterialsQueryWrapper);
    }


/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public BillOfMaterials getById(Integer id) {
    	return billOfMaterialsMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(BillOfMaterials billOfMaterials) {
    	return billOfMaterialsMapper.insert(billOfMaterials);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(BillOfMaterials billOfMaterials) {
    	return billOfMaterialsMapper.insertIgnoreNull(billOfMaterials);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(BillOfMaterials billOfMaterials) {
    	return billOfMaterialsMapper.update(billOfMaterials);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(BillOfMaterials billOfMaterials) {
    	return billOfMaterialsMapper.updateIgnoreNull(billOfMaterials);
    }
	
    /**
     * 删除记录
     *
     * @param billOfMaterials 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(BillOfMaterials billOfMaterials) {
    	return billOfMaterialsMapper.deleteById(billOfMaterials.getId());
    }
	
}