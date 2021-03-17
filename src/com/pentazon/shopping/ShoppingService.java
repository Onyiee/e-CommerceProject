package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.exceptions.CheckOutExceptions;

public interface ShoppingService {
    public boolean checkOut(Buyer buyer) throws CheckOutExceptions;





}
