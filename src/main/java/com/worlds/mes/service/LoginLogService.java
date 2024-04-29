package com.worlds.mes.service;

import com.worlds.mes.entity.LoginLog;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.LoginLogVo;
import java.util.List;
import java.util.HashMap;

public interface LoginLogService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<LoginLog> listAll();

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public Page<HashMap<String,Object>> listAllByParam(LoginLogVo loginLogVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public LoginLog getById(Integer id);

    /**
     * 新增，插入所有字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    public int insert(LoginLog loginLog);

    /**
     * 新增，忽略null字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(LoginLog loginLog);

    /**
     * 修改，修改所有字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    public int update(LoginLog loginLog);

    /**
     * 修改，忽略null字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(LoginLog loginLog);

    /**
     * 删除记录
     *
     * @param loginLog 待删除的记录
     * @return 返回影响行数
     */
    public int delete(LoginLog loginLog);

}