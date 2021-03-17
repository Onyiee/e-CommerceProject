package com.pentazon.product;

import com.pentazon.exceptions.ProductException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductDB {
    private Map< String, Product> mockProducts;

    public ProductDB(){
        mockProducts = new HashMap<>();

         Product plantainChips = new Product("Adunni chips","Savoury plantain chips", new BigDecimal(50));
         plantainChips.setProductId("AD001");
         mockProducts.put(plantainChips.getProductId(),plantainChips);

         Product noseMasks = new Product();
         noseMasks.setProductId("AD002");
         noseMasks.setName("Bomu e Nose Mask");
         noseMasks.setDescription("Best in class nose mask");
         noseMasks.setPrice(new BigDecimal(4500));
         mockProducts.put(noseMasks.getProductId(),noseMasks);


         Product shirt = new Product("Vintage shirt","Vintage Versace shirts",new BigDecimal(5000));
         shirt.setProductId("AD003");
         mockProducts.put(shirt.getProductId(),shirt);
    }

    public Map<String, Product> getMockProducts(){
        return mockProducts;
    }

    public Product getProductById(String Id) throws ProductException {
        Product result = mockProducts.get(Id);
        if (result == null){
            StringBuilder message = new StringBuilder("Product with id ");
            message.append(Id);
            message.append(" not found ");
            throw new ProductException(message.toString());
        }
        return result;
    }


}
