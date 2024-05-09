package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.OrdersInfoDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.ResultNoPageDto;
import com.worlds.mes.entity.OrdersInfo;
import com.worlds.mes.service.OrdersInfoService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.OrdersInfoVo;
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
@RequestMapping("/mes/OrdersInfo")
@Api(value = "订单信息表",tags = "订单信息表")
public class OrdersInfoController extends BaseController {

    private static Log log = LogFactory.getLog(OrdersInfoController.class);

    @Autowired
    private OrdersInfoService ordersInfoService;

    /**
     * 查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询订单信息表所有记录")
    public List<OrdersInfo> listAll() {
      List<OrdersInfo> ordersInfo = ordersInfoService.listAll();
        log.info("查询到数据"+ ordersInfo);
        return ordersInfo;
    }
    
    /**
     * 根据条件分页查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询订单信息表所有记录")
    public ResultDto<List<OrdersInfoDto>> LIST_ALL_BY_PARAM (@RequestBody OrdersInfoVo ordersInfoVo) {
        ResultDto<List<OrdersInfoDto>> result = new ResultDto();
       if (null==ordersInfoVo || null == ordersInfoVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = ordersInfoService.listAllByParam(ordersInfoVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,OrdersInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询订单信息表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询订单信息表所有记录")
     public ResultDto<List<OrdersInfoDto>> LIST_ALL_BY_PARAM (@RequestBody OrdersInfo ordersInfo) {
        ResultDto<List<OrdersInfoDto>> result = new ResultDto();
       if (null==ordersInfo){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<OrdersInfo>  res = ordersInfoService.listAllByParamNoPage(ordersInfo);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,OrdersInfoDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询订单信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询订单信息表")
    public OrdersInfo getById(Integer id) {
        return ordersInfoService.getById(id);
    }
    
    /**
     * 新增，插入订单信息表所有字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入订单信息表所有字段")
    public int insert(@RequestBody OrdersInfo ordersInfo) {
        return ordersInfoService.insert(ordersInfo);
    }
    
    /**
     * 新增订单信息表，忽略null字段
     *
     * @param ordersInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增订单信息表，忽略null字段")
    public int insertIgnoreNull(@RequestBody OrdersInfo ordersInfo) {
        return ordersInfoService.insertIgnoreNull(ordersInfo);
    }
    
    /**
     * 修改，修改订单信息表所有字段
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改订单信息表所有字段")
    public int update(@RequestBody OrdersInfo ordersInfo) {
        return ordersInfoService.update(ordersInfo);
    }
    
    /**
     * 修改，忽略null字段 订单信息表
     *
     * @param ordersInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改订单信息表，忽略null字段")
    public int updateIgnoreNull(@RequestBody OrdersInfo ordersInfo) {
        return ordersInfoService.updateIgnoreNull(ordersInfo);
    }
    
    /**
     * 删除订单信息表记录 
     *
     * @param ordersInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除订单信息表记录")
    public int delete(@RequestBody OrdersInfo ordersInfo) {
        return ordersInfoService.delete(ordersInfo);
    }

    /**
     * 订单下发
     * @return
     */
    @RequestMapping(value = UrlMapping.ORDER_INSERT)
    @ApiOperation(value = "订单下发")
    public ResultNoPageDto orderInsert() {

        return new ResultNoPageDto();
    }






}