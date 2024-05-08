package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.CustomerInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.CustomerInfo;
import com.worlds.mes.service.CustomerInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.CustomerInfoVo;
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
@RequestMapping("/mes/CustomerInfo")
@Api(value = "客户信息表",tags = "客户信息表")
public class CustomerInfoController extends BaseController {

    private static Log log = LogFactory.getLog(CustomerInfoController.class);

    @Autowired
    private CustomerInfoService customerInfoService;

    /**
     * 查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询客户信息表所有记录")
    public List<CustomerInfo> listAll() {
      List<CustomerInfo> customerInfo = customerInfoService.listAll();
        log.info("查询到数据"+ customerInfo);
        return customerInfo;
    }
    
    /**
     * 根据条件分页查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询客户信息表所有记录")
    public ResultDto<List<CustomerInfoDto>> LIST_ALL_BY_PARAM (@RequestBody CustomerInfoVo customerInfoVo) {
        ResultDto<List<CustomerInfoDto>> result = new ResultDto();
       if (null==customerInfoVo || null == customerInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = customerInfoService.listAllByParam(customerInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,CustomerInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询客户信息表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询客户信息表所有记录")
     public ResultDto<List<CustomerInfoDto>> LIST_ALL_BY_PARAM (@RequestBody CustomerInfo customerInfo) {
        ResultDto<List<CustomerInfoDto>> result = new ResultDto();
       if (null==customerInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<CustomerInfo>  res = customerInfoService.listAllByParamNoPage(customerInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,CustomerInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询客户信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询客户信息表")
    public CustomerInfo getById(Integer id) {
        return customerInfoService.getById(id);
    }
    
    /**
     * 新增，插入客户信息表所有字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入客户信息表所有字段")
    public int insert(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.insert(customerInfo);
    }
    
    /**
     * 新增客户信息表，忽略null字段
     *
     * @param customerInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增客户信息表，忽略null字段")
    public int insertIgnoreNull(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.insertIgnoreNull(customerInfo);
    }
    
    /**
     * 修改，修改客户信息表所有字段
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改客户信息表所有字段")
    public int update(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.update(customerInfo);
    }
    
    /**
     * 修改，忽略null字段 客户信息表
     *
     * @param customerInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改客户信息表，忽略null字段")
    public int updateIgnoreNull(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.updateIgnoreNull(customerInfo);
    }
    
    /**
     * 删除客户信息表记录 
     *
     * @param customerInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除客户信息表记录")
    public int delete(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.delete(customerInfo);
    }
    
}