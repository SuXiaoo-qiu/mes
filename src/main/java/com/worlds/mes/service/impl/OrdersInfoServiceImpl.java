package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.OrdersInfo;
import com.worlds.mes.vo.OrdersInfoVo;
import com.worlds.mes.service.OrdersInfoService;
import com.worlds.mes.mapper.OrdersInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class OrdersInfoServiceImpl implements  OrdersInfoService  {
	
    private static Log log = LogFactory.getLog(OrdersInfoServiceImpl.class);


   @Autowired
    private OrdersInfoMapper ordersInfoMapper;

    /**
     * 查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<OrdersInfo> listAll() {
    	return ordersInfoMapper.listAll();
    }
    /**
     * 查询订单信息表所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(OrdersInfoVo ordersInfoVo) {
        SimplePageInfo pageInfo = ordersInfoVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) ordersInfoMapper.listAllByParam(ordersInfoVo);
        return page;
    }
    /**
     * 查询订单信息表所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<OrdersInfo> listAllByParamNoPage(OrdersInfo ordersInfo) {
        QueryWrapper<OrdersInfo> ordersInfoQueryWrapper = new QueryWrapper<>();
        ordersInfoQueryWrapper.setEntity(ordersInfo);
        return ordersInfoMapper.selectList(ordersInfoQueryWrapper);
    }


/**
     * 根据主键查询订单信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public OrdersInfo getById(Integer id) {
    	return ordersInfoMapper.getById(id);
    }
	
    /**
     * 新增订单信息表，插入所有字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(OrdersInfo ordersInfo) {
    	return ordersInfoMapper.insert(ordersInfo);
    }
	
    /**
     * 新增订单信息表，忽略null字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(OrdersInfo ordersInfo) {
    	return ordersInfoMapper.insertIgnoreNull(ordersInfo);
    }
	
    /**
     * 修改订单信息表，修改所有字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(OrdersInfo ordersInfo) {
    	return ordersInfoMapper.update(ordersInfo);
    }
	
    /**
     * 修改订单信息表，忽略null字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(OrdersInfo ordersInfo) {
    	return ordersInfoMapper.updateIgnoreNull(ordersInfo);
    }
	
    /**
     * 删除订单信息表记录
     *
     * @param ordersInfo 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(OrdersInfo ordersInfo) {
    	return ordersInfoMapper.deleteById(ordersInfo.getId());
    }
	
}