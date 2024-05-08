package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.LogisticsInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.LogisticsInfo;
import com.worlds.mes.service.LogisticsInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.LogisticsInfoVo;
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
@RequestMapping("/mes/LogisticsInfo")
@Api(value = "物流信息表",tags = "物流信息表")
public class LogisticsInfoController extends BaseController {

    private static Log log = LogFactory.getLog(LogisticsInfoController.class);

    @Autowired
    private LogisticsInfoService logisticsInfoService;

    /**
     * 查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询物流信息表所有记录")
    public List<LogisticsInfo> listAll() {
      List<LogisticsInfo> logisticsInfo = logisticsInfoService.listAll();
        log.info("查询到数据"+ logisticsInfo);
        return logisticsInfo;
    }
    
    /**
     * 根据条件分页查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询物流信息表所有记录")
    public ResultDto<List<LogisticsInfoDto>> LIST_ALL_BY_PARAM (@RequestBody LogisticsInfoVo logisticsInfoVo) {
        ResultDto<List<LogisticsInfoDto>> result = new ResultDto();
       if (null==logisticsInfoVo || null == logisticsInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = logisticsInfoService.listAllByParam(logisticsInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,LogisticsInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询物流信息表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询物流信息表所有记录")
     public ResultDto<List<LogisticsInfoDto>> LIST_ALL_BY_PARAM (@RequestBody LogisticsInfo logisticsInfo) {
        ResultDto<List<LogisticsInfoDto>> result = new ResultDto();
       if (null==logisticsInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<LogisticsInfo>  res = logisticsInfoService.listAllByParamNoPage(logisticsInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,LogisticsInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询物流信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询物流信息表")
    public LogisticsInfo getById(Integer id) {
        return logisticsInfoService.getById(id);
    }
    
    /**
     * 新增，插入物流信息表所有字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入物流信息表所有字段")
    public int insert(@RequestBody LogisticsInfo logisticsInfo) {
        return logisticsInfoService.insert(logisticsInfo);
    }
    
    /**
     * 新增物流信息表，忽略null字段
     *
     * @param logisticsInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增物流信息表，忽略null字段")
    public int insertIgnoreNull(@RequestBody LogisticsInfo logisticsInfo) {
        return logisticsInfoService.insertIgnoreNull(logisticsInfo);
    }
    
    /**
     * 修改，修改物流信息表所有字段
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改物流信息表所有字段")
    public int update(@RequestBody LogisticsInfo logisticsInfo) {
        return logisticsInfoService.update(logisticsInfo);
    }
    
    /**
     * 修改，忽略null字段 物流信息表
     *
     * @param logisticsInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改物流信息表，忽略null字段")
    public int updateIgnoreNull(@RequestBody LogisticsInfo logisticsInfo) {
        return logisticsInfoService.updateIgnoreNull(logisticsInfo);
    }
    
    /**
     * 删除物流信息表记录 
     *
     * @param logisticsInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除物流信息表记录")
    public int delete(@RequestBody LogisticsInfo logisticsInfo) {
        return logisticsInfoService.delete(logisticsInfo);
    }
    
}