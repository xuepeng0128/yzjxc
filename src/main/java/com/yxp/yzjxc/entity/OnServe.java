package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnServe {
   private  int no ;
   private Date beginServeTime;
   private Department department;
   private Duty  serve;
   private Date endServeTime;

}
