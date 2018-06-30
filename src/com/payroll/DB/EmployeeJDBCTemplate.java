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
        String sql = "insert into employee(id,jodnumber,age,name,sex," +
                "salary,position,department,remark)"+
                "values(?,?,?,?,?,?,?,?,?)";

        datasource.update(sql,e.getId(),e.getJodNumber(),e.getAge(),
                e.getName(),e.getSex(),e.getSalary(),
                e.getPosition(),e.getPosition(),e.getRemark());
        return;
    }


    /**
     * 根据idJod删除表信息
     * */
    @Override
    public void delete(String jodNumber) {
        String sql = "DELETE FROM employee WHERE jodnumber=?";
        datasource.update(sql,new Object[]{jodNumber});
    }

    /***
     * 根据idJod更新职工信息
     */
    @Override
    public void update(Employee e) {
        String sql = "UPDATE employee set sex=?,name=?,age=?,salary=?,position=?," +
                "department=?,remark=? where jodnumber=?";

        datasource.update(sql,new Object[]{e.getSex(),e.getName(),e.getAge(),e.getSalary(),
                e.getPosition(),e.getDepartment(),e.getRemark(),e.getJodNumber()});

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

    /**
     * 查询员工总数
     * */
    @Override
    public int howMany() {
        String sql = "select count(*) from employee";
        Integer temp = datasource.queryForObject(sql,Integer.class);
        return temp;
    }

    @Override
    public List<Employee> find(String jodNumber) {
        String sql = "SELECT * FROM employee WHERE jodNumber LIKE '%"+jodNumber+"%'";
        List<Employee> le = datasource.query(sql,new EmployeeMapper());
        return le;
    }


}
