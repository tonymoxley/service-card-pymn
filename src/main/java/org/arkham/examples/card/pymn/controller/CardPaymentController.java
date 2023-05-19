package org.arkham.examples.card.pymn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.arkham.examples.card.pymn.mapper.CardPaymentMapper;
import org.arkham.examples.card.pymn.model.request.CardPaymentReq;
import org.arkham.examples.card.pymn.model.response.CardPaymentResp;
import org.arkham.examples.card.pymn.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Ing. Jose Antonio Hernandez
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/card/payment")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CardPaymentController {

    private final CardPaymentService paymentService;

    private final CardPaymentMapper PAYMENT_MAPPER = CardPaymentMapper.INSTANCE_MAPPER;

    @PostMapping
    public ResponseEntity<CardPaymentResp> saveCardPayment(
            @RequestBody @Valid final CardPaymentReq paymentReq) {
        log.info("saving payment of user: {}, date: {}", paymentReq.getBuc(), paymentReq.getPaymentDate());
        final Optional<CardPaymentResp> cardPayment =
                this.paymentService.saveCardPayment(PAYMENT_MAPPER.paymentRequestToCardPayment(paymentReq));
        return new ResponseEntity<>(cardPayment.get(), HttpStatus.CREATED);
    }

    @GetMapping("/{buc}")
    public ResponseEntity<List<CardPaymentResp>> getCardPayments(@PathVariable final String buc) {
        final List<CardPaymentResp> payments = this.paymentService.getCardPaymentsByBuc(buc);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

}
