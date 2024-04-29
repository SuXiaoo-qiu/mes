package com.worlds.mes.service;

import com.worlds.mes.entity.SysUser;

import java.util.List;

public interface LoginService {
    public List<SysUser> login(String username, String password, String ip, String token);

}