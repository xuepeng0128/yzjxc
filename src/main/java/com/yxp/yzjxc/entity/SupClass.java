package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supclass")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupClass {
    @Id
  private String  supClassId  ;
  private String   supClassName  ;
  private String   memo ;
  private SupClass subSupClass  ;

}
