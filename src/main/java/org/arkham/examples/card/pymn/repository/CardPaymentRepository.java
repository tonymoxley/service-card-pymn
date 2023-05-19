package org.arkham.examples.card.pymn.repository;

import org.arkham.examples.card.pymn.model.entity.CardPayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ing. Jose Antonio hernandez
 * @version 1.0
 */
@Repository
public interface CardPaymentRepository extends MongoRepository<CardPayment, String> {

    /**
     *
     * @param buc
     * @return
     */
    List<CardPayment> findByBuc(final String buc);

}
