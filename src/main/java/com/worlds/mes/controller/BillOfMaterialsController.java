package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.BillOfMaterialsDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.BillOfMaterials;
import com.worlds.mes.service.BillOfMaterialsService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.BillOfMaterialsVo;
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
@RequestMapping("/mes/BillOfMaterials")
@Api(value = "物料表",tags = "物料表")
public class BillOfMaterialsController extends BaseController {

    private static Log log = LogFactory.getLog(BillOfMaterialsController.class);

    @Autowired
    private BillOfMaterialsService billOfMaterialsService;

    /**
     * 查询物料表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<BillOfMaterials> listAll() {
      List<BillOfMaterials> billOfMaterials = billOfMaterialsService.listAll();
        log.info("查询到数据"+ billOfMaterials);
        return billOfMaterials;
    }
    
    /**
     * 根据条件分页查询物料表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询所有记录")
    public ResultDto<List<BillOfMaterialsDto>> LIST_ALL_BY_PARAM (@RequestBody BillOfMaterialsVo billOfMaterialsVo) {
        ResultDto<List<BillOfMaterialsDto>> result = new ResultDto();
       if (null==billOfMaterialsVo || null == billOfMaterialsVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = billOfMaterialsService.listAllByParam(billOfMaterialsVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,BillOfMaterialsDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询物料表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询所有记录")
     public ResultDto<List<BillOfMaterialsDto>> LIST_ALL_BY_PARAM (@RequestBody BillOfMaterials billOfMaterials) {
        ResultDto<List<BillOfMaterialsDto>> result = new ResultDto();
       if (null==billOfMaterials){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<BillOfMaterials>  res = billOfMaterialsService.listAllByParamNoPage(billOfMaterials);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,BillOfMaterialsDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询物料表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询")
    public BillOfMaterials getById(Integer id) {
        return billOfMaterialsService.getById(id);
    }
    
    /**
     * 新增，插入物料表所有字段
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody BillOfMaterials billOfMaterials) {
        return billOfMaterialsService.insert(billOfMaterials);
    }
    
    /**
     * 新增，忽略null字段 物料表
     *
     * @param billOfMaterials 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody BillOfMaterials billOfMaterials) {
        return billOfMaterialsService.insertIgnoreNull(billOfMaterials);
    }
    
    /**
     * 修改，修改物料表所有字段
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody BillOfMaterials billOfMaterials) {
        return billOfMaterialsService.update(billOfMaterials);
    }
    
    /**
     * 修改，忽略null字段 物料表
     *
     * @param billOfMaterials 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody BillOfMaterials billOfMaterials) {
        return billOfMaterialsService.updateIgnoreNull(billOfMaterials);
    }
    
    /**
     * 删除物料表记录 
     *
     * @param billOfMaterials 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody BillOfMaterials billOfMaterials) {
        return billOfMaterialsService.delete(billOfMaterials);
    }
    
}