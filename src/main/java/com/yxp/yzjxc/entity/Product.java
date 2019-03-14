package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
   private String  productId;
    @Indexed
   private String  productName;
   private String  style;
   private ProductClass productClass;
   private Unit unitMain;
   private Unit unitAssist;
   private double unitMainToAssist;
   private Blank blank;
   private String qrCode;
   private double refCase;
   private double refDiscount;
   private double refPrice;
   private double earlyStage;
   private String memo;
}
