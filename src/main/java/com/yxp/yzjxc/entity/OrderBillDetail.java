package com.yxp.yzjxc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderBillDetail  {
    private int no;
    private Product product;
    private double num;
    private double price;
    private String detailMemo;
}
