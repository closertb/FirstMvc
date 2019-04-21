package com.web.service;

import com.web.model.Todo;

import java.util.List;

public interface MenusService {
    public Todo getTodoList();
    public List getMenus(Boolean valid);
}
