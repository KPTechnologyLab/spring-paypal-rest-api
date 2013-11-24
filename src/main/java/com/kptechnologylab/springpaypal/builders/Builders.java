package com.kptechnologylab.springpaypal.builders;

public class Builders {

    public static AddressBuilder addressBuilder(){
        return new AddressBuilder();
    }

    public static AmountBuilder amountBuilder(){
        return new AmountBuilder();
    }

    public static CreditCardBuilder creditCardBuilder(){
        return new CreditCardBuilder();
    }

    public static FundingInstrumentBuilder fundingInstrumentBuilder(){
        return new FundingInstrumentBuilder();
    }

    public static PayerBuilder payerBuilder(){
        return new PayerBuilder();
    }

    public static PayerInfoBuilder payerInfoBuilder(){
        return new PayerInfoBuilder();
    }

    public static PaymentBuilder paymentBuilder(){
        return new PaymentBuilder();
    }

    public static TransactionBuilder transactionBuilder(){
        return new TransactionBuilder();
    }
}
