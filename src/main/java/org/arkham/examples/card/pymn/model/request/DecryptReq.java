package org.arkham.examples.card.pymn.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DecryptReq implements Serializable {

    private static final long serialVersionUID = 4188742267399035182L;

    private String encryptedValue;

}
