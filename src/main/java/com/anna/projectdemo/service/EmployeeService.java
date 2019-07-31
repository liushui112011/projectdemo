package com.anna.projectdemo.service;/**
 * Created by ${User} on 2019/8/1.
 */

import com.anna.projectdemo.bean.Employee;

import java.util.List;

/**
 * @author 刘洪洋
 * @create 2019-08-01 上午12:13
 * @desc Service接口层
 **/
public interface EmployeeService {
    Employee queryByEmployeeId(String id);

    void insertEmployees(List<Employee> employees);
}
