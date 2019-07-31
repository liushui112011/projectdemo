package com.anna.projectdemo.service.impl;/**
 * Created by ${User} on 2019/8/1.
 */

import com.anna.projectdemo.bean.Employee;
import com.anna.projectdemo.dao.EmployeeRepository;
import com.anna.projectdemo.service.EmployeeService;
import org.apache.lucene.util.CollectionUtil;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 刘洪洋
 * @create 2019-08-01 上午12:17
 * @desc
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public Employee queryByEmployeeId(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.get();

    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        if (CollectionUtils.isEmpty(employees)) {
            return;
        }
        ArrayList<IndexQuery> indexQueries = new ArrayList<>(employees.size());
        IndexQuery indexQuery = null;
        for (Employee employee :
                employees) {
            indexQuery = new IndexQuery();
            indexQuery.setObject(employee);
            indexQueries.add(indexQuery);
        }
        elasticsearchTemplate.bulkIndex(indexQueries);
    }
}
