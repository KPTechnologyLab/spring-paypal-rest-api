Spring PayPal REST API
======================

Spring PayPal REST API integration. 

Adding the dependency to the project
====================================

- **Compatible with PayPal REST API version**
```xml
<dependency>
    <groupId>com.paypal.sdk</groupId>
    <artifactId>rest-api-sdk</artifactId>
    <version>0.7.1</version>
</dependency>
```

- **Building the project**
```
mvn clean install
```

- **Add the following dependency to your project.**
```
<dependency>
    <groupId>com.kptechnologylab</groupId>
    <artifactId>spring-paypal-rest-api</artifactId>
    <version>1.0.0.BUILD-SNAPSHOT</version>
</dependency>
```

Examples
========
- **Configuring PayPalRestTemplate**
```xml
<bean id="payPalRestTemplate" class="com.kptechnologylab.springpaypal.PayPalRestTemplate">
       <constructor-arg index="0" value="EBWKjlELKMYqRNQ6sYvFo64FtaRLRR5BdHEESmha49TM"/>
       <constructor-arg index="1" value="EO422dn3gQLgDbuwqTjzrFgFtaRLRR5BdHEESmha49TM"/>
       <constructor-arg index="2">
           <util:map>
               <entry key="mode" value="sandbox"/>
           </util:map>
       </constructor-arg>
   </bean>
```

- **Creating a payment**
```java
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

  Payment payment  = paymentBuilder().intent(authorize).payer(payer).transactions(transaction).build();
  
  Payment paymentCreated = payPalRestTemplate.create(payment);
```

- **Capturing the payment**
```java
    Capture capture = payPalRestTemplate.capture(paymentCreated.getId());
```




