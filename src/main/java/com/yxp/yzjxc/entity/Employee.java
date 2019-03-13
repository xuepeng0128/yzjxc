package com.yxp.yzjxc.entity;


import com.yxp.yzjxc.entity.EducationLevel;
import com.yxp.yzjxc.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String employeeId;
    @Indexed
    private String employeeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   birthday;
    private String cardId;
    private String tel ;
    private String wxcode;
    private String qqcode;
    private Sex sex;
    private String address;
    private EducationLevel educationLevel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime; // 入职时间
    private List<Map<String,Object>> onDutyHis ; // 就职历史
    private int dutyState; // 当前状态(1.在职，2.停职，3.离职)
}
