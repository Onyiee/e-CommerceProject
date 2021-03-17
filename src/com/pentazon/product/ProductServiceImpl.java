package com.pentazon.product;

import com.pentazon.exceptions.ProductException;

public class ProductServiceImpl implements ProductService {
    private ProductDB productRepoMock = new ProductDB();
    /**
     * search for product with specific id
     *
     * @param productId
     * @return product with specific product Id
     * @@throws productException
     */
    @Override
    public Product findProductById(String productId) throws ProductException {
        return productRepoMock.getProductById(productId);

    }


}
