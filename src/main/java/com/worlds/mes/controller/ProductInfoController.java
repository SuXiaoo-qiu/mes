package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ProductInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.ProductInfo;
import com.worlds.mes.service.ProductInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.ProductInfoVo;
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
@RequestMapping("/mes/ProductInfo")
@Api(value = "产品信息表",tags = "产品信息表")
public class ProductInfoController extends BaseController {

    private static Log log = LogFactory.getLog(ProductInfoController.class);

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询产品信息表所有记录")
    public List<ProductInfo> listAll() {
      List<ProductInfo> productInfo = productInfoService.listAll();
        log.info("查询到数据"+ productInfo);
        return productInfo;
    }
    
    /**
     * 根据条件分页查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询产品信息表所有记录")
    public ResultDto<List<ProductInfoDto>> LIST_ALL_BY_PARAM (@RequestBody ProductInfoVo productInfoVo) {
        ResultDto<List<ProductInfoDto>> result = new ResultDto();
       if (null==productInfoVo || null == productInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = productInfoService.listAllByParam(productInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,ProductInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询产品信息表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询产品信息表所有记录")
     public ResultDto<List<ProductInfoDto>> LIST_ALL_BY_PARAM (@RequestBody ProductInfo productInfo) {
        ResultDto<List<ProductInfoDto>> result = new ResultDto();
       if (null==productInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<ProductInfo>  res = productInfoService.listAllByParamNoPage(productInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,ProductInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询产品信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询产品信息表")
    public ProductInfo getById(Integer id) {
        return productInfoService.getById(id);
    }
    
    /**
     * 新增，插入产品信息表所有字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入产品信息表所有字段")
    public int insert(@RequestBody ProductInfo productInfo) {
        return productInfoService.insert(productInfo);
    }
    
    /**
     * 新增产品信息表，忽略null字段
     *
     * @param productInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增产品信息表，忽略null字段")
    public int insertIgnoreNull(@RequestBody ProductInfo productInfo) {
        return productInfoService.insertIgnoreNull(productInfo);
    }
    
    /**
     * 修改，修改产品信息表所有字段
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改产品信息表所有字段")
    public int update(@RequestBody ProductInfo productInfo) {
        return productInfoService.update(productInfo);
    }
    
    /**
     * 修改，忽略null字段 产品信息表
     *
     * @param productInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改产品信息表，忽略null字段")
    public int updateIgnoreNull(@RequestBody ProductInfo productInfo) {
        return productInfoService.updateIgnoreNull(productInfo);
    }
    
    /**
     * 删除产品信息表记录 
     *
     * @param productInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除产品信息表记录")
    public int delete(@RequestBody ProductInfo productInfo) {
        return productInfoService.delete(productInfo);
    }
    
}