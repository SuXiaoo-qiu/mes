package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.Role;
import com.worlds.mes.vo.RoleVo;
import com.worlds.mes.service.RoleService;
import com.worlds.mes.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImpl implements  RoleService  {

    private static Log log = LogFactory.getLog(RoleServiceImpl.class);


    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<Role> listAll() {
        return roleMapper.listAll();
    }

    @Override
    public Page<HashMap<String, Object>> listAllByParam(RoleVo roleVo) {
        SimplePageInfo pageInfo = roleVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) roleMapper.listAllByParam(roleVo);
        return page;
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Role getById(Integer id) {
        return roleMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    /**
     * 新增，忽略null字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(Role role) {
        return roleMapper.insertIgnoreNull(role);
    }

    /**
     * 修改，修改所有字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    /**
     * 修改，忽略null字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(Role role) {
        return roleMapper.updateIgnoreNull(role);
    }

    /**
     * 删除记录
     *
     * @param role 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Role role) {
        return roleMapper.delete(role);
    }

}