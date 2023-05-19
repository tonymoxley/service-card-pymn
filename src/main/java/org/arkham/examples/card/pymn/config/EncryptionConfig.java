package org.arkham.examples.card.pymn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
public class EncryptionConfig {

    @Bean
    public IvParameterSpec ivParameterSpec(@Value("${card-payment.vector}") final String initVector) {
        final IvParameterSpec ivParameterSpec =
                new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
        return ivParameterSpec;
    }

    @Bean
    public SecretKeySpec secretKeySpec(@Value("${card-payment.key}") final String key) {
        final SecretKeySpec secretKeySpec =
                new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        return secretKeySpec;
    }

}
