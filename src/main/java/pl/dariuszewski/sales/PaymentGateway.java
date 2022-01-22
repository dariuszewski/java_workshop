package pl.dariuszewski.sales;

import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentDetails registerPayment(String reservationId, BigDecimal total, String customerEmail, String customerLastname);
}