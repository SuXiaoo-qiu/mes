package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.InspectionInfo;
import com.worlds.mes.vo.InspectionInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface InspectionInfoMapper extends BaseMapper<InspectionInfo>{

	/**
     * 查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<InspectionInfo> listAll();
    
     /**
     * 根据条件查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(InspectionInfoVo inspectionInfoVo);

	/**
     * 根据主键查询检验信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	InspectionInfo getById(Integer id);
	
	/**
     * 新增检验信息，插入所有字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(InspectionInfo inspectionInfo);
	
	/**
     * 新增检验信息，忽略null字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(InspectionInfo inspectionInfo);
	
	/**
     * 修改检验信息，修改所有字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
	int update(InspectionInfo inspectionInfo);
	
	/**
     * 修改检验信息，忽略null字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(InspectionInfo inspectionInfo);
	
}