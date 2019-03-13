package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
  @Id
  private String  supId ;
  private String   supName;
  private String   pinyin;
  private SupClass  supClass;
  private String  linkMan;
  private String  linkTel1 ;
  private String  linkTel2;
  private String  accountNo;
  private String  taxNo;
  private String  address;
  private Blank  blank;
  private String   memo ;

}
