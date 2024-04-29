package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.SysRole;
import com.worlds.mes.vo.SysRoleVo;
import com.worlds.mes.service.SysRoleService;
import com.worlds.mes.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class SysRoleServiceImpl implements  SysRoleService  {
	
    private static Log log = LogFactory.getLog(SysRoleServiceImpl.class);


   @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysRole> listAll() {
    	return sysRoleMapper.listAll();
    }
    
    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysRoleVo sysRoleVo) {
        SimplePageInfo pageInfo = sysRoleVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) sysRoleMapper.listAllByParam(sysRoleVo);
        return page;
    }

/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysRole getById(Integer id) {
    	return sysRoleMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysRole sysRole) {
    	return sysRoleMapper.insert(sysRole);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysRole sysRole) {
    	return sysRoleMapper.insertIgnoreNull(sysRole);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysRole sysRole) {
    	return sysRoleMapper.update(sysRole);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysRole sysRole) {
    	return sysRoleMapper.updateIgnoreNull(sysRole);
    }
	
    /**
     * 删除记录
     *
     * @param sysRole 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysRole sysRole) {
    	return sysRoleMapper.deleteById(sysRole.getId());
    }
	
}