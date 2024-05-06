package com.worlds.mes.service;

import com.worlds.mes.entity.BillOfMaterials;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.BillOfMaterialsVo;
import java.util.List;
import java.util.HashMap;

public interface BillOfMaterialsService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<BillOfMaterials> listAll();
    
    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(BillOfMaterialsVo billOfMaterialsVo);
    
   /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<BillOfMaterials> listAllByParamNoPage(BillOfMaterials billOfMaterials);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public BillOfMaterials getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
    public int insert(BillOfMaterials billOfMaterials);
    
    /**
     * 新增，忽略null字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(BillOfMaterials billOfMaterials);
	
    /**
     * 修改，修改所有字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
    public int update(BillOfMaterials billOfMaterials);
    
    /**
     * 修改，忽略null字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(BillOfMaterials billOfMaterials);
    
    /**
     * 删除记录
     *
     * @param billOfMaterials 待删除的记录
     * @return 返回影响行数
     */
    public int delete(BillOfMaterials billOfMaterials);
    
}