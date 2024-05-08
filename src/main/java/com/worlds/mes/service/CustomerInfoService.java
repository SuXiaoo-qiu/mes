package com.worlds.mes.service;

import com.worlds.mes.entity.CustomerInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.CustomerInfoVo;
import java.util.List;
import java.util.HashMap;

public interface CustomerInfoService {

   /**
     * 查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<CustomerInfo> listAll();
    
    /**
     * 根据条件分页查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(CustomerInfoVo customerInfoVo);
    
   /**
     * 根据条件查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<CustomerInfo> listAllByParamNoPage(CustomerInfo customerInfo);

    /**
     * 根据主键查询客户信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public CustomerInfo getById(Integer id);
	
    /**
     * 新增客户信息表，插入所有字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(CustomerInfo customerInfo);
    
    /**
     * 新增客户信息表，忽略null字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(CustomerInfo customerInfo);
	
    /**
     * 修改客户信息表，修改所有字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(CustomerInfo customerInfo);
    
    /**
     * 修改客户信息表，忽略null字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(CustomerInfo customerInfo);
    
    /**
     * 删除客户信息表记录
     *
     * @param customerInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(CustomerInfo customerInfo);
    
}