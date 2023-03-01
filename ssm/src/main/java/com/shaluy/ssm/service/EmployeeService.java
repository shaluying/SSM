package com.shaluy.ssm.service;

import com.github.pagehelper.PageInfo;
import com.shaluy.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 初始化员工数据
     * @return
     */
    boolean initData();

    /**
     * 查询所有的员工
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum 第几页
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
