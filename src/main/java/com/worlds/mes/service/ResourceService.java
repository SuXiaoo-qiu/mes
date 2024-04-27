package com.worlds.mes.service;

import com.worlds.mes.entity.Resource;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.ResourceVo;
import java.util.List;
import java.util.HashMap;

public interface ResourceService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Resource> listAll();
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(ResourceVo resourceVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public Resource getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param resource 新增的记录
     * @return 返回影响行数
     */
    public int insert(Resource resource);
    
    /**
     * 新增，忽略null字段
     *
     * @param resource 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Resource resource);
	
    /**
     * 修改，修改所有字段
     *
     * @param resource 修改的记录
     * @return 返回影响行数
     */
    public int update(Resource resource);
    
    /**
     * 修改，忽略null字段
     *
     * @param resource 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Resource resource);
    
    /**
     * 删除记录
     *
     * @param resource 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Resource resource);
    
}