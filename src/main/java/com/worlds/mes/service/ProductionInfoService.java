package com.worlds.mes.service;

import com.worlds.mes.entity.ProductionInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.ProductionInfoVo;
import java.util.List;
import java.util.HashMap;

public interface ProductionInfoService {

   /**
     * 查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<ProductionInfo> listAll();
    
    /**
     * 根据条件分页查询生产信息所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(ProductionInfoVo productionInfoVo);
    
   /**
     * 根据条件查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<ProductionInfo> listAllByParamNoPage(ProductionInfo productionInfo);

    /**
     * 根据主键查询生产信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public ProductionInfo getById(Integer id);
	
    /**
     * 新增生产信息，插入所有字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(ProductionInfo productionInfo);
    
    /**
     * 新增生产信息，忽略null字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(ProductionInfo productionInfo);
	
    /**
     * 修改生产信息，修改所有字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(ProductionInfo productionInfo);
    
    /**
     * 修改生产信息，忽略null字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(ProductionInfo productionInfo);
    
    /**
     * 删除生产信息记录
     *
     * @param productionInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(ProductionInfo productionInfo);
    
}