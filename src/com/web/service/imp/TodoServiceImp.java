package com.web.service.imp;

import com.web.model.Todo;
import com.web.service.TodoService;
import org.springframework.stereotype.Repository;

@Repository("TodoService")
public class TodoServiceImp implements TodoService {
    @Override
    public Todo getTodoList() {
        return new Todo("what", 2);
    }
}
