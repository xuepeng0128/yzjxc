package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
   private String  userId  ; // 账号
    @Indexed
   private String  userName  ; // 用户名称
   private String  passWord ; // 登录密码
   private boolean isManager ; // 是否为管理员
   private String  memo  ; // 备注
   private Employee employee ;
}
