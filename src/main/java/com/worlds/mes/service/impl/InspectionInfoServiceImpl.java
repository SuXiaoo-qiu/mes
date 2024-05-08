package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.InspectionInfo;
import com.worlds.mes.vo.InspectionInfoVo;
import com.worlds.mes.service.InspectionInfoService;
import com.worlds.mes.mapper.InspectionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class InspectionInfoServiceImpl implements  InspectionInfoService  {
	
    private static Log log = LogFactory.getLog(InspectionInfoServiceImpl.class);


   @Autowired
    private InspectionInfoMapper inspectionInfoMapper;

    /**
     * 查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<InspectionInfo> listAll() {
    	return inspectionInfoMapper.listAll();
    }
    /**
     * 查询检验信息所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(InspectionInfoVo inspectionInfoVo) {
        SimplePageInfo pageInfo = inspectionInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) inspectionInfoMapper.listAllByParam(inspectionInfoVo);
        return page;
    }
    /**
     * 查询检验信息所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<InspectionInfo> listAllByParamNoPage(InspectionInfo inspectionInfo) {
        QueryWrapper<InspectionInfo> inspectionInfoQueryWrapper = new QueryWrapper<>();
        inspectionInfoQueryWrapper.setEntity(inspectionInfo);
        return inspectionInfoMapper.selectList(inspectionInfoQueryWrapper);
    }


/**
     * 根据主键查询检验信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public InspectionInfo getById(Integer id) {
    	return inspectionInfoMapper.getById(id);
    }
	
    /**
     * 新增检验信息，插入所有字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(InspectionInfo inspectionInfo) {
    	return inspectionInfoMapper.insert(inspectionInfo);
    }
	
    /**
     * 新增检验信息，忽略null字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(InspectionInfo inspectionInfo) {
    	return inspectionInfoMapper.insertIgnoreNull(inspectionInfo);
    }
	
    /**
     * 修改检验信息，修改所有字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(InspectionInfo inspectionInfo) {
    	return inspectionInfoMapper.update(inspectionInfo);
    }
	
    /**
     * 修改检验信息，忽略null字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(InspectionInfo inspectionInfo) {
    	return inspectionInfoMapper.updateIgnoreNull(inspectionInfo);
    }
	
    /**
     * 删除检验信息记录
     *
     * @param inspectionInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(InspectionInfo inspectionInfo) {
    	return inspectionInfoMapper.deleteById(inspectionInfo.getId());
    }
	
}