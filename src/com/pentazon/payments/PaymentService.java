package com.pentazon.payments;

import java.math.BigDecimal;

public interface PaymentService {
    public boolean pay(PaymentCard card, BigDecimal amonut);
}
