package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.SysUserRole;
import com.worlds.mes.vo.SysUserRoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<SysUserRole> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(SysUserRoleVo sysUserRoleVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	SysUserRole getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param sysUserRole 新增的记录
     * @return 返回影响行数
     */
	int insert(SysUserRole sysUserRole);
	
	/**
     * 新增，忽略null字段
     *
     * @param sysUserRole 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(SysUserRole sysUserRole);
	
	/**
     * 修改，修改所有字段
     *
     * @param sysUserRole 修改的记录
     * @return 返回影响行数
     */
	int update(SysUserRole sysUserRole);
	
	/**
     * 修改，忽略null字段
     *
     * @param sysUserRole 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(SysUserRole sysUserRole);
	
}