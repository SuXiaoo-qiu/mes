package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.ProductionInfo;
import com.worlds.mes.vo.ProductionInfoVo;
import com.worlds.mes.service.ProductionInfoService;
import com.worlds.mes.mapper.ProductionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductionInfoServiceImpl implements  ProductionInfoService  {
	
    private static Log log = LogFactory.getLog(ProductionInfoServiceImpl.class);


   @Autowired
    private ProductionInfoMapper productionInfoMapper;

    /**
     * 查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<ProductionInfo> listAll() {
    	return productionInfoMapper.listAll();
    }
    /**
     * 查询生产信息所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(ProductionInfoVo productionInfoVo) {
        SimplePageInfo pageInfo = productionInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) productionInfoMapper.listAllByParam(productionInfoVo);
        return page;
    }
    /**
     * 查询生产信息所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<ProductionInfo> listAllByParamNoPage(ProductionInfo productionInfo) {
        QueryWrapper<ProductionInfo> productionInfoQueryWrapper = new QueryWrapper<>();
        productionInfoQueryWrapper.setEntity(productionInfo);
        return productionInfoMapper.selectList(productionInfoQueryWrapper);
    }


/**
     * 根据主键查询生产信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public ProductionInfo getById(Integer id) {
    	return productionInfoMapper.getById(id);
    }
	
    /**
     * 新增生产信息，插入所有字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(ProductionInfo productionInfo) {
    	return productionInfoMapper.insert(productionInfo);
    }
	
    /**
     * 新增生产信息，忽略null字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(ProductionInfo productionInfo) {
    	return productionInfoMapper.insertIgnoreNull(productionInfo);
    }
	
    /**
     * 修改生产信息，修改所有字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(ProductionInfo productionInfo) {
    	return productionInfoMapper.update(productionInfo);
    }
	
    /**
     * 修改生产信息，忽略null字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(ProductionInfo productionInfo) {
    	return productionInfoMapper.updateIgnoreNull(productionInfo);
    }
	
    /**
     * 删除生产信息记录
     *
     * @param productionInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(ProductionInfo productionInfo) {
    	return productionInfoMapper.deleteById(productionInfo.getId());
    }
	
}