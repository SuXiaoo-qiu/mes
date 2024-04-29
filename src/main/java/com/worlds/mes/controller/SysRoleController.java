package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.SysRoleDto;
import com.worlds.mes.entity.SysRole;
import com.worlds.mes.service.SysRoleService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.SysRoleVo;
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
@RequestMapping("/mes/SysRole")
@Api(value = "角色表",tags = "角色表")
public class SysRoleController extends BaseController {

    private static Log log = LogFactory.getLog(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<SysRole> listAll() {
      List<SysRole> sysRole = sysRoleService.listAll();
        log.info("查询到数据"+ sysRole);
        return sysRole;
    }
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<SysRoleDto>> LIST_ALL_BY_PARAM (@RequestBody SysRoleVo sysRoleVo) {
        ResultDto<List<SysRoleDto>> result = new ResultDto();
        Page<HashMap<String, Object>> page = sysRoleService.listAllByParam(sysRoleVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,SysRoleDto.class);
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
    public SysRole getById(Integer id) {
        return sysRoleService.getById(id);
    }
    
    /**
     * 新增，插入所有字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody SysRole sysRole) {
        return sysRoleService.insert(sysRole);
    }
    
    /**
     * 新增，忽略null字段
     *
     * @param sysRole 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody SysRole sysRole) {
        return sysRoleService.insertIgnoreNull(sysRole);
    }
    
    /**
     * 修改，修改所有字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody SysRole sysRole) {
        return sysRoleService.update(sysRole);
    }
    
    /**
     * 修改，忽略null字段
     *
     * @param sysRole 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody SysRole sysRole) {
        return sysRoleService.updateIgnoreNull(sysRole);
    }
    
    /**
     * 删除记录
     *
     * @param sysRole 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody SysRole sysRole) {
        return sysRoleService.delete(sysRole);
    }
    
}