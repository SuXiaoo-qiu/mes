package com.worlds.mes;


public interface UrlMapping {
    /**
     * 公共方法 crud
     */
    String INDEX_PATH = "/";
    String TEST = "/test";
    String TEST_TOKEN = "/testToken";
    String TEST_PLUS = "/testPlus";
    String LIST = "/list";
    String GET_BY_ID = "/getbyid";
    String INSERT = "/insert";
    String INSERT_IGNORE_NULL = "/insertIgnoreNull";
    String UPDATE = "/update";
    String UPDATE_IGNORE_NULL = "/updateIgnoreNull";
    String DELETE = "/delete";
    String LIST_ALL_BY_PARAM = "/listAllByParam";
    String LIST_ALL_BY_PARAM_NO_PAGE = "/listAllByParamNoPage";

    /**
     * login
     */
    String LOGIN = "/login";
    String LOGIN_OUT = "/loginOut";
    String USER_REGISTER = "/userRegister";
    // 根据用户名和用户id查询该用户的角色和菜单和部门
    String GET_ROLE_DEPT_MENU = "/getRoleAnDeptAndMenu";
    // 新增用户和角色和菜单和部门
    String INSERT_USER_ROLE_DEPT_MENU = "/insertUserAndRoleAnDeptAndMenu";
    // 测试
    String INSERT_USER_ROLE_DEPT_MENUa = "/insertUserAndRoleAnDeptAndMenu";






}
