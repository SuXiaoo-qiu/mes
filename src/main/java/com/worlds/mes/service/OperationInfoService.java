package com.worlds.mes.service;

import com.worlds.mes.entity.OperationInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.OperationInfoVo;
import java.util.List;
import java.util.HashMap;

public interface OperationInfoService {

   /**
     * 查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<OperationInfo> listAll();
    
    /**
     * 根据条件分页查询工序信息所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(OperationInfoVo operationInfoVo);
    
   /**
     * 根据条件查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<OperationInfo> listAllByParamNoPage(OperationInfo operationInfo);

    /**
     * 根据主键查询工序信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public OperationInfo getById(Integer id);
	
    /**
     * 新增工序信息，插入所有字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(OperationInfo operationInfo);
    
    /**
     * 新增工序信息，忽略null字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(OperationInfo operationInfo);
	
    /**
     * 修改工序信息，修改所有字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(OperationInfo operationInfo);
    
    /**
     * 修改工序信息，忽略null字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(OperationInfo operationInfo);
    
    /**
     * 删除工序信息记录
     *
     * @param operationInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(OperationInfo operationInfo);
    
}