package org.arkham.examples.card.pymn.model.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class DecryptResp implements Serializable {

    private static final long serialVersionUID = -1905470772503908043L;

    private String decryptedValue;

    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();

}
