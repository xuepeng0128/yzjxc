package com.yxp.yzjxc.repo.sys;

import com.yxp.yzjxc.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
// String employeeId, String employeeName, Date birthdayBegin, Date birthdayEnd , int sexId, int eduId , Pageable pageable
@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String> {
   // public Page<Employee> findAllByEmployeeIdLikeAndEmployNameLikeAndBirthdayBetweenAndSex_SexIdAndEducationLevel_EduId
}
