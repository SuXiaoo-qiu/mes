package com.worlds.mes;


public interface UrlMapping {
    /**
     * 公共方法 crud
     */
    String INDEX_PATH = "/";
    //测试
    String TEST = "/test";
    //测试token
    String TEST_TOKEN = "/testToken";
    // 测试+mabatisplus
    String TEST_PLUS = "/testPlus";
    // 查询全部
    String LIST = "/list";
    //根据id 进行查询
    String GET_BY_ID = "/getbyid";
    //新增全部
    String INSERT = "/insert";
    //新增不为空的数据
    String INSERT_IGNORE_NULL = "/insertIgnoreNull";
    //更新
    String UPDATE = "/update";
    //更新不为空的数据
    String UPDATE_IGNORE_NULL = "/updateIgnoreNull";
    //删除
    String DELETE = "/delete";
    // 分页查询
    String LIST_ALL_BY_PARAM = "/listAllByParam";
    // 不分页查询
    String LIST_ALL_BY_PARAM_NO_PAGE = "/listAllByParamNoPage";
    // 新增或更新
    String INSERT_OR_UPDATE = "/insetOrUpdate";

    /**
     * login
     */
    // 登录
    String LOGIN = "/login";
    // 退出
    String LOGIN_OUT = "/loginOut";
    // 注册
    String USER_REGISTER = "/userRegister";
    // 根据用户名和用户id查询该用户的角色和菜单和部门
    String GET_ROLE_DEPT_MENU = "/getRoleAnDeptAndMenu";
    // 新增用户和角色和菜单和部门
    String INSERT_USER_ROLE_DEPT_MENU = "/insertUserAndRoleAnDeptAndMenu";

    /**
     * user
     */
    // 新增角色
    String INSERT_ROLE = "/isnerRole";

    /**
     * 仓库表
     */
    // 批量新增仓库
    String INSERT_BATCH = "/insertBatch";

    /*
     * 合同表
     */
    // 下发
    String CONTRACT_ISSUANCE = "/contractIssuance";
    // 新增合同
    String CONTRACT_INSERT = "/contractInsert";


    /**
     *  订单
     */
    // 订单下发
    String ORDER_INSERT = "/orderInsert";

    /**
     * redis
     */
    // 验证码
    String CODE = "/code";

}
