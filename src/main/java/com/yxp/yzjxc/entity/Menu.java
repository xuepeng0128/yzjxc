package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
   private String menuId; // 菜单编号
   private String  menuName ; // 菜单名称
   private Menu  subMenu ; // 上级菜单编号
   private String  url ; // 链接地址
   private String  powers; // 权限
}
