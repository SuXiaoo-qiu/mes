package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.InspectionInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.InspectionInfo;
import com.worlds.mes.service.InspectionInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.InspectionInfoVo;
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
@RequestMapping("/mes/InspectionInfo")
@Api(value = "检验信息",tags = "检验信息")
public class InspectionInfoController extends BaseController {

    private static Log log = LogFactory.getLog(InspectionInfoController.class);

    @Autowired
    private InspectionInfoService inspectionInfoService;

    /**
     * 查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询检验信息所有记录")
    public List<InspectionInfo> listAll() {
      List<InspectionInfo> inspectionInfo = inspectionInfoService.listAll();
        log.info("查询到数据"+ inspectionInfo);
        return inspectionInfo;
    }
    
    /**
     * 根据条件分页查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询检验信息所有记录")
    public ResultDto<List<InspectionInfoDto>> LIST_ALL_BY_PARAM (@RequestBody InspectionInfoVo inspectionInfoVo) {
        ResultDto<List<InspectionInfoDto>> result = new ResultDto();
       if (null==inspectionInfoVo || null == inspectionInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = inspectionInfoService.listAllByParam(inspectionInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,InspectionInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询检验信息所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询检验信息所有记录")
     public ResultDto<List<InspectionInfoDto>> LIST_ALL_BY_PARAM (@RequestBody InspectionInfo inspectionInfo) {
        ResultDto<List<InspectionInfoDto>> result = new ResultDto();
       if (null==inspectionInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<InspectionInfo>  res = inspectionInfoService.listAllByParamNoPage(inspectionInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,InspectionInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询检验信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询检验信息")
    public InspectionInfo getById(Integer id) {
        return inspectionInfoService.getById(id);
    }
    
    /**
     * 新增，插入检验信息所有字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入检验信息所有字段")
    public int insert(@RequestBody InspectionInfo inspectionInfo) {
        return inspectionInfoService.insert(inspectionInfo);
    }
    
    /**
     * 新增检验信息，忽略null字段
     *
     * @param inspectionInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增检验信息，忽略null字段")
    public int insertIgnoreNull(@RequestBody InspectionInfo inspectionInfo) {
        return inspectionInfoService.insertIgnoreNull(inspectionInfo);
    }
    
    /**
     * 修改，修改检验信息所有字段
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改检验信息所有字段")
    public int update(@RequestBody InspectionInfo inspectionInfo) {
        return inspectionInfoService.update(inspectionInfo);
    }
    
    /**
     * 修改，忽略null字段 检验信息
     *
     * @param inspectionInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改检验信息，忽略null字段")
    public int updateIgnoreNull(@RequestBody InspectionInfo inspectionInfo) {
        return inspectionInfoService.updateIgnoreNull(inspectionInfo);
    }
    
    /**
     * 删除检验信息记录 
     *
     * @param inspectionInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除检验信息记录")
    public int delete(@RequestBody InspectionInfo inspectionInfo) {
        return inspectionInfoService.delete(inspectionInfo);
    }
    
}