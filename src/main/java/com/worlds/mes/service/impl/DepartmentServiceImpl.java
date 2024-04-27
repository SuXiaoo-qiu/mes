package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.Department;
import com.worlds.mes.vo.DepartmentVo;
import com.worlds.mes.service.DepartmentService;
import com.worlds.mes.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService  {
	
    private static Log log = LogFactory.getLog(DepartmentServiceImpl.class);


   @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<Department> listAll() {
    	return departmentMapper.listAll();
    }
    
    @Override
    public Page<HashMap<String, Object>> listAllByParam(DepartmentVo departmentVo) {
        SimplePageInfo pageInfo = departmentVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) departmentMapper.listAllByParam(departmentVo);
        return page;
    }

/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Department getById(Integer id) {
    	return departmentMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(Department department) {
    	return departmentMapper.insert(department);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(Department department) {
    	return departmentMapper.insertIgnoreNull(department);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(Department department) {
    	return departmentMapper.update(department);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(Department department) {
    	return departmentMapper.updateIgnoreNull(department);
    }
	
    /**
     * 删除记录
     *
     * @param department 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Department department) {
    	return departmentMapper.delete(department);
    }
	
}