package com.kptechnologylab.springpaypal.builders;

import com.paypal.api.payments.Address;

public class AddressBuilder {

    private String line1;
    private String line2;
    private String city;
    private String countryCode;
    private String postalCode;
    private String state;
    private String phone;

    public Address build(){
        Address address = new Address(this.line1, this.city, this.countryCode, this.state);
        address.setLine2(line2);
        address.setPostalCode(postalCode);
        address.setPhone(phone);
        return address;
    }

    public AddressBuilder line1(String line1){
        this.line1 = line1;
        return this;
    }

    public AddressBuilder line2(String line2){
        this.line2 = line2;
        return this;
    }

    public AddressBuilder city(String city){
        this.city = city;
        return this;
    }

    public AddressBuilder countryCode(String countryCode){
        this.countryCode = countryCode;
        return this;
    }

    public AddressBuilder postalCode(String postalCode){
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder state(String state){
        this.state = state;
        return this;
    }

    public AddressBuilder phone(String phone){
        this.phone = phone;
        return this;
    }
}
