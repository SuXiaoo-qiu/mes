package com.worlds.mes.utils;

import com.github.pagehelper.Page;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.dto.ResultTokenDto;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(exposedHeaders = {"Authorization", "authorization"})
public class BaseController {
    /**
     * 从分页查询结果 Page &lt; Map &lt; String, Object &gt; &gt; 中获取返回对象列表
     *
     * @param page 查询结果page对象
     * @param clazz 要返回前台的数据类型
     * @return 符合clazz标准的ResultDTO对象
     */
    public <T> ResultDto<List<T>> getPageDataByMap(Page<HashMap<String, Object>> page, Class<T> clazz) {
        ResultDto<List<T>> result = new ResultDto<List<T>>();
        result.setPageCount(page.getPages());
        result.setTotal(page.getTotal());
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("成功");
        result.setData((List<T>) page);
        return result;
    }
    public <T> ResultDto<List<T>> getPageDataByMap(List page, Class<T> clazz) {
        ResultDto<List<T>> result = new ResultDto<List<T>>();
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("成功");
        result.setData((List<T>) page);
        return result;
    }
    public <T> ResultTokenDto<List<T>> getTokenDataByLogin(List data, Class<T> clazz) {
        ResultTokenDto<List<T>> result = new ResultTokenDto<List<T>>();
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("成功");
        result.setData((List<T>) data);
        return result;
    }
}
