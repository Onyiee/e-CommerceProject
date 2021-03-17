package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.exceptions.CheckOutExceptions;

public class ShoppingServiceImpl implements ShoppingService {

    @Override
    public boolean checkOut(Buyer buyer) throws CheckOutExceptions {
     if (isValidCheckOut(buyer)){
     }
        return false;
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
