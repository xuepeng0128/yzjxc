package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *  软件使用公司信息类
 *
 */
@Document(collection = "corpmsg")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorpMsg {
    @Id
    private String corpName ;
    private String address ;
    private String tel;
    private String linkman;
}
