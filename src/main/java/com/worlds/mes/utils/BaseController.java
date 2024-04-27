package com.worlds.mes.utils;

import com.github.pagehelper.Page;
import com.worlds.mes.commons.SimplePageInfo;
import com.worlds.mes.dto.ResultDto;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

@CrossOrigin(exposedHeaders = {"Authorization", "authorization"})
public class BaseController {

    /**
     * 从查询的传入条件Map中获取分页对象pageInfo
     *
     * @param map 页面传出的查询条件
     * @return 分页参数对象
     */
    @SuppressWarnings("unchecked")
    public SimplePageInfo getPageInfoByMap(Map<String, Object> map) {
        Object obj = map.get("pageInfo");
        SimplePageInfo pageInfo = new SimplePageInfo();
        if (obj != null) {
            if (obj instanceof SimplePageInfo) {
                pageInfo = (SimplePageInfo) obj;
            } else {
                pageInfo = BeanConvertUtils.mapToBean((Map<String, Object>) obj, SimplePageInfo.class);
            }
            if (pageInfo.getPageSize() > PoConstants.MAX_PAGE_SIZE) {
                pageInfo.setPageSize(PoConstants.MAX_PAGE_SIZE);
            }
            map.remove("pageInfo");
        }
        return pageInfo;
    }

    /**
     * 从分页查询结果 Page &lt; Map &lt; String, Object &gt; &gt; 中获取返回对象列表
     *
     * @param page 查询结果page对象
     * @param clazz 要返回前台的数据类型
     * @return 符合clazz标准的ResultDTO对象
     */
    public <T> ResultDto<List<T>> getPageDataByMap(Page<Map<String, Object>> page, Class<T> clazz) {
        ResultDto<List<T>> result = new ResultDto<List<T>>();
        result.setPageCount(page.getPages());
        result.setTotal(page.getTotal());
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setData((List<T>) page);
        return result;
    }
}
