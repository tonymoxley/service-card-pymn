package org.arkham.examples.card.pymn.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.arkham.examples.card.pymn.model.request.DecryptReq;
import org.arkham.examples.card.pymn.model.response.DecryptResp;
import org.arkham.examples.card.pymn.model.response.EncryptResp;
import org.arkham.examples.card.pymn.util.EncryptionAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cipher")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EncryptionController {

    private final EncryptionAES encryptionAES;

    @SneakyThrows
    @GetMapping("/encrypt/{value}")
    public ResponseEntity<?> getEncryptValue(@PathVariable final String value) {
        final String encryptField = encryptionAES.encryptField(value);
        final EncryptResp encryptResp = EncryptResp.builder().encryptedValue(encryptField).build();
        return new ResponseEntity<>(encryptResp, HttpStatus.OK);
    }

    @SneakyThrows
    @PutMapping("/decrypt")
    public ResponseEntity<?> getDecryptValue(@RequestBody DecryptReq decryptReq) {
        final String decryptField = encryptionAES.decryptField(decryptReq.getEncryptedValue());
        final DecryptResp decryptResp = DecryptResp.builder().decryptedValue(decryptField).build();
        return new ResponseEntity<>(decryptResp, HttpStatus.OK);
    }

}
