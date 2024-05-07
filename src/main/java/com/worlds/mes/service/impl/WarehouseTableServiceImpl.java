package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.worlds.mes.entity.WarehouseTable;
import com.worlds.mes.mapper.WarehouseTableMapper;
import com.worlds.mes.service.WarehouseTableService;
import com.worlds.mes.vo.WarehouseTableVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class WarehouseTableServiceImpl implements  WarehouseTableService {

    private static Log log = LogFactory.getLog(WarehouseTableServiceImpl.class);


    @Autowired
    private WarehouseTableMapper warehouseTableMapper;
    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;
    @Autowired
    private PlatformTransactionManager txManager;
    /**
     * 查询仓库表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<WarehouseTable> listAll() {
        return warehouseTableMapper.listAll();
    }
    /**
     * 查询仓库表所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(WarehouseTableVo warehouseTableVo) {
        SimplePageInfo pageInfo = warehouseTableVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) warehouseTableMapper.listAllByParam(warehouseTableVo);
        return page;
    }
    /**
     * 查询仓库表所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<WarehouseTable> listAllByParamNoPage(WarehouseTable warehouseTable) {
        QueryWrapper<WarehouseTable> warehouseTableQueryWrapper = new QueryWrapper<>();
        warehouseTableQueryWrapper.setEntity(warehouseTable);
        return warehouseTableMapper.selectList(warehouseTableQueryWrapper);
    }


    /**
     * 根据主键查询仓库表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public WarehouseTable getById(Integer id) {
        return warehouseTableMapper.getById(id);
    }

    /**
     * 新增仓库表，插入所有字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(WarehouseTable warehouseTable) {
        return warehouseTableMapper.insert(warehouseTable);
    }

    /**
     * 新增仓库表，忽略null字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(WarehouseTable warehouseTable) {
        return warehouseTableMapper.insertIgnoreNull(warehouseTable);
    }

    /**
     * 修改仓库表，修改所有字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(WarehouseTable warehouseTable) {
        return warehouseTableMapper.update(warehouseTable);
    }

    /**
     * 修改仓库表，忽略null字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(WarehouseTable warehouseTable) {
        return warehouseTableMapper.updateIgnoreNull(warehouseTable);
    }

    /**
     * 删除仓库表记录
     *
     * @param warehouseTable 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(WarehouseTable warehouseTable) {
        return warehouseTableMapper.deleteById(warehouseTable.getId());
    }

    @Override
    public String isnetBatch() {



        long startDate = System.currentTimeMillis();
            List<WarehouseTable> warehouseTables = new ArrayList<>();
            for (int i = 1; i <= 300000; i++) {
                Random random = new Random(10000);
                Random type = new Random(2);
                WarehouseTable warehouseTable = new WarehouseTable();
                warehouseTable.setWarehouseId("ck" + i);
                warehouseTable.setWarehouseName("仓库" + i);
                int i2 = random.nextInt(1000000000);
                warehouseTable.setWarehouseAddress("北京" + i2);
                warehouseTable.setWarehouseType(String.valueOf(type.nextInt(2)));
                int i1 = random.nextInt(1000000000);
                BigDecimal bigDecimal = new BigDecimal(i1 / 100.00);
                warehouseTable.setWarehouseArea(bigDecimal);
                warehouseTable.setStorageCapacity(bigDecimal);
                warehouseTable.setResponsiblePerson("张" + i);
                warehouseTable.setContactPhone(String.valueOf(i1));
                warehouseTable.setRemarks("测试备注");
                warehouseTables.add(warehouseTable);
                if (i % 2000 == 0) {
                    warehouseTableMapper.isnetBatch(warehouseTables);
                    warehouseTables.clear();
                }
            }
            if (!CollectionUtils.isEmpty(warehouseTables)) {
                warehouseTableMapper.isnetBatch(warehouseTables);
            }
            long spendTime = System.currentTimeMillis() - startDate;
            System.out.println("成功插入 三十 万条数据,耗时：" + spendTime + "毫秒");
        return "成功插入 三十 万条数据,耗时：" + spendTime + "毫秒";

    }
    }