package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
    @Id
   private String  unitId;
   private String  unitName;
   private String  memo;
}
