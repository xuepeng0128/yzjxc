package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blank")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blank {
    @Id
   private String  blankId;
   private String  blankName;
   private String  memo;
}
