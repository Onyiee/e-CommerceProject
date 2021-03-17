package com.pentazon.product;

import com.pentazon.customers.Address;
import com.pentazon.customers.Buyer;
import com.pentazon.customers.Customer;
import com.pentazon.exceptions.CheckOutExceptions;
import com.pentazon.payments.PaymentCard;
import com.pentazon.shopping.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

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
        dozieCart.setPaymentCard(Dozie.getCards().get(0));
        Address deliveryAddress = new Address();
        deliveryAddress.setHouseNumber(1);
        deliveryAddress.setStreet("Aso Rock street");
        Dozie.getAddresses().add(deliveryAddress);
        Dozie.setCart(dozieCart);


    }

    @AfterEach
    void tearDown() {
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
    void checkOutWithNoPaymentCard(){
        Dozie.setCards(Collections.emptyList());
        assertThrows(CheckOutExceptions.class, ()->shoppingService.checkOut(Dozie));
    }

    @Test
    void checkOut(){
        try{
            Map<String, Item> cartItems= Dozie.getCart().getCartItems();
            Address deliveryAddress = Dozie.getCart().getDeliveryAddress();
            Order dozieOrder = shoppingService.checkOut(Dozie);
            assertEquals(cartItems, dozieOrder.getOrderItems());
            assertNotNull(dozieOrder);
            assertTrue(dozieOrder.isPaid());
            assertNull(Dozie.getCart());
        }catch (CheckOutExceptions checkOutExceptions){
            checkOutExceptions.printStackTrace();
        }
    }

    @Test
    void checkOutWithExpiredPaymentCard(){
        try{
            Address deliveryAddress = Dozie.getCart().getDeliveryAddress();
            Map<String, Item> cartItems = Dozie.getCart().getCartItems();
            Dozie.getCart().getPaymentCard().setExpiry(LocalDate.now());
            Order dozieOrder = shoppingService.checkOut(Dozie);
            assertNotNull(dozieOrder);
            assertFalse(dozieOrder.isPaid());
            assertEquals(deliveryAddress, dozieOrder.getDeliveryAddress());
            assertNotNull(Dozie.getCart());
        }catch (CheckOutExceptions checkOutExceptions){
            checkOutExceptions.printStackTrace();
        }
    }



}