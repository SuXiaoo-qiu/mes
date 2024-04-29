package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.worlds.mes.entity.User;
import com.worlds.mes.mapper.UserMapper;
import com.worlds.mes.service.UserService;
import com.worlds.mes.vo.UserVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService  {

    private static Log log = LogFactory.getLog(UserServiceImpl.class);


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

    @Override
    public List<User> testPlus(User user) {
//        List<User> users = userMapper.selectList(null);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("login_name",user.getLoginName());
        userQueryWrapper.eq("pwd",user.getPwd());
        User user1 = userMapper.selectOne(userQueryWrapper);
        System.out.println(user1);
        List<User> users = new ArrayList<>();
        users.add(user1);
        List<User> userLambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(userMapper)
                .like(User::getLoginName,user.getLoginName())
                .eq(User::getLoginName,user.getLoginName()).list();
        System.out.println(userLambdaQueryChainWrapper);
        return users;
    }

    @Override
    public Page<HashMap<String, Object>> listAllByParam(UserVo userVo) {
        SimplePageInfo pageInfo = userVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>)  userMapper.listAllByParam(userVo);
        return page;
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