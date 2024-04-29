package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.LoginLog;
import com.worlds.mes.vo.LoginLogVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog>{

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    List<LoginLog> listAll();

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    List<HashMap<String, Object>> listAllByParam(LoginLogVo loginLogVo);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    LoginLog getById(Integer id);



    /**
     * 新增，忽略null字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    int insertIgnoreNull(LoginLog loginLog);

    /**
     * 修改，修改所有字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    int update(LoginLog loginLog);

    /**
     * 修改，忽略null字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    int updateIgnoreNull(LoginLog loginLog);

}