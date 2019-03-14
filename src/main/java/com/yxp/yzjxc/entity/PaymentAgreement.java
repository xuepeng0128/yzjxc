package com.yxp.yzjxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentagreement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAgreement {
    @Id
    private int paymentAgreementId;
    private String paymentAgreementName;
    private String memo;


}
