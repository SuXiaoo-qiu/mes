package com.worlds.mes.service;

import com.github.pagehelper.Page;
import com.worlds.mes.entity.User;
import com.worlds.mes.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<User> listAll();


    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<Map<String,Object>> listAllByParam(UserVo userVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public User getById(Integer id);

    /**
     * 新增，插入所有字段
     *
     * @param user 新增的记录
     * @return 返回影响行数
     */
    public int insert(User user);

    /**
     * 新增，忽略null字段
     *
     * @param user 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(User user);

    /**
     * 修改，修改所有字段
     *
     * @param user 修改的记录
     * @return 返回影响行数
     */
    public int update(User user);

    /**
     * 修改，忽略null字段
     *
     * @param user 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(User user);

    /**
     * 删除记录
     *
     * @param user 待删除的记录
     * @return 返回影响行数
     */
    public int delete(User user);

}