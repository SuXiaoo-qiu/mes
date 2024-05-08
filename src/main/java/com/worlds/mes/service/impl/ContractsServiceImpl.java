package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.worlds.mes.entity.Contracts;
import com.worlds.mes.entity.OrdersInfo;
import com.worlds.mes.mapper.ContractsMapper;
import com.worlds.mes.mapper.OrdersInfoMapper;
import com.worlds.mes.service.ContractsService;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.ContractsVo;
import com.worlds.mes.vo.OrdersInfoVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class ContractsServiceImpl implements  ContractsService  {

    private static Log log = LogFactory.getLog(ContractsServiceImpl.class);


    @Autowired
    private ContractsMapper contractsMapper;
    @Autowired
    private OrdersInfoMapper ordersInfoMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<Contracts> listAll() {
        return contractsMapper.listAll();
    }
    /**
     * 查询所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(ContractsVo contractsVo) {
        SimplePageInfo pageInfo = contractsVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) contractsMapper.listAllByParam(contractsVo);
        return page;
    }
    /**
     * 查询所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<Contracts> listAllByParamNoPage(Contracts contracts) {
        QueryWrapper<Contracts> contractsQueryWrapper = new QueryWrapper<>();
        contractsQueryWrapper.setEntity(contracts);
        return contractsMapper.selectList(contractsQueryWrapper);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Contracts getById(Integer id) {
        return contractsMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(Contracts contracts) {
        return contractsMapper.insert(contracts);
    }

    /**
     * 新增，忽略null字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(Contracts contracts) {
        return contractsMapper.insertIgnoreNull(contracts);
    }

    /**
     * 修改，修改所有字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(Contracts contracts) {
        return contractsMapper.update(contracts);
    }

    /**
     * 修改，忽略null字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(Contracts contracts) {
        return contractsMapper.updateIgnoreNull(contracts);
    }

    /**
     * 删除记录
     *
     * @param contracts 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Contracts contracts) {
        return contractsMapper.deleteById(contracts.getId());
    }

    /**
     * 合同下发
     * @param vo
     * @return
     */
    @Override
    public boolean contractIssuance(OrdersInfoVo vo) {
        OrdersInfo ordersInfo = this.setOrdersInfo(vo);
        int i = ordersInfoMapper.insertIgnoreNull(ordersInfo);
        if (i <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 新增合同
     * @param vo
     * @return
     */
        @Override
    public Integer contractInsert(ContractsVo vo) {
        Contracts contracts = new ModelMapper().map(vo, Contracts.class);
        return this.insertIgnoreNull(contracts) ;
    }

    @Transactional
    public OrdersInfo setOrdersInfo(OrdersInfoVo vo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        String format = sdf.format(new Date());
        Random random = new Random();
        Long counter001 = redisTemplate.opsForValue().increment("counter001", 1);
        OrdersInfo order = new ModelMapper().map(vo, OrdersInfo.class);
        order.setOrderId(format+(random.nextInt(9000)+ 1000+counter001));
        order.setOrderDate(new Date());
        order.setOrderStatus(MesEnumUtils.OODER_CODE_1.toString());
        return order;
    }
}