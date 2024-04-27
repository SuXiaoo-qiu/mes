package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.DepartmentDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.Department;
import com.worlds.mes.service.DepartmentService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.DepartmentVo;
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
@RequestMapping("/mes/Department")
@Api(value = "部门表",tags = "部门表")
public class DepartmentController extends BaseController {

    private static Log log = LogFactory.getLog(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<Department> listAll() {
        List<Department> department = departmentService.listAll();
        log.info("查询到数据"+ department);
        return department;
    }

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<DepartmentDto>> LIST_ALL_BY_PARAM (@RequestBody DepartmentVo departmentVo) {
        ResultDto<List<DepartmentDto>> result = new ResultDto();
        Page<HashMap<String, Object>> page = departmentService.listAllByParam(departmentVo);
        if (page.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(page,DepartmentDto.class);
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
    public Department getById(Integer id) {
        return departmentService.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody Department department) {
        return departmentService.insert(department);
    }

    /**
     * 新增，忽略null字段
     *
     * @param department 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody Department department) {
        return departmentService.insertIgnoreNull(department);
    }

    /**
     * 修改，修改所有字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    /**
     * 修改，忽略null字段
     *
     * @param department 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody Department department) {
        return departmentService.updateIgnoreNull(department);
    }

    /**
     * 删除记录
     *
     * @param department 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody Department department) {
        return departmentService.delete(department);
    }

}