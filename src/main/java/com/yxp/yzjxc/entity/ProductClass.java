package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productclass")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductClass {
    @Id
    private String productClassId;
    private String productClassName;
    private ProductClass subProductClass;
}
