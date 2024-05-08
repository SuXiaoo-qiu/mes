package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.EmployeeInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.EmployeeInfo;
import com.worlds.mes.service.EmployeeInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.EmployeeInfoVo;
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
@RequestMapping("/mes/EmployeeInfo")
@Api(value = "员工信息表",tags = "员工信息表")
public class EmployeeInfoController extends BaseController {

    private static Log log = LogFactory.getLog(EmployeeInfoController.class);

    @Autowired
    private EmployeeInfoService employeeInfoService;

    /**
     * 查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询员工信息表所有记录")
    public List<EmployeeInfo> listAll() {
      List<EmployeeInfo> employeeInfo = employeeInfoService.listAll();
        log.info("查询到数据"+ employeeInfo);
        return employeeInfo;
    }
    
    /**
     * 根据条件分页查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询员工信息表所有记录")
    public ResultDto<List<EmployeeInfoDto>> LIST_ALL_BY_PARAM (@RequestBody EmployeeInfoVo employeeInfoVo) {
        ResultDto<List<EmployeeInfoDto>> result = new ResultDto();
       if (null==employeeInfoVo || null == employeeInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = employeeInfoService.listAllByParam(employeeInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,EmployeeInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询员工信息表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询员工信息表所有记录")
     public ResultDto<List<EmployeeInfoDto>> LIST_ALL_BY_PARAM (@RequestBody EmployeeInfo employeeInfo) {
        ResultDto<List<EmployeeInfoDto>> result = new ResultDto();
       if (null==employeeInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<EmployeeInfo>  res = employeeInfoService.listAllByParamNoPage(employeeInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,EmployeeInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询员工信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询员工信息表")
    public EmployeeInfo getById(Integer id) {
        return employeeInfoService.getById(id);
    }
    
    /**
     * 新增，插入员工信息表所有字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入员工信息表所有字段")
    public int insert(@RequestBody EmployeeInfo employeeInfo) {
        return employeeInfoService.insert(employeeInfo);
    }
    
    /**
     * 新增员工信息表，忽略null字段
     *
     * @param employeeInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增员工信息表，忽略null字段")
    public int insertIgnoreNull(@RequestBody EmployeeInfo employeeInfo) {
        return employeeInfoService.insertIgnoreNull(employeeInfo);
    }
    
    /**
     * 修改，修改员工信息表所有字段
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改员工信息表所有字段")
    public int update(@RequestBody EmployeeInfo employeeInfo) {
        return employeeInfoService.update(employeeInfo);
    }
    
    /**
     * 修改，忽略null字段 员工信息表
     *
     * @param employeeInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改员工信息表，忽略null字段")
    public int updateIgnoreNull(@RequestBody EmployeeInfo employeeInfo) {
        return employeeInfoService.updateIgnoreNull(employeeInfo);
    }
    
    /**
     * 删除员工信息表记录 
     *
     * @param employeeInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除员工信息表记录")
    public int delete(@RequestBody EmployeeInfo employeeInfo) {
        return employeeInfoService.delete(employeeInfo);
    }
    
}