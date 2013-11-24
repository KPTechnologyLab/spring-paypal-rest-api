package com.kptechnologylab.springpaypal.builders;

import com.kptechnologylab.springpaypal.PaymentIntent;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PaymentBuilder {

   private PaymentIntent paymentIntent;
   private Payer payer;
   private List<Transaction> transactions = new ArrayList<Transaction>();

   public Payment build(){
       return new Payment(paymentIntent.toString(),payer, transactions);
   }

    public PaymentBuilder intent(PaymentIntent intent){
        this.paymentIntent = intent;
        return this;
    }

    public PaymentBuilder payer(Payer payer){
        this.payer = payer;
        return this;
    }

    public PaymentBuilder transactions(Transaction...transactions){
        for(Transaction transaction : transactions){
            this.transactions.add(transaction);
        }
        return this;
    }
}
