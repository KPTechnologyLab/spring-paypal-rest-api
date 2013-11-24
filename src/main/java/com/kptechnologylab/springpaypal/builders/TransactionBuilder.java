package com.kptechnologylab.springpaypal.builders;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Transaction;

public class TransactionBuilder {

    private Amount amount;
    private String description;

    public Transaction build(){
        Transaction transaction = new Transaction(amount);
        transaction.setDescription(description);
        return transaction;
    }

    public TransactionBuilder amount(Amount amount){
        this.amount = amount;
        return this;
    }

    public TransactionBuilder description(String description){
        this.description = description;
        return this;
    }
}
