package com.worlds.mes.service;

import com.worlds.mes.entity.OrdersInfo;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.OrdersInfoVo;
import java.util.List;
import java.util.HashMap;

public interface OrdersInfoService {

   /**
     * 查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<OrdersInfo> listAll();
    
    /**
     * 根据条件分页查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(OrdersInfoVo ordersInfoVo);
    
   /**
     * 根据条件查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<OrdersInfo> listAllByParamNoPage(OrdersInfo ordersInfo);

    /**
     * 根据主键查询订单信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public OrdersInfo getById(Integer id);
	
    /**
     * 新增订单信息表，插入所有字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(OrdersInfo ordersInfo);
    
    /**
     * 新增订单信息表，忽略null字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(OrdersInfo ordersInfo);
	
    /**
     * 修改订单信息表，修改所有字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(OrdersInfo ordersInfo);
    
    /**
     * 修改订单信息表，忽略null字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(OrdersInfo ordersInfo);
    
    /**
     * 删除订单信息表记录
     *
     * @param ordersInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(OrdersInfo ordersInfo);
    
}