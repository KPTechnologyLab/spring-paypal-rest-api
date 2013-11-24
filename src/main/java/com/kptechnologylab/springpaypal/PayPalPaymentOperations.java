package com.kptechnologylab.springpaypal;

import com.paypal.api.payments.Capture;
import com.paypal.api.payments.Payment;
import com.paypal.core.rest.PayPalRESTException;

public interface PayPalPaymentOperations {

    Payment create(Payment payment) throws PayPalRESTException;

    Capture capture(String paymentId) throws PayPalRESTException ;

}
