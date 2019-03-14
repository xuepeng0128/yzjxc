package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentmethod")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {
     @Id
     private int paymentMethodId;
     private String paymentMethodName;
     private String memo;

}
