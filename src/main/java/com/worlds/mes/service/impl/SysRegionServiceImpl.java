package com.worlds.mes.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worlds.mes.commons.SimplePageInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.worlds.mes.entity.SysRegion;
import com.worlds.mes.vo.SysRegionVo;
import com.worlds.mes.service.SysRegionService;
import com.worlds.mes.mapper.SysRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class SysRegionServiceImpl implements  SysRegionService  {

    private static Log log = LogFactory.getLog(SysRegionServiceImpl.class);


    @Autowired
    private SysRegionMapper sysRegionMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysRegion> listAll() {
        return sysRegionMapper.listAll();
    }
    /**
     * 查询所有记录 带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public Page<HashMap<String, Object>> listAllByParam(SysRegionVo sysRegionVo) {
        SimplePageInfo pageInfo = sysRegionVo.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getCount());
        Page<HashMap<String,Object>> page = (Page<HashMap<String, Object>>) sysRegionMapper.listAllByParam(sysRegionVo);
        return page;
    }
    /**
     * 查询所有记录 不带有分页
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<SysRegion> listAllByParamNoPage(SysRegion sysRegion) {
        QueryWrapper<SysRegion> sysRegionQueryWrapper = new QueryWrapper<>();
        sysRegionQueryWrapper.setEntity(sysRegion);
        return sysRegionMapper.selectList(sysRegionQueryWrapper);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public SysRegion getById(String id) {
        return sysRegionMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insert(SysRegion sysRegion) {
        return sysRegionMapper.insert(sysRegion);
    }

    /**
     * 新增，忽略null字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int insertIgnoreNull(SysRegion sysRegion) {
        return sysRegionMapper.insertIgnoreNull(sysRegion);
    }

    /**
     * 修改，修改所有字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int update(SysRegion sysRegion) {
        return sysRegionMapper.update(sysRegion);
    }

    /**
     * 修改，忽略null字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateIgnoreNull(SysRegion sysRegion) {
        return sysRegionMapper.updateIgnoreNull(sysRegion);
    }

    /**
     * 删除记录
     *
     * @param sysRegion 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(SysRegion sysRegion) {
        return sysRegionMapper.deleteById(sysRegion.getId());
    }

}