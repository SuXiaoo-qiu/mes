package com.worlds.mes.service.impl;

import com.worlds.mes.entity.User;
import com.worlds.mes.mapper.UserMapper;
import com.worlds.mes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService  {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param user 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 新增，忽略null字段
     *
     * @param user 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(User user) {
        return userMapper.insertIgnoreNull(user);
    }

    /**
     * 修改，修改所有字段
     *
     * @param user 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    /**
     * 修改，忽略null字段
     *
     * @param user 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(User user) {
        return userMapper.updateIgnoreNull(user);
    }

    /**
     * 删除记录
     *
     * @param user 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

}