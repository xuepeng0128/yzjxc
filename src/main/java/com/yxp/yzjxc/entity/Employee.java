package com.yxp.yzjxc.entity;


import com.yxp.yzjxc.entity.EducationLevel;
import com.yxp.yzjxc.entity.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    private String employeeId;
    @Indexed
    private String employeeName;
    private Date   birthday;
    private String cardId;
    private Sex sex;
    private String address;
    private EducationLevel educationLevel;
    private Date entryTime; // 入职时间
    private int dutyState; // 当前状态(1.在职，2.停职，3.离职)
}
