package tech.bts.onlineshop;

import tech.bts.onlineshop.business.ProductService;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class Example2 {

    public static void main(String[] args) {

        ProductDatabase productDatabase = new ProductDatabase();

        ProductService productService = new ProductService(productDatabase);
        long xiomiId = productService.createProduct(new Product("A1", "Xiomi", 250));
        long iPhoneId = productService.createProduct(new Product("iPhone XS", "Apple", 1250));
        long pixelId = productService.createProduct(new Product("Pixel 3", "Google", 900));

        productService.addProductStock(iPhoneId, 100);
        productService.addProductStock(iPhoneId, 200);
        productService.addProductStock(pixelId, 150);

        Product p = productService.getProductById(iPhoneId);
        System.out.println("There are " + p.getQuantity() + " units of " + p.getName()+ " in stock" );

        boolean p1 = productService.checkProductAvailability(iPhoneId, 20);
        System.out.println(p1);

    }

}
