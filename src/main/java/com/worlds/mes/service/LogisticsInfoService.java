package com.worlds.mes.service;

import com.worlds.mes.entity.LogisticsInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.LogisticsInfoVo;
import java.util.List;
import java.util.HashMap;

public interface LogisticsInfoService {

   /**
     * 查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<LogisticsInfo> listAll();
    
    /**
     * 根据条件分页查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(LogisticsInfoVo logisticsInfoVo);
    
   /**
     * 根据条件查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<LogisticsInfo> listAllByParamNoPage(LogisticsInfo logisticsInfo);

    /**
     * 根据主键查询物流信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public LogisticsInfo getById(Integer id);
	
    /**
     * 新增物流信息表，插入所有字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(LogisticsInfo logisticsInfo);
    
    /**
     * 新增物流信息表，忽略null字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(LogisticsInfo logisticsInfo);
	
    /**
     * 修改物流信息表，修改所有字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(LogisticsInfo logisticsInfo);
    
    /**
     * 修改物流信息表，忽略null字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(LogisticsInfo logisticsInfo);
    
    /**
     * 删除物流信息表记录
     *
     * @param logisticsInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(LogisticsInfo logisticsInfo);
    
}