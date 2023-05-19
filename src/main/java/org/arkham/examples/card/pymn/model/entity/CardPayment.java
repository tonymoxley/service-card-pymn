package org.arkham.examples.card.pymn.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "card_payment")
public class CardPayment {

    @Id
    @Field("_id")
    private String id;

    private String buc;

    private String contract;

    @Field("payment_amount")
    private BigDecimal paymentAmount;

    @Field("payment_date")
    private LocalDateTime paymentDate;

}
