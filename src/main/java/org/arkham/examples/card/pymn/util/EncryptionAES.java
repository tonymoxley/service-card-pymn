package org.arkham.examples.card.pymn.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EncryptionAES {

    @Value("${card-payment.cipher}")
    private String algorithm;

    private final IvParameterSpec ivParameterSpec;

    private final SecretKeySpec secretKeySpec;

    public String encryptField(final String value) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        log.info("encrypting field..... {}", value);
        final Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        final byte[] encryptedText = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }

    public String decryptField(final String encryptedValue) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        log.info("decrypting vale...... {}", encryptedValue);
        final Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        final byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(plainText);
    }

}
