package org.arkham.examples.card.pymn.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arkham.examples.card.pymn.mapper.CardPaymentMapper;
import org.arkham.examples.card.pymn.model.entity.CardPayment;
import org.arkham.examples.card.pymn.model.response.CardPaymentResp;
import org.arkham.examples.card.pymn.repository.CardPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CardPaymentServiceImp implements CardPaymentService {

    private final CardPaymentRepository paymentRepository;

    private final CardPaymentMapper PAYMENT_MAPPER = CardPaymentMapper.INSTANCE_MAPPER;

    /**
     *
     * @param buc
     * @return
     */
    @Override
    public List<CardPaymentResp> getCardPaymentsByBuc(final String buc) {
        final List<CardPayment> cardPayments = this.paymentRepository.findByBuc(buc);
        final List<CardPaymentResp> paymentsResp = new ArrayList<>();
        if ( !cardPayments.isEmpty() ) {
            for (CardPayment cardPayment :
                    cardPayments) {
                paymentsResp.add(PAYMENT_MAPPER.cardPaymentToCardPaymentResp(cardPayment));
            }
            log.info("card payments records were found: {}", paymentsResp.size());
        }
        return paymentsResp;
    }

    @Override
    public Optional<CardPaymentResp> saveCardPayment(CardPayment cardPayment) {
        final Optional<CardPayment> savedPayment = Optional.of(paymentRepository.save(cardPayment));
        if ( savedPayment.isPresent() ) {
            return Optional.of(
                    PAYMENT_MAPPER.cardPaymentToCardPaymentResp(savedPayment.get()));
        }
        return Optional.empty();
    }

}
