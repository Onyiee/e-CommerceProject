package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.exceptions.CheckOutExceptions;
import com.pentazon.payments.PayStack;
import com.pentazon.payments.PaymentCard;
import com.pentazon.payments.PaymentService;
import com.pentazon.payments.PaymentServiceImpl;

import java.time.LocalDate;

public class ShoppingServiceImpl implements ShoppingService {
    private PaymentService paymentService;
    public ShoppingServiceImpl(){
        this.paymentService = new PayStack();
    }

    @Override
    public Order checkOut(Buyer buyer) throws CheckOutExceptions {
        this.isValidCheckOut(buyer);
        Order order = new Order();
        Cart buyerCart = buyer.getCart();
        boolean result = paymentService.pay(buyerCart.getPaymentCard(), buyerCart.calculateCartTotal());
       if (result ){
           order.setOrderItems(buyer.getCart().getCartItems());
           order.setPaid(result);
           order.setOrderDate(LocalDate.now());
           order.setOrderTotal(buyerCart.calculateCartTotal());
           order.setDeliveryAddress(buyerCart.getDeliveryAddress());
           buyer.setCart(null);
       }
        return order;
    }


    private boolean isValidCheckOut(Buyer buyer) throws CheckOutExceptions{
        if (buyer == null){
            throw new CheckOutExceptions("No buyer found at check out");
        }
        if (buyer.getCart()==null){
            throw new CheckOutExceptions("No cart found at check out");
        }
        if (buyer.getCart().getCartItems().isEmpty()){
            throw new CheckOutExceptions("Cart is empty");
        }
        if (buyer.getCards()==null || buyer.getCards().isEmpty()){
            throw new CheckOutExceptions("No payment cards found at checkout");
        }
        return true;
    }




}
