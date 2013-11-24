package com.kptechnologylab.springpaypal.builders;

import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.FundingInstrument;

public class FundingInstrumentBuilder {

    private CreditCard creditCard;

    public FundingInstrument build(){
        FundingInstrument fundingInstrument =  new FundingInstrument();
        fundingInstrument.setCreditCard(creditCard);
        return fundingInstrument;
    }

    public FundingInstrumentBuilder creditCard(CreditCard creditCard){
        this.creditCard = creditCard;
        return this;
    }

}
