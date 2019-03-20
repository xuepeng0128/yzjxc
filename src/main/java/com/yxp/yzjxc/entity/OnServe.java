package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnServe {
   private  int no ;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date beginServeTime;
   private Department department;
   private Duty  serve;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date endServeTime;

}
