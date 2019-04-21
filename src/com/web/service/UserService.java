package com.web.service;

import com.web.model.Users;

import java.util.List;

public interface UserService {
    public List<Users> queryAll();
    public Users queryUserById(int id);
}
