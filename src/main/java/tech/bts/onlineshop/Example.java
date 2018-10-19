package tech.bts.onlineshop;

import tech.bts.onlineshop.business.PurchaseService;
import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.CartItem;
import tech.bts.onlineshop.model.Product;
import tech.bts.onlineshop.model.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

    public static void main(String[] args) {

        Product p1 = new  Product("Macbook", "Apple",1500);
        Product p2 = new  Product("iphone xs", "Apple",1200);
        Product p3 = new  Product("pixel 3","Google",900);

        ProductDatabase productDatabase = new ProductDatabase();
        productDatabase.add(p1);
        productDatabase.add(p2);
        productDatabase.add(p3);

        Product product = productDatabase.get(2);
        System.out.println("The name of the product is" + product.getName());

        int count = productDatabase.getCount();
        System.out.println("I have " + count + " products in the database");

        int countApple = productDatabase.getCountByBrand("Apple");
        System.out.println("I have " + countApple + " Apple products") ;

        List<Product> appleProducts = productDatabase.getByBrand("Apple");
        System.out.println("Products by Apple " + appleProducts);
        for (Product p : appleProducts) {
            System.out.println(p.getName() +  ", " + p.getBrand() + ", " + p.getPrice());

        }

        List<CartItem> items1 = new ArrayList<>();

        items1.add(new CartItem(p1,2));
        items1.add(new CartItem(p2,3));
        items1.add(new CartItem(p3,1));

        ShoppingCart cart = new ShoppingCart(items1);

        PurchaseService purchaseService = new PurchaseService();

        double total = purchaseService.calculateTotalAmount(cart);

        System.out.println("total = " + total);






    }
}
