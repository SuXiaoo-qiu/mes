package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.SysResourceDto;
import com.worlds.mes.entity.SysResource;
import com.worlds.mes.service.SysResourceService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.SysResourceVo;
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
@RequestMapping("/mes/SysResource")
@Api(value = "菜单权限表",tags = "菜单权限表")
public class SysResourceController extends BaseController {

    private static Log log = LogFactory.getLog(SysResourceController.class);

    @Autowired
    private SysResourceService sysResourceService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<SysResource> listAll() {
      List<SysResource> sysResource = sysResourceService.listAll();
        log.info("查询到数据"+ sysResource);
        return sysResource;
    }
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<SysResourceDto>> LIST_ALL_BY_PARAM (@RequestBody SysResourceVo sysResourceVo) {
        ResultDto<List<SysResourceDto>> result = new ResultDto();
        Page<HashMap<String, Object>> page = sysResourceService.listAllByParam(sysResourceVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,SysResourceDto.class);
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
    public SysResource getById(Integer id) {
        return sysResourceService.getById(id);
    }
    
    /**
     * 新增，插入所有字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody SysResource sysResource) {
        return sysResourceService.insert(sysResource);
    }
    
    /**
     * 新增，忽略null字段
     *
     * @param sysResource 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody SysResource sysResource) {
        return sysResourceService.insertIgnoreNull(sysResource);
    }
    
    /**
     * 修改，修改所有字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody SysResource sysResource) {
        return sysResourceService.update(sysResource);
    }
    
    /**
     * 修改，忽略null字段
     *
     * @param sysResource 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody SysResource sysResource) {
        return sysResourceService.updateIgnoreNull(sysResource);
    }
    
    /**
     * 删除记录
     *
     * @param sysResource 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody SysResource sysResource) {
        return sysResourceService.delete(sysResource);
    }
    
}