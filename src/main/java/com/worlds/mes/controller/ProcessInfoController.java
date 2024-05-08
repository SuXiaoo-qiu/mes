package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ProcessInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.ProcessInfo;
import com.worlds.mes.service.ProcessInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.ProcessInfoVo;
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
@RequestMapping("/mes/ProcessInfo")
@Api(value = "工艺信息",tags = "工艺信息")
public class ProcessInfoController extends BaseController {

    private static Log log = LogFactory.getLog(ProcessInfoController.class);

    @Autowired
    private ProcessInfoService processInfoService;

    /**
     * 查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询工艺信息所有记录")
    public List<ProcessInfo> listAll() {
      List<ProcessInfo> processInfo = processInfoService.listAll();
        log.info("查询到数据"+ processInfo);
        return processInfo;
    }
    
    /**
     * 根据条件分页查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询工艺信息所有记录")
    public ResultDto<List<ProcessInfoDto>> LIST_ALL_BY_PARAM (@RequestBody ProcessInfoVo processInfoVo) {
        ResultDto<List<ProcessInfoDto>> result = new ResultDto();
       if (null==processInfoVo || null == processInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = processInfoService.listAllByParam(processInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,ProcessInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询工艺信息所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询工艺信息所有记录")
     public ResultDto<List<ProcessInfoDto>> LIST_ALL_BY_PARAM (@RequestBody ProcessInfo processInfo) {
        ResultDto<List<ProcessInfoDto>> result = new ResultDto();
       if (null==processInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<ProcessInfo>  res = processInfoService.listAllByParamNoPage(processInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,ProcessInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询工艺信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询工艺信息")
    public ProcessInfo getById(Integer id) {
        return processInfoService.getById(id);
    }
    
    /**
     * 新增，插入工艺信息所有字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入工艺信息所有字段")
    public int insert(@RequestBody ProcessInfo processInfo) {
        return processInfoService.insert(processInfo);
    }
    
    /**
     * 新增工艺信息，忽略null字段
     *
     * @param processInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增工艺信息，忽略null字段")
    public int insertIgnoreNull(@RequestBody ProcessInfo processInfo) {
        return processInfoService.insertIgnoreNull(processInfo);
    }
    
    /**
     * 修改，修改工艺信息所有字段
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改工艺信息所有字段")
    public int update(@RequestBody ProcessInfo processInfo) {
        return processInfoService.update(processInfo);
    }
    
    /**
     * 修改，忽略null字段 工艺信息
     *
     * @param processInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改工艺信息，忽略null字段")
    public int updateIgnoreNull(@RequestBody ProcessInfo processInfo) {
        return processInfoService.updateIgnoreNull(processInfo);
    }
    
    /**
     * 删除工艺信息记录 
     *
     * @param processInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除工艺信息记录")
    public int delete(@RequestBody ProcessInfo processInfo) {
        return processInfoService.delete(processInfo);
    }
    
}