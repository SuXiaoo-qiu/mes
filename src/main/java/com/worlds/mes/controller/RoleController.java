package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.RoleDto;
import com.worlds.mes.entity.Role;
import com.worlds.mes.service.RoleService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.RoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mes/Role")
@Api(value = "角色表",tags = "角色表")
public class RoleController extends BaseController {

    private static Log log = LogFactory.getLog(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<Role> listAll() {
        List<Role> role = roleService.listAll();
        log.info("查询到数据"+ role);
        return role;
    }

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<RoleDto>> LIST_ALL_BY_PARAM (@RequestBody RoleVo roleVo) {
        ResultDto<List<RoleDto>> result = new ResultDto();
        Page<HashMap<String, Object>> page = roleService.listAllByParam(roleVo);
        if (page.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(page,RoleDto.class);
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
    public Role getById(Integer id) {
        return roleService.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody Role role) {
        return roleService.insert(role);
    }

    /**
     * 新增，忽略null字段
     *
     * @param role 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody Role role) {
        return roleService.insertIgnoreNull(role);
    }

    /**
     * 修改，修改所有字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody Role role) {
        return roleService.update(role);
    }

    /**
     * 修改，忽略null字段
     *
     * @param role 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody Role role) {
        return roleService.updateIgnoreNull(role);
    }

    /**
     * 删除记录
     *
     * @param role 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody Role role) {
        return roleService.delete(role);
    }

}