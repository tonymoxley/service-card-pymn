package org.arkham.examples.card.pymn.mapper;

import org.arkham.examples.card.pymn.model.entity.CardPayment;
import org.arkham.examples.card.pymn.model.request.CardPaymentReq;
import org.arkham.examples.card.pymn.model.response.CardPaymentResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CardPaymentMapper {

     CardPaymentMapper INSTANCE_MAPPER = Mappers.getMapper(CardPaymentMapper.class);

     CardPaymentResp cardPaymentToCardPaymentResp(CardPayment cardPayment);

     CardPayment paymentRequestToCardPayment(CardPaymentReq paymentReq);

}
