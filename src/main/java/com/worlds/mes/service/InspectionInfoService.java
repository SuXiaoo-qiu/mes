package com.worlds.mes.service;

import com.worlds.mes.entity.InspectionInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.InspectionInfoVo;
import java.util.List;
import java.util.HashMap;

public interface InspectionInfoService {

   /**
     * 查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<InspectionInfo> listAll();
    
    /**
     * 根据条件分页查询检验信息所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(InspectionInfoVo inspectionInfoVo);
    
   /**
     * 根据条件查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<InspectionInfo> listAllByParamNoPage(InspectionInfo inspectionInfo);

    /**
     * 根据主键查询检验信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public InspectionInfo getById(Integer id);
	
    /**
     * 新增检验信息，插入所有字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(InspectionInfo inspectionInfo);
    
    /**
     * 新增检验信息，忽略null字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(InspectionInfo inspectionInfo);
	
    /**
     * 修改检验信息，修改所有字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(InspectionInfo inspectionInfo);
    
    /**
     * 修改检验信息，忽略null字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(InspectionInfo inspectionInfo);
    
    /**
     * 删除检验信息记录
     *
     * @param inspectionInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(InspectionInfo inspectionInfo);
    
}