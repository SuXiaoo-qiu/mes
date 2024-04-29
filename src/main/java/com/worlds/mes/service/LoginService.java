package com.worlds.mes.service;

import com.worlds.mes.entity.User;

import java.util.List;

public interface LoginService {
    public List<User> login(String username, String password);

}