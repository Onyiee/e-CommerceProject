package com.pentazon.shopping;

import com.pentazon.exceptions.ProductException;
import com.pentazon.product.Product;
import com.pentazon.product.ProductService;
import com.pentazon.product.ProductServiceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Cart {
    private Map<String, CartItem> cartItems;
    private ProductService productService;
    private Logger logger = Logger.getLogger(Cart.class.getName());
    private BigDecimal total = BigDecimal.ZERO;

    public Cart(){
        productService = new ProductServiceImpl();
        cartItems = new HashMap<>();
    }
    public  void addToCart(Product product){
        if (verifiedProduct(product)){
            CartItem item = cartItems.get(product.getProductId());
            if (item == null){
                item = new CartItem(product);
            }
            item.addItems(BigInteger.ONE.intValue());
            cartItems.put(product.getProductId(),item);
        }
    }
    public  void addToCart(Product product,int quantity){
        if (verifiedProduct(product)){
            CartItem item = cartItems.get(product.getProductId());
            if (item == null){
                item = new CartItem(product);
            }
            item.addItems(quantity);
            cartItems.put(product.getProductId(),item);
        }
    }

    private boolean verifiedProduct(Product product){
        boolean verified = false;
        if (product !=null){
            try{
                Product verifiedProduct = productService.findProductById(product.getProductId());
                verified = true;
            }catch (ProductException productException){
//                @todo add log message
//                logger.log();
            }
        }
        return verified;
    }

    public boolean removeFromCart(Product product){
        boolean removed = false;
        if (product != null){
            this.cartItems.remove(product.getProductId());
            removed = true;
        }
        return removed;
    }

    public Map<String,CartItem> getCartItems(){
        return cartItems;
    }
    public BigDecimal calculateCartTotal(){
        if (!cartItems.isEmpty()){
            this.total = BigDecimal.ZERO;
            Iterator<CartItem> cartItemIterator = cartItems.values().iterator();
            while (cartItemIterator.hasNext()){
                this.total = this.total.add(cartItemIterator.next().getTotal());

            }
        }
        return this.getTotal();
    }

    public BigDecimal getTotal() {
        return total;
    }


}
