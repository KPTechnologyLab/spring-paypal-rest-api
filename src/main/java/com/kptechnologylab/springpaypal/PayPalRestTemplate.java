package com.kptechnologylab.springpaypal;

import com.paypal.api.payments.*;
import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.kptechnologylab.springpaypal.builders.Builders.amountBuilder;

public class PayPalRestTemplate implements PayPalPaymentOperations {

    private OAuthTokenCredential authTokenCredential;

    public PayPalRestTemplate(){

    }

    public PayPalRestTemplate(String oAuthClientId, String oAuthClientSecret) {
        this(oAuthClientId,oAuthClientSecret, new HashMap<String, String>());
    }


    public PayPalRestTemplate(String oAuthClientId, String oAuthClientSecret, Map<String, String> config) {
        Assert.notNull(oAuthClientId, "'oAuthClientId' cannot be null");
        Assert.notNull(oAuthClientSecret,"'oAuthClientSecret' cannot be null");
        this.authTokenCredential = new OAuthTokenCredential(oAuthClientId, oAuthClientSecret,config);
    }

    @Override
    public Payment create(Payment payment) throws PayPalRESTException {
        String accessToken = authTokenCredential.getAccessToken();
        return payment.create(accessToken);
    }

    @Override
    public Capture capture(String paymentId) throws PayPalRESTException {
        String accessToken = authTokenCredential.getAccessToken();
        Payment payment = Payment.get(accessToken,paymentId);
        Authorization authorization = payment.getTransactions().get(0).getRelatedResources()
                .get(0).getAuthorization();

        Amount amount = amountBuilder()
                .total(authorization.getAmount().getTotal())
                .currency(authorization.getAmount().getCurrency())
                .build();

        Capture capture = new Capture();
        capture.setAmount(amount);
        capture.setIsFinalCapture(true);

        return authorization.capture(accessToken, capture);
    }
}
