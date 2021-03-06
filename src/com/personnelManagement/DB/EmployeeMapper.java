package com.personnelManagement.DB;

import com.personnelManagement.company.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee e = new Employee();
        e.setId(resultSet.getString("id"));
        e.setJodNumber(resultSet.getString("jodNumber"));
        e.setAge(resultSet.getInt("age"));
        e.setName(resultSet.getString("name"));
        e.setSex(resultSet.getString("sex"));
        e.setDepartment(resultSet.getString("department"));
        e.setPosition(resultSet.getString("position"));
        e.setRemark(resultSet.getString("remark"));
        e.setSalary(resultSet.getDouble("salary"));
        return e;
    }
}
