package com.pentazon.product;

import com.pentazon.customers.Buyer;
import com.pentazon.customers.Customer;
import com.pentazon.exceptions.CheckOutExceptions;
import com.pentazon.payments.PaymentCard;
import com.pentazon.shopping.Cart;
import com.pentazon.shopping.ShoppingService;
import com.pentazon.shopping.ShoppingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceImplTest {
    private ShoppingService shoppingService;
    private Buyer Dozie;

    @BeforeEach
    void setUp() {
        shoppingService = new ShoppingServiceImpl();
        ProductDB products = new ProductDB();
        Dozie = new Buyer();
        PaymentCard fbnVisa = new PaymentCard("123456","Don Dozie",
                LocalDate.of(2025,1,29));
        Dozie.getCards().add(fbnVisa);
        Cart dozieCart = new Cart();
        dozieCart.addToCart(products.getMockProducts().get("AD001"),5);
        Dozie.setCart(dozieCart);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkOut() {
    }

    @Test
    void checkOutWithNullBuyer(){
        assertThrows(CheckOutExceptions.class, ()->shoppingService.checkOut(null));
    }

    @Test
    void checkOutWithNullCart(){
        Dozie.setCart(null);
        assertThrows(CheckOutExceptions.class, ()->shoppingService.checkOut(Dozie));
    }

    @Test
    void checkOutWithEmptyCart(){
        Dozie.setCart(new Cart());
        assertThrows(CheckOutExceptions.class, ()->shoppingService.checkOut(Dozie));
    }

    @Test
    void checkOutWithNullPaymentCard(){
        Dozie.setCart(null);
        assertThrows(CheckOutExceptions.class, ()->shoppingService.checkOut(Dozie));
    }

    @Test
    void checkOutWithPaymentCard(){
        Dozie.setCards(Collections.emptyList());
        assertThrows(CheckOutExceptions.class, ()->shoppingService.checkOut(Dozie));
    }
}