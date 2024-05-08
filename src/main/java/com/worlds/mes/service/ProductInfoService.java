package com.worlds.mes.service;

import com.worlds.mes.entity.ProductInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.ProductInfoVo;
import java.util.List;
import java.util.HashMap;

public interface ProductInfoService {

   /**
     * 查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<ProductInfo> listAll();
    
    /**
     * 根据条件分页查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(ProductInfoVo productInfoVo);
    
   /**
     * 根据条件查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<ProductInfo> listAllByParamNoPage(ProductInfo productInfo);

    /**
     * 根据主键查询产品信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public ProductInfo getById(Integer id);
	
    /**
     * 新增产品信息表，插入所有字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(ProductInfo productInfo);
    
    /**
     * 新增产品信息表，忽略null字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(ProductInfo productInfo);
	
    /**
     * 修改产品信息表，修改所有字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(ProductInfo productInfo);
    
    /**
     * 修改产品信息表，忽略null字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(ProductInfo productInfo);
    
    /**
     * 删除产品信息表记录
     *
     * @param productInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(ProductInfo productInfo);
    
}