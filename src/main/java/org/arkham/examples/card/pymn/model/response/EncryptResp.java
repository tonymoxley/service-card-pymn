package org.arkham.examples.card.pymn.model.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class EncryptResp implements Serializable {

    private static final long serialVersionUID = -3573924495853388901L;

    private String encryptedValue;

    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();

}
