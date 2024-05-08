package com.worlds.mes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.worlds.mes.entity.ProcessInfo;
import com.worlds.mes.vo.ProcessInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;

@Mapper
public interface ProcessInfoMapper extends BaseMapper<ProcessInfo>{

	/**
     * 查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<ProcessInfo> listAll();
    
     /**
     * 根据条件查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(ProcessInfoVo processInfoVo);

	/**
     * 根据主键查询工艺信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	ProcessInfo getById(Integer id);
	
	/**
     * 新增工艺信息，插入所有字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(ProcessInfo processInfo);
	
	/**
     * 新增工艺信息，忽略null字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(ProcessInfo processInfo);
	
	/**
     * 修改工艺信息，修改所有字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
	int update(ProcessInfo processInfo);
	
	/**
     * 修改工艺信息，忽略null字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(ProcessInfo processInfo);
	
}