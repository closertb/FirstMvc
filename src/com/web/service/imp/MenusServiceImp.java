package com.web.service.imp;

import com.web.model.Menus;
import com.web.model.Todo;
import com.web.service.MenusService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TodoService")
public class MenusServiceImp implements MenusService {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Todo getTodoList() {
        return new Todo("what", 2);
    }
    public List<Menus> getMenus(Boolean valid) {
        String sql = "From Menus" + (valid ? " Where status = 1" : "");
        return this.getCurrentSession().createQuery(sql, Menus.class).list();
    }
}
