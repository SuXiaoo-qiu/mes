package com.worlds.mes.mapper;

import com.worlds.mes.entity.Role;
import com.worlds.mes.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    List<Role> listAll();

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    List<HashMap<String, Object>> listAllByParam(RoleVo roleVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    Role getById(Integer id);

    /**
     * 新增，插入所有字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    int insert(Role role);

    /**
     * 新增，忽略null字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    int insertIgnoreNull(Role role);

    /**
     * 修改，修改所有字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    int update(Role role);

    /**
     * 修改，忽略null字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    int updateIgnoreNull(Role role);

    /**
     * 删除记录
     *
     * @param role 待删除的记录
     * @return 返回影响行数
     */
    int delete(Role role);

}