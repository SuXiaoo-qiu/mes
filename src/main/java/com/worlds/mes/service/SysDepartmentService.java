package com.worlds.mes.service;

import com.worlds.mes.entity.SysDepartment;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.SysDepartmentVo;
import java.util.List;
import java.util.HashMap;

public interface SysDepartmentService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<SysDepartment> listAll();
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(SysDepartmentVo sysDepartmentVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public SysDepartment getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
    public int insert(SysDepartment sysDepartment);
    
    /**
     * 新增，忽略null字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(SysDepartment sysDepartment);
	
    /**
     * 修改，修改所有字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
    public int update(SysDepartment sysDepartment);
    
    /**
     * 修改，忽略null字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(SysDepartment sysDepartment);
    
    /**
     * 删除记录
     *
     * @param sysDepartment 待删除的记录
     * @return 返回影响行数
     */
    public int delete(SysDepartment sysDepartment);
    
}