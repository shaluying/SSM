package com.shaluy.ssm.mapper;

import com.shaluy.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 新增一个员工
     * @return
     */
    boolean insertEmployee(Employee employee);

    /**
     * 删除所有与员工
     */
    void deleteAllEmployee();

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> selectAllEmployee();
}
