package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.OperationInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.OperationInfo;
import com.worlds.mes.service.OperationInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.OperationInfoVo;
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
@RequestMapping("/mes/OperationInfo")
@Api(value = "工序信息",tags = "工序信息")
public class OperationInfoController extends BaseController {

    private static Log log = LogFactory.getLog(OperationInfoController.class);

    @Autowired
    private OperationInfoService operationInfoService;

    /**
     * 查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询工序信息所有记录")
    public List<OperationInfo> listAll() {
      List<OperationInfo> operationInfo = operationInfoService.listAll();
        log.info("查询到数据"+ operationInfo);
        return operationInfo;
    }
    
    /**
     * 根据条件分页查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询工序信息所有记录")
    public ResultDto<List<OperationInfoDto>> LIST_ALL_BY_PARAM (@RequestBody OperationInfoVo operationInfoVo) {
        ResultDto<List<OperationInfoDto>> result = new ResultDto();
       if (null==operationInfoVo || null == operationInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = operationInfoService.listAllByParam(operationInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,OperationInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询工序信息所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询工序信息所有记录")
     public ResultDto<List<OperationInfoDto>> LIST_ALL_BY_PARAM (@RequestBody OperationInfo operationInfo) {
        ResultDto<List<OperationInfoDto>> result = new ResultDto();
       if (null==operationInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<OperationInfo>  res = operationInfoService.listAllByParamNoPage(operationInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,OperationInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询工序信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询工序信息")
    public OperationInfo getById(Integer id) {
        return operationInfoService.getById(id);
    }
    
    /**
     * 新增，插入工序信息所有字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入工序信息所有字段")
    public int insert(@RequestBody OperationInfo operationInfo) {
        return operationInfoService.insert(operationInfo);
    }
    
    /**
     * 新增工序信息，忽略null字段
     *
     * @param operationInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增工序信息，忽略null字段")
    public int insertIgnoreNull(@RequestBody OperationInfo operationInfo) {
        return operationInfoService.insertIgnoreNull(operationInfo);
    }
    
    /**
     * 修改，修改工序信息所有字段
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改工序信息所有字段")
    public int update(@RequestBody OperationInfo operationInfo) {
        return operationInfoService.update(operationInfo);
    }
    
    /**
     * 修改，忽略null字段 工序信息
     *
     * @param operationInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改工序信息，忽略null字段")
    public int updateIgnoreNull(@RequestBody OperationInfo operationInfo) {
        return operationInfoService.updateIgnoreNull(operationInfo);
    }
    
    /**
     * 删除工序信息记录 
     *
     * @param operationInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除工序信息记录")
    public int delete(@RequestBody OperationInfo operationInfo) {
        return operationInfoService.delete(operationInfo);
    }
    
}