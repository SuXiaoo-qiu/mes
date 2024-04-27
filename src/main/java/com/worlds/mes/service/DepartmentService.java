package com.worlds.mes.service;

import com.worlds.mes.entity.Department;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.DepartmentVo;
import java.util.List;
import java.util.HashMap;

public interface DepartmentService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Department> listAll();
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(DepartmentVo departmentVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public Department getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
    public int insert(Department department);
    
    /**
     * 新增，忽略null字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Department department);
	
    /**
     * 修改，修改所有字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
    public int update(Department department);
    
    /**
     * 修改，忽略null字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Department department);
    
    /**
     * 删除记录
     *
     * @param department 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Department department);
    
}