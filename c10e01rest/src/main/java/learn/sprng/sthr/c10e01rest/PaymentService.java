package learn.sprng.sthr.c10e01rest;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(PaymentDetails paymentDetails) {
        if (paymentDetails.getAmount() > 1_000) {
            throw new NotEnoughMoneyException();
        }
        return paymentDetails;
    }
}
