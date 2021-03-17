package com.pentazon.shopping;

import com.pentazon.customers.Address;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class Order {
    private String orderId;
    private Map<String, Item> orderItems;
    private BigDecimal orderTotal;
    private LocalDate delivery;
    private LocalDate deliveryDate;
    private LocalDate orderDate;
    private Address deliveryAddress;
    private boolean isPaid;

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getOrderId(){
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<String, Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<String, Item> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public LocalDate getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDate delivery) {
        this.delivery = delivery;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
