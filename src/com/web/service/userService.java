package com.web.service;

import com.web.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class userService {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Users> queryAll() {
        String sql = "select id,name,pwd from users";
        //将查询结果映射到Users类中，添加到list中，并返回
        return jdbcTemplate.query(sql, new UsersMapper());
    }

    class UsersMapper implements RowMapper<Users> {

        @Override
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            Users user = new Users();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setPwd(rs.getString(3));

            return user;
        }

    }
}
