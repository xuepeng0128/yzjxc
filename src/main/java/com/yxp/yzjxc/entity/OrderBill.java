package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document(collection = "orderbill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBill {
    @Id
    private String orderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private Supplier supplier;
    private PaymentAgreement paymentAgreement;
    private double taxRate ;
    private String otherAgreement;
    private String memo;
    private User makeBillMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mi")
    private Date makeTime;
    private List<OrderBillDetail>  details;
}
