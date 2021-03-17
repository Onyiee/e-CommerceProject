package com.pentazon.payments;

import java.time.LocalDate;
import java.util.Date;

public class PaymentCard {
    private String cardNumber;
    private String name;
    private LocalDate expiry;
    private Date issued;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public PaymentCard(String number, String nameOnCard, LocalDate expiry){
        cardNumber = number;
        name = nameOnCard;
        this.expiry = expiry;
    }
}
