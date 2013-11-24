package com.kptechnologylab.springpaypal.builders;

import com.paypal.api.payments.Address;
import com.paypal.api.payments.CreditCard;

public class CreditCardBuilder {
    
    private String number;
    private String type;
    private int expireMonth;
    private int expireYear;
    private String cvv2;
    private String firstName;
    private String lastName;
    private Address billingAddress;

    public CreditCard build(){
        CreditCard creditCard = new CreditCard(number,type, expireMonth, expireYear);
        creditCard.setCvv2(cvv2);
        creditCard.setFirstName(firstName);
        creditCard.setLastName(lastName);
        creditCard.setBillingAddress(billingAddress);
        return creditCard;
    }

    public CreditCardBuilder number(String number){
        this.number = number;
        return this;
    }

    public CreditCardBuilder type(String type){
        this.type = type;
        return this;
    }

    public CreditCardBuilder expireMonth(int expireMonth){
        this.expireMonth = expireMonth;
        return this;
    }

    public CreditCardBuilder expireYear(int expireYear){
        this.expireYear = expireYear;
        return this;
    }

    public CreditCardBuilder cvv2(String cvv2){
        this.cvv2 = cvv2;
        return this;
    }

    public CreditCardBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CreditCardBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CreditCardBuilder billingAddress(Address billingAddress){
        this.billingAddress =  billingAddress;
        return this;
    }
}
