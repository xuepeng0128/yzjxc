package com.yxp.yzjxc.service.sys;
import com.yxp.yzjxc.entity.dic;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface EmployeeService {

    public boolean insertEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public Page<Employee> employeeList(String employeeId, String employeeName, Date birthdayBegin, Date birthdayEnd ,
                                        int sexId, int eduId , String pageNo,String pageSize);
}
