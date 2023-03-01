package com.shaluy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shaluy.ssm.mapper.EmployeeMapper;
import com.shaluy.ssm.pojo.Employee;
import com.shaluy.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public boolean initData() {
        employeeMapper.deleteAllEmployee();

        Employee employee = new Employee(null,"张三",21,"男","546@456.com");
        try {
            for (int i = 0; i < 30; i++) {
                boolean okInit = employeeMapper.insertEmployee(employee);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeMapper.selectAllEmployee();

        return employeeList;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);//参数一：第几页 参数二：每页条数

        //查询所有的员工信息
        List<Employee> employeeList = employeeMapper.selectAllEmployee();

        //获取分页相关数据
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,5);//参数一：查询结果 参数二；导航数量

        return pageInfo;
    }
}
