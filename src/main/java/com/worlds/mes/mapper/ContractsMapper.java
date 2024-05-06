package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.Contracts;
import com.worlds.mes.vo.ContractsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ContractsMapper extends BaseMapper<Contracts>{

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Contracts> listAll();
    
     /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(ContractsVo contractsVo);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Contracts getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
	int insert(Contracts contracts);
	
	/**
     * 新增，忽略null字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Contracts contracts);
	
	/**
     * 修改，修改所有字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
	int update(Contracts contracts);
	
	/**
     * 修改，忽略null字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Contracts contracts);
	
}