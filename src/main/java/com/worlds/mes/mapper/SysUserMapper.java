package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.vo.SysUserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<SysUser> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(SysUserVo sysUserVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	SysUser getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
	int insert(SysUser sysUser);
	
	/**
     * 新增，忽略null字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(SysUser sysUser);
	
	/**
     * 修改，修改所有字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
	int update(SysUser sysUser);
	
	/**
     * 修改，忽略null字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(SysUser sysUser);
	
}