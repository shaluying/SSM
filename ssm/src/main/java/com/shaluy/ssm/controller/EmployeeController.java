package com.shaluy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.shaluy.ssm.pojo.Employee;
import com.shaluy.ssm.service.EmployeeService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Date:2022/7/11
 * Author:ybc
 * Description:
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 根据id查询员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/employee/initData", method = RequestMethod.POST)
    @ResponseBody
    public boolean initData() {
        boolean okSuccess = employeeService.initData();

        return okSuccess == true ? true : false;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有员工
        List<Employee> employeeList = employeeService.getAllEmployee();

        //将所有员工添加到请求域中
        model.addAttribute("employeeList", employeeList);

        //跳转到employee_list.html
        return "employee_list";
    }

    @RequestMapping("/employee/page/{pageNum}")
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model){
        //获取员工的分页信息
        PageInfo<Employee> pageInfo = employeeService.getEmployeePage(pageNum);

        //将分页数据共享到请求域中
        model.addAttribute("pageInfo", pageInfo);

        //跳转到employee_list.html
        return "employee_list";
    }
}
