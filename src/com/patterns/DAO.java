package com.patterns;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ihar Zharykau
 */
public class DAO {
    public static void main(String... args) {
        ProductDAO productDAO = new ProductDAOImpl();
        System.out.println("All products : " + productDAO.getAllProducts());
        System.out.println("Product with id 3 : " + productDAO.getProductById("3"));
    }
}

interface ProductDAO {
    List<Product> getAllProducts();

    Product getProductById(String id);
}

class ProductDAOImpl implements ProductDAO {
    /**
     * here we should connect to database and get products from there
     */
    private List<Product> products = Arrays.asList(
            new Product("1", "Cocoa"),
            new Product("2", "Chocolate"),
            new Product("3", "Ice cream"));

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(String id) {
        return products
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().get();
    }
}