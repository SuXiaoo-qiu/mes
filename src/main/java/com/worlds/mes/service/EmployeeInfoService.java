package com.worlds.mes.service;

import com.worlds.mes.entity.EmployeeInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.EmployeeInfoVo;
import java.util.List;
import java.util.HashMap;

public interface EmployeeInfoService {

   /**
     * 查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<EmployeeInfo> listAll();
    
    /**
     * 根据条件分页查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(EmployeeInfoVo employeeInfoVo);
    
   /**
     * 根据条件查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<EmployeeInfo> listAllByParamNoPage(EmployeeInfo employeeInfo);

    /**
     * 根据主键查询员工信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public EmployeeInfo getById(Integer id);
	
    /**
     * 新增员工信息表，插入所有字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(EmployeeInfo employeeInfo);
    
    /**
     * 新增员工信息表，忽略null字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(EmployeeInfo employeeInfo);
	
    /**
     * 修改员工信息表，修改所有字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(EmployeeInfo employeeInfo);
    
    /**
     * 修改员工信息表，忽略null字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(EmployeeInfo employeeInfo);
    
    /**
     * 删除员工信息表记录
     *
     * @param employeeInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(EmployeeInfo employeeInfo);
    
}