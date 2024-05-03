package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.SysRegionDto;
import com.worlds.mes.entity.SysRegion;
import com.worlds.mes.service.SysRegionService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.SysRegionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin //跨域
@RequestMapping("/mes/SysRegion")
@Api(value = "行政区划表",tags = "行政区划表")
public class SysRegionController extends BaseController {

    private static Log log = LogFactory.getLog(SysRegionController.class);

    @Autowired
    private SysRegionService sysRegionService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<SysRegion> listAll() {
        List<SysRegion> sysRegion = sysRegionService.listAll();
        log.info("查询到数据"+ sysRegion);
        return sysRegion;
    }

    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询所有记录")
    public ResultDto<List<SysRegionDto>> LIST_ALL_BY_PARAM (@RequestBody SysRegionVo sysRegionVo) {
        ResultDto<List<SysRegionDto>> result = new ResultDto();
        if (null==sysRegionVo || null == sysRegionVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = sysRegionService.listAllByParam(sysRegionVo);
        if (page.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(page,SysRegionDto.class);
        log.info("查询到数据"+ result);
        return result;
    }

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<SysRegionDto>> LIST_ALL_BY_PARAM (@RequestBody SysRegion sysRegion) {
        ResultDto<List<SysRegionDto>> result = new ResultDto();
        if (null==sysRegion){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
        List<SysRegion>  res = sysRegionService.listAllByParamNoPage(sysRegion);
        if (res.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(res,SysRegionDto.class);
        log.info("查询到数据"+ result);
        return result;
    }





    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */

    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询")
    public SysRegion getById(String id) {
        return sysRegionService.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody SysRegion sysRegion) {
        return sysRegionService.insert(sysRegion);
    }

    /**
     * 新增，忽略null字段
     *
     * @param sysRegion 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody SysRegion sysRegion) {
        return sysRegionService.insertIgnoreNull(sysRegion);
    }

    /**
     * 修改，修改所有字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody SysRegion sysRegion) {
        return sysRegionService.update(sysRegion);
    }

    /**
     * 修改，忽略null字段
     *
     * @param sysRegion 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody SysRegion sysRegion) {
        return sysRegionService.updateIgnoreNull(sysRegion);
    }

    /**
     * 删除记录
     *
     * @param sysRegion 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody SysRegion sysRegion) {
        return sysRegionService.delete(sysRegion);
    }















}