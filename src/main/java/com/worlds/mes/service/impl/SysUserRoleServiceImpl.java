package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.SysUserRole;
import com.worlds.mes.vo.SysUserRoleVo;
import com.worlds.mes.service.SysUserRoleService;
import com.worlds.mes.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class SysUserRoleServiceImpl implements  SysUserRoleService  {
	
    private static Log log = LogFactory.getLog(SysUserRoleServiceImpl.class);


   @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysUserRole> listAll() {
    	return sysUserRoleMapper.listAll();
    }
    /**
     * 查询所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysUserRoleVo sysUserRoleVo) {
        SimplePageInfo pageInfo = sysUserRoleVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) sysUserRoleMapper.listAllByParam(sysUserRoleVo);
        return page;
    }
    /**
     * 查询所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysUserRole> listAllByParamNoPage(SysUserRole sysUserRole) {
        QueryWrapper<SysUserRole> sysUserRoleQueryWrapper = new QueryWrapper<>();
        sysUserRoleQueryWrapper.setEntity(sysUserRole);
        return sysUserRoleMapper.selectList(sysUserRoleQueryWrapper);
    }


/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysUserRole getById(Integer id) {
    	return sysUserRoleMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param sysUserRole 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysUserRole sysUserRole) {
    	return sysUserRoleMapper.insert(sysUserRole);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sysUserRole 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysUserRole sysUserRole) {
    	return sysUserRoleMapper.insertIgnoreNull(sysUserRole);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sysUserRole 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysUserRole sysUserRole) {
    	return sysUserRoleMapper.update(sysUserRole);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sysUserRole 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysUserRole sysUserRole) {
    	return sysUserRoleMapper.updateIgnoreNull(sysUserRole);
    }
	
    /**
     * 删除记录
     *
     * @param sysUserRole 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysUserRole sysUserRole) {
    	return sysUserRoleMapper.deleteById(sysUserRole.getId());
    }
	
}