package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.ProductInfo;
import com.worlds.mes.vo.ProductInfoVo;
import com.worlds.mes.service.ProductInfoService;
import com.worlds.mes.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements  ProductInfoService  {
	
    private static Log log = LogFactory.getLog(ProductInfoServiceImpl.class);


   @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<ProductInfo> listAll() {
    	return productInfoMapper.listAll();
    }
    /**
     * 查询产品信息表所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(ProductInfoVo productInfoVo) {
        SimplePageInfo pageInfo = productInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) productInfoMapper.listAllByParam(productInfoVo);
        return page;
    }
    /**
     * 查询产品信息表所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<ProductInfo> listAllByParamNoPage(ProductInfo productInfo) {
        QueryWrapper<ProductInfo> productInfoQueryWrapper = new QueryWrapper<>();
        productInfoQueryWrapper.setEntity(productInfo);
        return productInfoMapper.selectList(productInfoQueryWrapper);
    }


/**
     * 根据主键查询产品信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public ProductInfo getById(Integer id) {
    	return productInfoMapper.getById(id);
    }
	
    /**
     * 新增产品信息表，插入所有字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(ProductInfo productInfo) {
    	return productInfoMapper.insert(productInfo);
    }
	
    /**
     * 新增产品信息表，忽略null字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(ProductInfo productInfo) {
    	return productInfoMapper.insertIgnoreNull(productInfo);
    }
	
    /**
     * 修改产品信息表，修改所有字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(ProductInfo productInfo) {
    	return productInfoMapper.update(productInfo);
    }
	
    /**
     * 修改产品信息表，忽略null字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(ProductInfo productInfo) {
    	return productInfoMapper.updateIgnoreNull(productInfo);
    }
	
    /**
     * 删除产品信息表记录
     *
     * @param productInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(ProductInfo productInfo) {
    	return productInfoMapper.deleteById(productInfo.getId());
    }
	
}