package com.yxp.yzjxc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sex")
@Data
@NoArgsConstructor
public class Sex {
    @Id
    private int sexId;
    private String sexName;
}
