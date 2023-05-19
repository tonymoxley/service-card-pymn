package org.arkham.examples.card.pymn.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CardPaymentReq implements Serializable {

    private static final long serialVersionUID = -2380605235454318834L;

    @NotEmpty
    private String buc;

    @NotEmpty
    private String contract;

    @NotNull
    private BigDecimal paymentAmount;

    @Builder.Default
    private LocalDateTime paymentDate = LocalDateTime.now();

}
