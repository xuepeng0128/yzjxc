package com.yxp.yzjxc.serviceimpl.sys;

import com.yxp.yzjxc.entity.Employee;
import com.yxp.yzjxc.repo.sys.EmployeeRepo;
import com.yxp.yzjxc.service.sys.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Date;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    @Override
    public boolean insertEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public Page<Employee> employeeList(String employeeId, String employeeName, Date birthdayBegin,
                                       Date birthdayEnd, int sexId, int eduId, String pageNo, String pageSize) {
       Pageable pageable= new PageRequest(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
        Criteria criteria = Criteria.where("employeeId").regex("/*." + employeeId +".*/");


        repo.findAll(

                pageable);

        return null;
    }
}
