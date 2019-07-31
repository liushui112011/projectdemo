package com.anna.projectdemo.dao;

import com.anna.projectdemo.bean.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuhy
 * @create 2019-07-31 19:01
 **/
@Component
public interface EmployeeDao extends ElasticsearchRepository<Employee,String> {

    //通过id查询员工
    Employee queryByEmployeeId(String id);

    void insertEmployees(List<Employee> employees);
}
