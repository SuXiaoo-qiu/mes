package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.dto.LoginDto;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.vo.SysUserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper extends BaseMapper<SysUser> {

	/**
	 * 查询所有记录
	 *
	 * @return 返回集合，没有返回空List
	 */
	List<SysUser> listAll();

	/**
	 * 查询所有记录
	 *
	 * @return 返回集合，没有返回空List
	 */
	List<LoginDto> listAllByParam(SysUserVo userVo);


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
	 * @param user 新增的记录
	 * @return 返回影响行数
	 */
	@Override
	int insert(SysUser user);

	/**
	 * 新增，忽略null字段
	 *
	 * @param user 新增的记录
	 * @return 返回影响行数
	 */
	int insertIgnoreNull(SysUser user);

	/**
	 * 修改，修改所有字段
	 *
	 * @param user 修改的记录
	 * @return 返回影响行数
	 */
	int update(SysUser user);

	/**
	 * 修改，忽略null字段
	 *
	 * @param user 修改的记录
	 * @return 返回影响行数
	 */
	int updateIgnoreNull(SysUser user);


}