package org.arkham.examples.card.pymn.service;

import org.arkham.examples.card.pymn.model.entity.CardPayment;
import org.arkham.examples.card.pymn.model.response.CardPaymentResp;

import java.util.List;
import java.util.Optional;

public interface CardPaymentService {

    List<CardPaymentResp> getCardPaymentsByBuc(final String buc);

    Optional<CardPaymentResp> saveCardPayment(final CardPayment cardPayment);

}
