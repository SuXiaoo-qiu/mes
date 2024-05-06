package com.worlds.mes.service;

import com.worlds.mes.entity.Contracts;
import com.github.pagehelper.Page;
import com.worlds.mes.vo.ContractsVo;
import java.util.List;
import java.util.HashMap;

public interface ContractsService {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Contracts> listAll();
    
    /**
     * 根据条件分页查询所有记录
     *
     * @return 返回集合，没有返回空Page
     */
    public Page<HashMap<String,Object>> listAllByParam(ContractsVo contractsVo);
    
   /**
     * 根据条件查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
     List<Contracts> listAllByParamNoPage(Contracts contracts);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public Contracts getById(Integer id);
	
    /**
     * 新增，插入所有字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
    public int insert(Contracts contracts);
    
    /**
     * 新增，忽略null字段
     *
     * @param contracts 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Contracts contracts);
	
    /**
     * 修改，修改所有字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
    public int update(Contracts contracts);
    
    /**
     * 修改，忽略null字段
     *
     * @param contracts 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Contracts contracts);
    
    /**
     * 删除记录
     *
     * @param contracts 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Contracts contracts);
    
}