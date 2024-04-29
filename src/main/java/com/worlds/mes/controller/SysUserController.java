package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.SysUserDto;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.service.SysUserService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.SysUserVo;
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
@RequestMapping("/mes/SysUser")
@Api(value = "用户表",tags = "用户表")
public class SysUserController extends BaseController {

    private static Log log = LogFactory.getLog(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<SysUser> listAll() {
      List<SysUser> sysUser = sysUserService.listAll();
        log.info("查询到数据"+ sysUser);
        return sysUser;
    }

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.TEST_PLUS)
    @ApiOperation(value = "查询所有记录MybatisPlus")
    public List<SysUser> testPlus(@RequestBody SysUser user) {
        List<SysUser> Listuser = sysUserService.testPlus(user);
        log.info("查询到数据"+ Listuser);
        return Listuser;
    }
    
    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<SysUserDto>> LIST_ALL_BY_PARAM (@RequestBody SysUserVo sysUserVo) {
        ResultDto<List<SysUserDto>> result = new ResultDto();
        Page<HashMap<String, Object>> page = sysUserService.listAllByParam(sysUserVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,SysUserDto.class);
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
    public SysUser getById(Integer id) {
        return sysUserService.getById(id);
    }
    
    /**
     * 新增，插入所有字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }
    
    /**
     * 新增，忽略null字段
     *
     * @param sysUser 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody SysUser sysUser) {
        return sysUserService.insertIgnoreNull(sysUser);
    }
    
    /**
     * 修改，修改所有字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody SysUser sysUser) {
        return sysUserService.update(sysUser);
    }
    
    /**
     * 修改，忽略null字段
     *
     * @param sysUser 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody SysUser sysUser) {
        return sysUserService.updateIgnoreNull(sysUser);
    }
    
    /**
     * 删除记录
     *
     * @param sysUser 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody SysUser sysUser) {
        return sysUserService.delete(sysUser);
    }
    
}