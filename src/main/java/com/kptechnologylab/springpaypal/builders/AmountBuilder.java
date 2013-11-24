package com.kptechnologylab.springpaypal.builders;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;

public class AmountBuilder {

    private String currency;
    private String total;
    private Details details;

    public Amount build(){
        Amount amount = new Amount(currency,total);
        amount.setDetails(details);
        return amount;
    }

    public AmountBuilder currency(String currency){
        this.currency = currency;
        return this;
    }

    public AmountBuilder total(String total){
        this.total = total;
        return this;
    }

    public AmountBuilder details(Details details){
        this.details = details;
        return this;
    }

}
