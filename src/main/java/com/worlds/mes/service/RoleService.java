package com.worlds.mes.service;

import com.worlds.mes.entity.Role;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.RoleVo;
import java.util.List;
import java.util.HashMap;

public interface RoleService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Role> listAll();

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(RoleVo roleVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public Role getById(Integer id);

    /**
     * 新增，插入所有字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    public int insert(Role role);

    /**
     * 新增，忽略null字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Role role);

    /**
     * 修改，修改所有字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    public int update(Role role);

    /**
     * 修改，忽略null字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Role role);

    /**
     * 删除记录
     *
     * @param role 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Role role);

}