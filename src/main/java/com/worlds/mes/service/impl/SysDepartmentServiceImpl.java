package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.SysDepartment;
import com.worlds.mes.vo.SysDepartmentVo;
import com.worlds.mes.service.SysDepartmentService;
import com.worlds.mes.mapper.SysDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class SysDepartmentServiceImpl implements  SysDepartmentService  {
	
    private static Log log = LogFactory.getLog(SysDepartmentServiceImpl.class);


   @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysDepartment> listAll() {
    	return sysDepartmentMapper.listAll();
    }
    
    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysDepartmentVo sysDepartmentVo) {
        SimplePageInfo pageInfo = sysDepartmentVo.getPageInfo();
        if (pageInfo == null) {
            pageInfo.setPageSize(10);
            pageInfo.setIsCount(true);
        }

        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());

        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) sysDepartmentMapper.listAllByParam(sysDepartmentVo);
        return page;
    }

/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysDepartment getById(Integer id) {
    	return sysDepartmentMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysDepartment sysDepartment) {
    	return sysDepartmentMapper.insert(sysDepartment);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysDepartment sysDepartment) {
    	return sysDepartmentMapper.insertIgnoreNull(sysDepartment);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysDepartment sysDepartment) {
    	return sysDepartmentMapper.update(sysDepartment);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysDepartment sysDepartment) {
    	return sysDepartmentMapper.updateIgnoreNull(sysDepartment);
    }
	
    /**
     * 删除记录
     *
     * @param sysDepartment 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysDepartment sysDepartment) {
    	return sysDepartmentMapper.deleteById(sysDepartment.getId());
    }
	
}