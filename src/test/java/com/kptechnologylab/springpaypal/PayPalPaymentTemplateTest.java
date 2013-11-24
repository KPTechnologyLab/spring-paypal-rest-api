package com.kptechnologylab.springpaypal;

import com.paypal.api.payments.*;
import com.paypal.core.rest.PayPalRESTException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static com.kptechnologylab.springpaypal.PaymentIntent.authorize;
import static com.kptechnologylab.springpaypal.PaymentMethod.credit_card;
import static com.kptechnologylab.springpaypal.builders.Builders.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:paymentTemplateTest.xml")
public class PayPalPaymentTemplateTest {

    @Resource
    private PayPalPaymentTemplate payPalPaymentTemplate;

    @Test
    public void shouldCreatePayment() throws PayPalRESTException {
        //Given
        Payment payment = createPayment();
        //When
        Payment paymentCreated = payPalPaymentTemplate.create(payment);
        //Then
        assertThat(paymentCreated, is(notNullValue()));
        assertThat(paymentCreated.getState(), is(equalToIgnoringCase("approved")));
    }

    @Test
    public void shouldCapturePayment() throws PayPalRESTException {
        //Given
        Payment paymentCreated = payPalPaymentTemplate.create(createPayment());
        //When
        Capture capture = payPalPaymentTemplate.capture(paymentCreated.getId());
        //Then
        assertThat(capture, is(notNullValue()));
        assertThat(capture.getState(), is(equalToIgnoringCase("completed")));
    }

    private Payment createPayment(){
        CreditCard creditCard = creditCardBuilder()
                .type("visa").number("4446283280247004")
                .expireMonth(11).expireYear(2018)
                .firstName("Joe").lastName("Shopper")
                .build();

        Payer payer = payerBuilder()
                .paymentMethod(credit_card)
                .fundingInstruments(fundingInstrumentBuilder().creditCard(creditCard).build())
                .build();

        Transaction transaction = transactionBuilder()
                .amount(amountBuilder().currency("USD").total("10").build()).build();

        return paymentBuilder().intent(authorize).payer(payer).transactions(transaction).build();
    }

}
