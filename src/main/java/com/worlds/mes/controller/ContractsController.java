package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ContractsDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.Contracts;
import com.worlds.mes.service.ContractsService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.ContractsVo;
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
@RequestMapping("/mes/Contracts")
@Api(value = "合同信息表",tags = "合同信息表")
public class ContractsController extends BaseController {

    private static Log log = LogFactory.getLog(ContractsController.class);

    @Autowired
    private ContractsService contractsService;

    /**
     * 查询合同信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<Contracts> listAll() {
      List<Contracts> contracts = contractsService.listAll();
        log.info("查询到数据"+ contracts);
        return contracts;
    }
    
    /**
     * 根据条件分页查询合同信息表所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件分页查询所有记录")
    public ResultDto<List<ContractsDto>> LIST_ALL_BY_PARAM (@RequestBody ContractsVo contractsVo) {
        ResultDto<List<ContractsDto>> result = new ResultDto();
       if (null==contractsVo || null == contractsVo.getPageInfo()){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数不能为空或者分页信息不能为空");
            return result;
        }
        Page<HashMap<String, Object>> page = contractsService.listAllByParam(contractsVo);
                if (page.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(page,ContractsDto.class);
                log.info("查询到数据"+ result);
                return result;
    }
    
     /**
     * 根据条件查询合同信息表所有记录
     *
     * @return 返回集合，没有返回空List
     * */

    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM_NO_PAGE)
    @ApiOperation(value = "根据条件查询所有记录")
     public ResultDto<List<ContractsDto>> LIST_ALL_BY_PARAM (@RequestBody Contracts contracts) {
        ResultDto<List<ContractsDto>> result = new ResultDto();
       if (null==contracts){
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("参数信息不能为空");
            return result;
        }
       List<Contracts>  res = contractsService.listAllByParamNoPage(contracts);
                if (res.isEmpty()) {
                    result.setCode(MesEnumUtils.CODE_5000);
                    result.setSuccess(false);
                    result.setMessage("未查询到数据");
                    return result;
                }
                result =getPageDataByMap(res,ContractsDto.class);
                log.info("查询到数据"+ result);
                return result;
    }


    
    
    
    /**
     * 根据主键查询合同信息表
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
  
    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询")
    public Contracts getById(Integer id) {
        return contractsService.getById(id);
    }
    
    /**
     * 新增，插入合同信息表所有字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody Contracts contracts) {
        return contractsService.insert(contracts);
    }
    
    /**
     * 新增，忽略null字段 合同信息表
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody Contracts contracts) {
        return contractsService.insertIgnoreNull(contracts);
    }
    
    /**
     * 修改，修改合同信息表所有字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody Contracts contracts) {
        return contractsService.update(contracts);
    }
    
    /**
     * 修改，忽略null字段 合同信息表
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody Contracts contracts) {
        return contractsService.updateIgnoreNull(contracts);
    }
    
    /**
     * 删除合同信息表记录 
     *
     * @param contracts 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody Contracts contracts) {
        return contractsService.delete(contracts);
    }
    
}