package com.worlds.mes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.worlds.mes.entity.OrdersInfo;
import com.worlds.mes.vo.OrdersInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersInfoMapper extends BaseMapper<OrdersInfo>{

	/**
     * 查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<OrdersInfo> listAll();
    
     /**
     * 根据条件查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<HashMap<String, Object>> listAllByParam(OrdersInfoVo ordersInfoVo);

	/**
     * 根据主键查询订单信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	OrdersInfo getById(Integer id);
	
	/**
     * 新增订单信息表，插入所有字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
	int insert(OrdersInfo ordersInfo);
	
	/**
     * 新增订单信息表，忽略null字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(OrdersInfo ordersInfo);
	
	/**
     * 修改订单信息表，修改所有字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
	int update(OrdersInfo ordersInfo);
	
	/**
     * 修改订单信息表，忽略null字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(OrdersInfo ordersInfo);
	
}