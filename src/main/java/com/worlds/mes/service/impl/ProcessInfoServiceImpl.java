package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.ProcessInfo;
import com.worlds.mes.vo.ProcessInfoVo;
import com.worlds.mes.service.ProcessInfoService;
import com.worlds.mes.mapper.ProcessInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class ProcessInfoServiceImpl implements  ProcessInfoService  {
	
    private static Log log = LogFactory.getLog(ProcessInfoServiceImpl.class);


   @Autowired
    private ProcessInfoMapper processInfoMapper;

    /**
     * 查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<ProcessInfo> listAll() {
    	return processInfoMapper.listAll();
    }
    /**
     * 查询工艺信息所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(ProcessInfoVo processInfoVo) {
        SimplePageInfo pageInfo = processInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) processInfoMapper.listAllByParam(processInfoVo);
        return page;
    }
    /**
     * 查询工艺信息所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<ProcessInfo> listAllByParamNoPage(ProcessInfo processInfo) {
        QueryWrapper<ProcessInfo> processInfoQueryWrapper = new QueryWrapper<>();
        processInfoQueryWrapper.setEntity(processInfo);
        return processInfoMapper.selectList(processInfoQueryWrapper);
    }


/**
     * 根据主键查询工艺信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public ProcessInfo getById(Integer id) {
    	return processInfoMapper.getById(id);
    }
	
    /**
     * 新增工艺信息，插入所有字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(ProcessInfo processInfo) {
    	return processInfoMapper.insert(processInfo);
    }
	
    /**
     * 新增工艺信息，忽略null字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(ProcessInfo processInfo) {
    	return processInfoMapper.insertIgnoreNull(processInfo);
    }
	
    /**
     * 修改工艺信息，修改所有字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(ProcessInfo processInfo) {
    	return processInfoMapper.update(processInfo);
    }
	
    /**
     * 修改工艺信息，忽略null字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(ProcessInfo processInfo) {
    	return processInfoMapper.updateIgnoreNull(processInfo);
    }
	
    /**
     * 删除工艺信息记录
     *
     * @param processInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(ProcessInfo processInfo) {
    	return processInfoMapper.deleteById(processInfo.getId());
    }
	
}