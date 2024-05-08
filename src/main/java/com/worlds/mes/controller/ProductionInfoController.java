package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ProductionInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.ProductionInfo;
import com.worlds.mes.service.ProductionInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.ProductionInfoVo;
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
@RequestMapping("/mes/ProductionInfo")
@Api(value = "生产信息",tags = "生产信息")
public class ProductionInfoController extends BaseController {

    private static Log log = LogFactory.getLog(ProductionInfoController.class);

    @Autowired
    private ProductionInfoService productionInfoService;

    /**
     * 查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询生产信息所有记录")
    public List<ProductionInfo> listAll() {
      List<ProductionInfo> productionInfo = productionInfoService.listAll();
        log.info("查询到数据"+ productionInfo);
        return productionInfo;
    }
    
    /**
     * 根据条件分页查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询生产信息所有记录")
    public ResultDto<List<ProductionInfoDto>> LIST_ALL_BY_PARAM (@RequestBody ProductionInfoVo productionInfoVo) {
        ResultDto<List<ProductionInfoDto>> result = new ResultDto();
       if (null==productionInfoVo || null == productionInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = productionInfoService.listAllByParam(productionInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,ProductionInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询生产信息所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询生产信息所有记录")
     public ResultDto<List<ProductionInfoDto>> LIST_ALL_BY_PARAM (@RequestBody ProductionInfo productionInfo) {
        ResultDto<List<ProductionInfoDto>> result = new ResultDto();
       if (null==productionInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<ProductionInfo>  res = productionInfoService.listAllByParamNoPage(productionInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,ProductionInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询生产信息
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询生产信息")
    public ProductionInfo getById(Integer id) {
        return productionInfoService.getById(id);
    }
    
    /**
     * 新增，插入生产信息所有字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入生产信息所有字段")
    public int insert(@RequestBody ProductionInfo productionInfo) {
        return productionInfoService.insert(productionInfo);
    }
    
    /**
     * 新增生产信息，忽略null字段
     *
     * @param productionInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增生产信息，忽略null字段")
    public int insertIgnoreNull(@RequestBody ProductionInfo productionInfo) {
        return productionInfoService.insertIgnoreNull(productionInfo);
    }
    
    /**
     * 修改，修改生产信息所有字段
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改生产信息所有字段")
    public int update(@RequestBody ProductionInfo productionInfo) {
        return productionInfoService.update(productionInfo);
    }
    
    /**
     * 修改，忽略null字段 生产信息
     *
     * @param productionInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改生产信息，忽略null字段")
    public int updateIgnoreNull(@RequestBody ProductionInfo productionInfo) {
        return productionInfoService.updateIgnoreNull(productionInfo);
    }
    
    /**
     * 删除生产信息记录 
     *
     * @param productionInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除生产信息记录")
    public int delete(@RequestBody ProductionInfo productionInfo) {
        return productionInfoService.delete(productionInfo);
    }
    
}