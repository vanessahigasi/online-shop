package tech.bts.onlineshop.business;

import org.junit.Test;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest {


    @Test
    public void empty_catalog_has_no_products() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        int count = productService.getCount();
        assertEquals(0, count);

    }

    @Test
    public void add_product_to_catalog() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        Product product = new Product("Pixel", "Google", 800);
        long pixelId = productService.createProduct(product);
        int count = productService.getCount();
        //System.out.println("1 ---> " + count);
        assertEquals(1, count);
        Product p = productService.getProductById(pixelId);
        //System.out.println("Pixel --> " + p.getName());
        assertEquals("Pixel", p.getName() );

    }

    @Test
    public void product_is_available() {

        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        Product product = new Product("Pixel", "Google", 800);
        long pixelId = productService.createProduct(product);

        boolean availableBefore = productService.checkProductAvailability(pixelId, 500);
        assertEquals(false, availableBefore);

        productService.addProductStock(pixelId, 500);

        boolean availableAfter = productService.checkProductAvailability(pixelId, 500);
        assertEquals(true, availableAfter );

    }

    @Test
    public void product_available_quantity() {
        ProductDatabase productDatabase = new ProductDatabase();
        ProductService productService = new ProductService(productDatabase);
        Product product = new Product("Pixel", "Google", 800);
        long pixelId = productService.createProduct(product);

        int inStockOrNot = productService.getAvailiableQuantity(pixelId, 50);
        assertEquals(0, inStockOrNot );

        productService.addProductStock(pixelId, 100);

        int inStockOrNot1 = productService.getAvailiableQuantity(pixelId, 50);
        assertEquals(50,inStockOrNot1 );


        int inStockOrNot2 = productService.getAvailiableQuantity(pixelId, 200);
        assertEquals(100,inStockOrNot2 );
    }


}
