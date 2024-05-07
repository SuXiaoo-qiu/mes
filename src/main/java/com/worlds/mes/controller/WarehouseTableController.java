package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.WarehouseTableDto;
import com.worlds.mes.entity.WarehouseTable;
import com.worlds.mes.service.WarehouseTableService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.WarehouseTableVo;
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
@RequestMapping("/mes/WarehouseTable")
@Api(value = "仓库表",tags = "仓库表")
public class WarehouseTableController extends BaseController {

    private static Log log = LogFactory.getLog(WarehouseTableController.class);

    @Autowired
    private WarehouseTableService warehouseTableService;

    /**
     * 查询仓库表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询仓库表所有记录")
    public List<WarehouseTable> listAll() {
        List<WarehouseTable> warehouseTable = warehouseTableService.listAll();
        log.info("查询到数据"+ warehouseTable);
        return warehouseTable;
    }

    /**
     * 根据条件分页查询仓库表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询仓库表所有记录")
    public ResultDto<List<WarehouseTableDto>> LIST_ALL_BY_PARAM (@RequestBody WarehouseTableVo warehouseTableVo) {
        ResultDto<List<WarehouseTableDto>> result = new ResultDto();
        if (null==warehouseTableVo || null == warehouseTableVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = warehouseTableService.listAllByParam(warehouseTableVo);
        if (page.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(page,WarehouseTableDto.class);
        log.info("查询到数据"+ result);
        return result;
    }

    /**
     * 根据条件查询仓库表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询仓库表所有记录")
    public ResultDto<List<WarehouseTableDto>> LIST_ALL_BY_PARAM (@RequestBody WarehouseTable warehouseTable) {
        ResultDto<List<WarehouseTableDto>> result = new ResultDto();
        if (null==warehouseTable){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
        List<WarehouseTable>  res = warehouseTableService.listAllByParamNoPage(warehouseTable);
        if (res.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(res,WarehouseTableDto.class);
        log.info("查询到数据"+ result);
        return result;
    }





    /**
     * 根据主键查询仓库表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */

    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询仓库表")
    public WarehouseTable getById(Integer id) {
        return warehouseTableService.getById(id);
    }

    /**
     * 新增，插入仓库表所有字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入仓库表所有字段")
    public int insert(@RequestBody WarehouseTable warehouseTable) {
        return warehouseTableService.insert(warehouseTable);
    }

    /**
     * 新增仓库表，忽略null字段
     *
     * @param warehouseTable 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增仓库表，忽略null字段")
    public int insertIgnoreNull(@RequestBody WarehouseTable warehouseTable) {
        return warehouseTableService.insertIgnoreNull(warehouseTable);
    }

    /**
     * 修改，修改仓库表所有字段
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改仓库表所有字段")
    public int update(@RequestBody WarehouseTable warehouseTable) {
        return warehouseTableService.update(warehouseTable);
    }

    /**
     * 修改，忽略null字段 仓库表
     *
     * @param warehouseTable 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改仓库表，忽略null字段")
    public int updateIgnoreNull(@RequestBody WarehouseTable warehouseTable) {
        return warehouseTableService.updateIgnoreNull(warehouseTable);
    }

    /**
     * 删除仓库表记录
     *
     * @param warehouseTable 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除仓库表记录")
    public int delete(@RequestBody WarehouseTable warehouseTable) {
        return warehouseTableService.delete(warehouseTable);
    }

    /**
     * 批量新增(测试30万数据)
     * @return
     */
    @RequestMapping(value = UrlMapping.INSERT_BATCH)
    @ApiOperation(value = "批量新增(测试30万数据)")
    public String isnetBatch() {
        return warehouseTableService.isnetBatch();
    }



}