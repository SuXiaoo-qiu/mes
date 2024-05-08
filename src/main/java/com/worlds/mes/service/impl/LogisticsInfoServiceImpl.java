package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.LogisticsInfo;
import com.worlds.mes.vo.LogisticsInfoVo;
import com.worlds.mes.service.LogisticsInfoService;
import com.worlds.mes.mapper.LogisticsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class LogisticsInfoServiceImpl implements  LogisticsInfoService  {
	
    private static Log log = LogFactory.getLog(LogisticsInfoServiceImpl.class);


   @Autowired
    private LogisticsInfoMapper logisticsInfoMapper;

    /**
     * 查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<LogisticsInfo> listAll() {
    	return logisticsInfoMapper.listAll();
    }
    /**
     * 查询物流信息表所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(LogisticsInfoVo logisticsInfoVo) {
        SimplePageInfo pageInfo = logisticsInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) logisticsInfoMapper.listAllByParam(logisticsInfoVo);
        return page;
    }
    /**
     * 查询物流信息表所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<LogisticsInfo> listAllByParamNoPage(LogisticsInfo logisticsInfo) {
        QueryWrapper<LogisticsInfo> logisticsInfoQueryWrapper = new QueryWrapper<>();
        logisticsInfoQueryWrapper.setEntity(logisticsInfo);
        return logisticsInfoMapper.selectList(logisticsInfoQueryWrapper);
    }


/**
     * 根据主键查询物流信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public LogisticsInfo getById(Integer id) {
    	return logisticsInfoMapper.getById(id);
    }
	
    /**
     * 新增物流信息表，插入所有字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(LogisticsInfo logisticsInfo) {
    	return logisticsInfoMapper.insert(logisticsInfo);
    }
	
    /**
     * 新增物流信息表，忽略null字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(LogisticsInfo logisticsInfo) {
    	return logisticsInfoMapper.insertIgnoreNull(logisticsInfo);
    }
	
    /**
     * 修改物流信息表，修改所有字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(LogisticsInfo logisticsInfo) {
    	return logisticsInfoMapper.update(logisticsInfo);
    }
	
    /**
     * 修改物流信息表，忽略null字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(LogisticsInfo logisticsInfo) {
    	return logisticsInfoMapper.updateIgnoreNull(logisticsInfo);
    }
	
    /**
     * 删除物流信息表记录
     *
     * @param logisticsInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(LogisticsInfo logisticsInfo) {
    	return logisticsInfoMapper.deleteById(logisticsInfo.getId());
    }
	
}