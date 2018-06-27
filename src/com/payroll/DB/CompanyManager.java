package com.payroll.DB;

import com.payroll.account.Manager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyManager {

    private JdbcTemplate data;

    public void setData(DataSource dataSource) {
        this.data = new JdbcTemplate(dataSource);
    }


    /**
     * 根据用户名返回管理员对象
     * */
    public Manager queryUser(String userName){
        String sql = "select password from manager where id=?";
        Manager m = data.queryForObject(sql, new RowMapper<Manager>() {

            @Override
            public Manager mapRow(ResultSet resultSet, int i) throws SQLException {
                Manager m = new Manager();
                m.setUserName(userName);
                m.setPassword(resultSet.getString("password"));
                return m;
            }
        },userName);
        return m;
    }


}
