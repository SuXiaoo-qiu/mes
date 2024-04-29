package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.SysRole;
import com.worlds.mes.vo.SysRoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<SysRole> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(SysRoleVo sysRoleVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	SysRole getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
	int insert(SysRole sysRole);
	
	/**
     * 新增，忽略null字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(SysRole sysRole);
	
	/**
     * 修改，修改所有字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
	int update(SysRole sysRole);
	
	/**
     * 修改，忽略null字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(SysRole sysRole);
	
}