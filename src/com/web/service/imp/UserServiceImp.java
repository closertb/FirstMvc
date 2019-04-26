package com.web.service.imp;

import com.web.model.Users;
import com.web.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("UserService")
// @Transactional
public class UserServiceImp implements UserService {
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

    public List queryAll() {
        String sql = "From Users";
        // System.out.println("start"+ this.getCurrentSession());
        List list = this.getCurrentSession().createQuery(sql, Users.class).list();
        //将查询结果映射到Users类中，添加到list中，并返回
        // System.out.println("fg"+ list + list.size());
        return list;
    }

    public Users queryUserById(int id) {
        String sql = "select id,name,pwd from users";
        Users res = (Users) this.getCurrentSession().get(Users.class, id);
        System.out.println("fg"+ ":中文");
        //将查询结果映射到Users类中，添加到list中，并返回
        return res;
    }

    public Boolean saveUser(Users user) {
        Transaction tx = null;
        Session session = this.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }
    public Boolean updateUser(Users user) {
            Transaction tx = null;
            Session session = this.getCurrentSession();
            try {
                tx = session.beginTransaction();
                session.update(user);
                session.flush();
                tx.commit();
            } catch (Exception e) {
                System.out.print("Exception");
                if(tx != null) {
                    tx.rollback();
                }
          }
         return true;
    }
}