package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    private String depId ;
    private String depName;
    private List<Department> subDep;
    private List<Duty> dutys;
}
