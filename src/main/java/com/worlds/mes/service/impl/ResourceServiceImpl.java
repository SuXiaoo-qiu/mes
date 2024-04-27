package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.Resource;
import com.worlds.mes.vo.ResourceVo;
import com.worlds.mes.service.ResourceService;
import com.worlds.mes.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class ResourceServiceImpl implements  ResourceService  {
	
    private static Log log = LogFactory.getLog(ResourceServiceImpl.class);


   @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<Resource> listAll() {
    	return resourceMapper.listAll();
    }
    
    @Override
    public Page<HashMap<String, Object>> listAllByParam(ResourceVo resourceVo) {
        SimplePageInfo pageInfo = resourceVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) resourceMapper.listAllByParam(resourceVo);
        return page;
    }

/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Resource getById(Integer id) {
    	return resourceMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param resource 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(Resource resource) {
    	return resourceMapper.insert(resource);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param resource 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(Resource resource) {
    	return resourceMapper.insertIgnoreNull(resource);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param resource 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(Resource resource) {
    	return resourceMapper.update(resource);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param resource 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(Resource resource) {
    	return resourceMapper.updateIgnoreNull(resource);
    }
	
    /**
     * 删除记录
     *
     * @param resource 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Resource resource) {
    	return resourceMapper.delete(resource);
    }
	
}