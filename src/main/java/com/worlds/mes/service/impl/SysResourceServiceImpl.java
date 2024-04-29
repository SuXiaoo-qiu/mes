package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.SysResource;
import com.worlds.mes.vo.SysResourceVo;
import com.worlds.mes.service.SysResourceService;
import com.worlds.mes.mapper.SysResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class SysResourceServiceImpl implements  SysResourceService  {
	
    private static Log log = LogFactory.getLog(SysResourceServiceImpl.class);


   @Autowired
    private SysResourceMapper sysResourceMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysResource> listAll() {
    	return sysResourceMapper.listAll();
    }
    
    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysResourceVo sysResourceVo) {
        SimplePageInfo pageInfo = sysResourceVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) sysResourceMapper.listAllByParam(sysResourceVo);
        return page;
    }

/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysResource getById(Integer id) {
    	return sysResourceMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysResource sysResource) {
    	return sysResourceMapper.insert(sysResource);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysResource sysResource) {
    	return sysResourceMapper.insertIgnoreNull(sysResource);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysResource sysResource) {
    	return sysResourceMapper.update(sysResource);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysResource sysResource) {
    	return sysResourceMapper.updateIgnoreNull(sysResource);
    }
	
    /**
     * 删除记录
     *
     * @param sysResource 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysResource sysResource) {
    	return sysResourceMapper.deleteById(sysResource.getId());
    }
	
}