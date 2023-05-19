package org.arkham.examples.card.pymn.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({
        "id", "buc", "contract", "paymentAmount", "paymentDate"})
public class CardPaymentResp implements Serializable {

    private static final long serialVersionUID = -5273248215077921555L;

    private String id;

    private String buc;

    private String contract;

    private BigDecimal paymentAmount;

    private LocalDateTime paymentDate;

}
