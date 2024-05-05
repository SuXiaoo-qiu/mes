package com.worlds.mes.controller;

import com.github.pagehelper.Page;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.LoginLogDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.LoginLog;
import com.worlds.mes.service.LoginLogService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.LoginLogVo;
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
@RequestMapping("/mes/LoginLog")
@Api(value = "登录日志表",tags = "登录日志表")
public class LoginLogController extends BaseController {

    private static Log log = LogFactory.getLog(LoginLogController.class);

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST)
    @ApiOperation(value = "查询所有记录")
    public List<LoginLog> listAll() {
        List<LoginLog> loginLog = loginLogService.listAll();
        log.info("查询到数据"+ loginLog);
        return loginLog;
    }

    /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping(value = UrlMapping.LIST_ALL_BY_PARAM)
    @ApiOperation(value = "根据条件查询所有记录")
    public ResultDto<List<LoginLogDto>> LIST_ALL_BY_PARAM (@RequestBody LoginLogVo loginLogVo) {
        ResultDto<List<LoginLogDto>> result = new ResultDto();
        Page<HashMap<String, Object>> page = loginLogService.listAllByParam(loginLogVo);
        if (page.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("未查询到数据");
            return result;
        }
        result =getPageDataByMap(page,LoginLogDto.class);
        log.info("查询到数据"+ result);
        return result;
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */

    @RequestMapping(value = UrlMapping.GET_BY_ID)
    @ApiOperation(value = "根据主键查询")
    public LoginLog getById(Integer id) {
        return loginLogService.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT, method = RequestMethod.POST)
    @ApiOperation(value = "新增，插入所有字段")
    public int insert(@RequestBody LoginLog loginLog) {
        return loginLogService.insert(loginLog);
    }

    /**
     * 新增，忽略null字段
     *
     * @param loginLog 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.INSERT_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "新增，忽略null字段")
    public int insertIgnoreNull(@RequestBody LoginLog loginLog) {
        return loginLogService.insertIgnoreNull(loginLog);
    }

    /**
     * 修改，修改所有字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE, method = RequestMethod.POST)
    @ApiOperation(value = "修改，修改所有字段")
    public int update(@RequestBody LoginLog loginLog) {
        return loginLogService.update(loginLog);
    }

    /**
     * 修改，忽略null字段
     *
     * @param loginLog 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.UPDATE_IGNORE_NULL, method = RequestMethod.POST)
    @ApiOperation(value = "修改，忽略null字段")
    public int updateIgnoreNull(@RequestBody LoginLog loginLog) {
        return loginLogService.updateIgnoreNull(loginLog);
    }

    /**
     * 删除记录
     *
     * @param loginLog 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping(value = UrlMapping.DELETE)
    @ApiOperation(value = "删除记录")
    public int delete(@RequestBody LoginLog loginLog) {
        return loginLogService.delete(loginLog);
    }


}