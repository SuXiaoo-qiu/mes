package com.worlds.mes.service;

import com.worlds.mes.entity.SysUser;
import com.worlds.mes.vo.LoginVo;

import java.util.List;

public interface LoginService {
    List<SysUser> login(String username, String password, String ip, String token);
    boolean loginOut(LoginVo vo,String ip);
}