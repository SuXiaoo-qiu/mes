package com.worlds.mes.service;

import com.worlds.mes.entity.ProcessInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.ProcessInfoVo;
import java.util.List;
import java.util.HashMap;

public interface ProcessInfoService {

   /**
     * 查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<ProcessInfo> listAll();
    
    /**
     * 根据条件分页查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(ProcessInfoVo processInfoVo);
    
   /**
     * 根据条件查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<ProcessInfo> listAllByParamNoPage(ProcessInfo processInfo);

    /**
     * 根据主键查询工艺信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public ProcessInfo getById(Integer id);
	
    /**
     * 新增工艺信息，插入所有字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(ProcessInfo processInfo);
    
    /**
     * 新增工艺信息，忽略null字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(ProcessInfo processInfo);
	
    /**
     * 修改工艺信息，修改所有字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(ProcessInfo processInfo);
    
    /**
     * 修改工艺信息，忽略null字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(ProcessInfo processInfo);
    
    /**
     * 删除工艺信息记录
     *
     * @param processInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(ProcessInfo processInfo);
    
}