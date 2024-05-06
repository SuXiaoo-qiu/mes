package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.InventoryTableDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.InventoryTable;
import com.worlds.mes.service.InventoryTableService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.InventoryTableVo;
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
@RequestMapping("/mes/InventoryTable")
@Api(value = "库存表",tags = "库存表")
public class InventoryTableController extends BaseController {

    private static Log log = LogFactory.getLog(InventoryTableController.class);

    @Autowired
    private InventoryTableService inventoryTableService;

    /**
     * 查询库存表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<InventoryTable> listAll() {
      List<InventoryTable> inventoryTable = inventoryTableService.listAll();
        log.info("查询到数据"+ inventoryTable);
        return inventoryTable;
    }
    
    /**
     * 根据条件分页查询库存表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询所有记录")
    public ResultDto<List<InventoryTableDto>> LIST_ALL_BY_PARAM (@RequestBody InventoryTableVo inventoryTableVo) {
        ResultDto<List<InventoryTableDto>> result = new ResultDto();
       if (null==inventoryTableVo || null == inventoryTableVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = inventoryTableService.listAllByParam(inventoryTableVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,InventoryTableDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询库存表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询所有记录")
     public ResultDto<List<InventoryTableDto>> LIST_ALL_BY_PARAM (@RequestBody InventoryTable inventoryTable) {
        ResultDto<List<InventoryTableDto>> result = new ResultDto();
       if (null==inventoryTable){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<InventoryTable>  res = inventoryTableService.listAllByParamNoPage(inventoryTable);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,InventoryTableDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询库存表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询")
    public InventoryTable getById(Integer id) {
        return inventoryTableService.getById(id);
    }
    
    /**
     * 新增，插入库存表所有字段
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody InventoryTable inventoryTable) {
        return inventoryTableService.insert(inventoryTable);
    }
    
    /**
     * 新增，忽略null字段 库存表
     *
     * @param inventoryTable 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody InventoryTable inventoryTable) {
        return inventoryTableService.insertIgnoreNull(inventoryTable);
    }
    
    /**
     * 修改，修改库存表所有字段
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody InventoryTable inventoryTable) {
        return inventoryTableService.update(inventoryTable);
    }
    
    /**
     * 修改，忽略null字段 库存表
     *
     * @param inventoryTable 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody InventoryTable inventoryTable) {
        return inventoryTableService.updateIgnoreNull(inventoryTable);
    }
    
    /**
     * 删除库存表记录 
     *
     * @param inventoryTable 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody InventoryTable inventoryTable) {
        return inventoryTableService.delete(inventoryTable);
    }
    
}