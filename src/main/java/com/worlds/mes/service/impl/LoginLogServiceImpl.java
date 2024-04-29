package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.LoginLog;
import com.worlds.mes.vo.LoginLogVo;
import com.worlds.mes.service.LoginLogService;
import com.worlds.mes.mapper.LoginLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginLogServiceImpl implements  LoginLogService  {

    private static Log log = LogFactory.getLog(LoginLogServiceImpl.class);


    @Autowired
    private LoginLogMapper loginLogMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<LoginLog> listAll() {
        return loginLogMapper.listAll();
    }

    @Override
    public Page<HashMap<String, Object>> listAllByParam(LoginLogVo loginLogVo) {
        SimplePageInfo pageInfo = loginLogVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) loginLogMapper.listAllByParam(loginLogVo);
        return page;
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public LoginLog getById(Integer id) {
        return loginLogMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(LoginLog loginLog) {
        return loginLogMapper.insert(loginLog);
    }

    /**
     * 新增，忽略null字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(LoginLog loginLog) {
        return loginLogMapper.insertIgnoreNull(loginLog);
    }

    /**
     * 修改，修改所有字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(LoginLog loginLog) {
        return loginLogMapper.update(loginLog);
    }

    /**
     * 修改，忽略null字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(LoginLog loginLog) {
        return loginLogMapper.updateIgnoreNull(loginLog);
    }

    /**
     * 删除记录
     *
     * @param loginLog 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(LoginLog loginLog) {
        return loginLogMapper.deleteById(loginLog.getId());
    }

}