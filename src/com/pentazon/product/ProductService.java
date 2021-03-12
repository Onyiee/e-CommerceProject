package com.pentazon.product;


import com.pentazon.exceptions.ProductException;

/**
 * Provides services for dealing with products in pentazon
 * */

public interface ProductService {
    /**
     * search for product with specific id
     *
     * @param productId
     * @return product with specific product Id
     */

    Product findProductById(String productId) throws ProductException;



}