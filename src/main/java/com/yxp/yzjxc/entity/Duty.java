package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "duty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duty {
    @Id
    private String dutyId;
    private String dutyName;
    private String memo;
}
