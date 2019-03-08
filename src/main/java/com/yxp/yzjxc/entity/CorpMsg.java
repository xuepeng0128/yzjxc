package com.yxp.yzjxc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *  软件使用公司信息类
 *
 */
@Document(collection = "corpmsg")
@Data
@NoArgsConstructor
public class CorpMsg {
    private String corpName ;
    private String address ;
    private String tel;
    private String linkman;
}
