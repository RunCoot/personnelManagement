package com.payroll.DB;


import com.payroll.company.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

//连接数据库
public class EmployeeJDBCTemplate implements IDBAcion {
    private JdbcTemplate datasource ;
    public void setDatasource(DataSource datasource) {
        this.datasource = new JdbcTemplate(datasource);
    }


    /**
     * 根据员工对象创建一条员工信息
     * */
    @Override
    public void create(Employee e) {
        String sql = "insert into employee(id,jodnumber,name,sex," +
                "salary,position,department,remark)"+
                "values(?,?,?,?,?,?,?,?)";

        datasource.update(sql,e.getId(),e.getJodNumber(),
                e.getName(),e.getSex(),e.getSalary(),
                e.getPosition(),e.getPosition(),e.getRemark());
        return;
    }


    /**
     * 根据idJod删除表信息
     * */
    @Override
    public void delete(Integer idJod) {
        String sql = "DELETE FROM employee WHERE jobnumber=?";
        datasource.update(sql,idJod);
    }

    /***
     * 根据idJod更新职工信息
     */
    @Override
    public void update(Employee e) {
        String sql = "UPDATE employee set name=?,sex=?,salary=?,position=?," +
                "department=?,remark=? where jobnumber=?";
        datasource.update(sql,e.getName(),e.getSex(),e.getSalary(),
                e.getPosition(),e.getDepartment(),e.getRemark());
    }


    /**
     * 返回所有职工对象
     * */
    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> le = datasource.query(sql,new EmployeeMapper());
        return le;
    }

}
