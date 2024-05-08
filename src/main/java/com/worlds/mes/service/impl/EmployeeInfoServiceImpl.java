package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.EmployeeInfo;
import com.worlds.mes.vo.EmployeeInfoVo;
import com.worlds.mes.service.EmployeeInfoService;
import com.worlds.mes.mapper.EmployeeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeInfoServiceImpl implements  EmployeeInfoService  {
	
    private static Log log = LogFactory.getLog(EmployeeInfoServiceImpl.class);


   @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    /**
     * 查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<EmployeeInfo> listAll() {
    	return employeeInfoMapper.listAll();
    }
    /**
     * 查询员工信息表所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(EmployeeInfoVo employeeInfoVo) {
        SimplePageInfo pageInfo = employeeInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) employeeInfoMapper.listAllByParam(employeeInfoVo);
        return page;
    }
    /**
     * 查询员工信息表所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<EmployeeInfo> listAllByParamNoPage(EmployeeInfo employeeInfo) {
        QueryWrapper<EmployeeInfo> employeeInfoQueryWrapper = new QueryWrapper<>();
        employeeInfoQueryWrapper.setEntity(employeeInfo);
        return employeeInfoMapper.selectList(employeeInfoQueryWrapper);
    }


/**
     * 根据主键查询员工信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public EmployeeInfo getById(Integer id) {
    	return employeeInfoMapper.getById(id);
    }
	
    /**
     * 新增员工信息表，插入所有字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(EmployeeInfo employeeInfo) {
    	return employeeInfoMapper.insert(employeeInfo);
    }
	
    /**
     * 新增员工信息表，忽略null字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(EmployeeInfo employeeInfo) {
    	return employeeInfoMapper.insertIgnoreNull(employeeInfo);
    }
	
    /**
     * 修改员工信息表，修改所有字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(EmployeeInfo employeeInfo) {
    	return employeeInfoMapper.update(employeeInfo);
    }
	
    /**
     * 修改员工信息表，忽略null字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(EmployeeInfo employeeInfo) {
    	return employeeInfoMapper.updateIgnoreNull(employeeInfo);
    }
	
    /**
     * 删除员工信息表记录
     *
     * @param employeeInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(EmployeeInfo employeeInfo) {
    	return employeeInfoMapper.deleteById(employeeInfo.getId());
    }
	
}