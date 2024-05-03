package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.SysDepartmentDto;
import com.worlds.mes.entity.SysDepartment;
import com.worlds.mes.service.SysDepartmentService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.SysDepartmentVo;
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
@RequestMapping("/mes/SysDepartment")
@Api(value = "部门表",tags = "部门表")
public class SysDepartmentController extends BaseController {

    private static Log log = LogFactory.getLog(SysDepartmentController.class);

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<SysDepartment> listAll() {
        List<SysDepartment> sysDepartment = sysDepartmentService.listAll();
        log.info("查询到数据"+ sysDepartment);
        return sysDepartment;
    }

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<SysDepartmentDto>> LIST_ALL_BY_PARAM (@RequestBody SysDepartmentVo sysDepartmentVo) {
        ResultDto<List<SysDepartmentDto>> result = new ResultDto();
        if (null==sysDepartmentVo || null == sysDepartmentVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = sysDepartmentService.listAllByParam(sysDepartmentVo);
        if (page.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(page,SysDepartmentDto.class);
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
    public SysDepartment getById(Integer id) {
        return sysDepartmentService.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody SysDepartment sysDepartment) {
        return sysDepartmentService.insert(sysDepartment);
    }

    /**
     * 新增，忽略null字段
     *
     * @param sysDepartment 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody SysDepartment sysDepartment) {
        return sysDepartmentService.insertIgnoreNull(sysDepartment);
    }

    /**
     * 修改，修改所有字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody SysDepartment sysDepartment) {
        return sysDepartmentService.update(sysDepartment);
    }

    /**
     * 修改，忽略null字段
     *
     * @param sysDepartment 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody SysDepartment sysDepartment) {
        return sysDepartmentService.updateIgnoreNull(sysDepartment);
    }

    /**
     * 删除记录
     *
     * @param sysDepartment 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody SysDepartment sysDepartment) {
        return sysDepartmentService.delete(sysDepartment);
    }

}