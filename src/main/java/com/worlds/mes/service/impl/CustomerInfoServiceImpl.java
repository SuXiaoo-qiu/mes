package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.CustomerInfo;
import com.worlds.mes.vo.CustomerInfoVo;
import com.worlds.mes.service.CustomerInfoService;
import com.worlds.mes.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class CustomerInfoServiceImpl implements  CustomerInfoService  {
	
    private static Log log = LogFactory.getLog(CustomerInfoServiceImpl.class);


   @Autowired
    private CustomerInfoMapper customerInfoMapper;

    /**
     * 查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<CustomerInfo> listAll() {
    	return customerInfoMapper.listAll();
    }
    /**
     * 查询客户信息表所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(CustomerInfoVo customerInfoVo) {
        SimplePageInfo pageInfo = customerInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) customerInfoMapper.listAllByParam(customerInfoVo);
        return page;
    }
    /**
     * 查询客户信息表所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<CustomerInfo> listAllByParamNoPage(CustomerInfo customerInfo) {
        QueryWrapper<CustomerInfo> customerInfoQueryWrapper = new QueryWrapper<>();
        customerInfoQueryWrapper.setEntity(customerInfo);
        return customerInfoMapper.selectList(customerInfoQueryWrapper);
    }


/**
     * 根据主键查询客户信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public CustomerInfo getById(Integer id) {
    	return customerInfoMapper.getById(id);
    }
	
    /**
     * 新增客户信息表，插入所有字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(CustomerInfo customerInfo) {
    	return customerInfoMapper.insert(customerInfo);
    }
	
    /**
     * 新增客户信息表，忽略null字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(CustomerInfo customerInfo) {
    	return customerInfoMapper.insertIgnoreNull(customerInfo);
    }
	
    /**
     * 修改客户信息表，修改所有字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(CustomerInfo customerInfo) {
    	return customerInfoMapper.update(customerInfo);
    }
	
    /**
     * 修改客户信息表，忽略null字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(CustomerInfo customerInfo) {
    	return customerInfoMapper.updateIgnoreNull(customerInfo);
    }
	
    /**
     * 删除客户信息表记录
     *
     * @param customerInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(CustomerInfo customerInfo) {
    	return customerInfoMapper.deleteById(customerInfo.getId());
    }
	
}