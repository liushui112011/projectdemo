package com.anna.projectdemo.controller;

import com.anna.projectdemo.bean.Employee;
import com.anna.projectdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuhy
 * @create 2019-07-31 19:16
 **/
@RestController
@RequestMapping("es")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/queryById")
    public Employee queryBuId(String id){
        Employee employee = employeeDao.queryByEmployeeId(id);
        return null;
    }

    @RequestMapping("insert")
    public String insertEmployee(List<Employee> employees){
        employeeDao.insertEmployees(employees);
        return null;
    }

}
