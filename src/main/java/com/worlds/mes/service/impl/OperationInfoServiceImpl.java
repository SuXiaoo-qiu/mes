package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.OperationInfo;
import com.worlds.mes.vo.OperationInfoVo;
import com.worlds.mes.service.OperationInfoService;
import com.worlds.mes.mapper.OperationInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class OperationInfoServiceImpl implements  OperationInfoService  {
	
    private static Log log = LogFactory.getLog(OperationInfoServiceImpl.class);


   @Autowired
    private OperationInfoMapper operationInfoMapper;

    /**
     * 查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<OperationInfo> listAll() {
    	return operationInfoMapper.listAll();
    }
    /**
     * 查询工序信息所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(OperationInfoVo operationInfoVo) {
        SimplePageInfo pageInfo = operationInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) operationInfoMapper.listAllByParam(operationInfoVo);
        return page;
    }
    /**
     * 查询工序信息所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<OperationInfo> listAllByParamNoPage(OperationInfo operationInfo) {
        QueryWrapper<OperationInfo> operationInfoQueryWrapper = new QueryWrapper<>();
        operationInfoQueryWrapper.setEntity(operationInfo);
        return operationInfoMapper.selectList(operationInfoQueryWrapper);
    }


/**
     * 根据主键查询工序信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public OperationInfo getById(Integer id) {
    	return operationInfoMapper.getById(id);
    }
	
    /**
     * 新增工序信息，插入所有字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(OperationInfo operationInfo) {
    	return operationInfoMapper.insert(operationInfo);
    }
	
    /**
     * 新增工序信息，忽略null字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(OperationInfo operationInfo) {
    	return operationInfoMapper.insertIgnoreNull(operationInfo);
    }
	
    /**
     * 修改工序信息，修改所有字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(OperationInfo operationInfo) {
    	return operationInfoMapper.update(operationInfo);
    }
	
    /**
     * 修改工序信息，忽略null字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(OperationInfo operationInfo) {
    	return operationInfoMapper.updateIgnoreNull(operationInfo);
    }
	
    /**
     * 删除工序信息记录
     *
     * @param operationInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(OperationInfo operationInfo) {
    	return operationInfoMapper.deleteById(operationInfo.getId());
    }
	
}