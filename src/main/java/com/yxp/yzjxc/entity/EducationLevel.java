package com.yxp.yzjxc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "educationlevel")
@Data
@NoArgsConstructor
public class EducationLevel {
    @Id
    private int eduId;
    private String eduName;
    private String memo;
}
