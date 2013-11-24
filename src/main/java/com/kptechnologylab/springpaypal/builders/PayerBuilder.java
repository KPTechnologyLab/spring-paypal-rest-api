package com.kptechnologylab.springpaypal.builders;

import com.kptechnologylab.springpaypal.PaymentMethod;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;

import java.util.ArrayList;
import java.util.List;

public class PayerBuilder {

    private PaymentMethod paymentMethod;
    private List<FundingInstrument> fundingInstruments = new ArrayList<FundingInstrument>();
    private PayerInfo payerInfo;

    public Payer build(){
        Payer payer = new Payer(this.paymentMethod.toString());
        payer.setPayerInfo(payerInfo);
        payer.setFundingInstruments(fundingInstruments);
        return payer;
    }

    public PayerBuilder paymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
        return this;
    }

    public PayerBuilder fundingInstruments(FundingInstrument...fundingInstruments){
      for(FundingInstrument instrument : fundingInstruments){
          this.fundingInstruments.add(instrument);
      }
      return this;
    }

    public PayerBuilder payerInfo(PayerInfo payerInfo){
        this.payerInfo = payerInfo;
        return this;
    }
}
