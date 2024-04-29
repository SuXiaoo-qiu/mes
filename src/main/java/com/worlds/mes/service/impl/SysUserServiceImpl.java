package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.mapper.SysUserMapper;
import com.worlds.mes.service.SysUserService;
import com.worlds.mes.vo.SysUserVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SysUserServiceImpl implements  SysUserService  {
	
    private static Log log = LogFactory.getLog(SysUserServiceImpl.class);


   @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysUser> listAll() {
    	return sysUserMapper.listAll();
    }

    @Override
    public List<SysUser> testPlus(SysUser user) {
//        List<User> users = userMapper.selectList(null);
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name",user.getLoginName());
        userQueryWrapper.eq("pwd",user.getPwd());
        SysUser user1 = sysUserMapper.selectOne(userQueryWrapper);
        System.out.println(user1);
        List<SysUser> users = new ArrayList<>();
        users.add(user1);
        List<SysUser> userLambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(sysUserMapper)
                .like(SysUser::getLoginName,user.getLoginName())
                .eq(SysUser::getLoginName,user.getLoginName()).list();
        System.out.println(userLambdaQueryChainWrapper);
        return users;
    }

    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysUserVo sysUserVo) {
        SimplePageInfo pageInfo = sysUserVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) sysUserMapper.listAllByParam(sysUserVo);
        return page;
    }

/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysUser getById(Integer id) {
    	return sysUserMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysUser sysUser) {
    	return sysUserMapper.insert(sysUser);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysUser sysUser) {
    	return sysUserMapper.insertIgnoreNull(sysUser);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysUser sysUser) {
    	return sysUserMapper.update(sysUser);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysUser sysUser) {
    	return sysUserMapper.updateIgnoreNull(sysUser);
    }
	
    /**
     * 删除记录
     *
     * @param sysUser 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysUser sysUser) {
    	return sysUserMapper.deleteById(sysUser.getId());
    }
	
}