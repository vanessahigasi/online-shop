package tech.bts.onlineshop.business;

import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.CartItem;
import tech.bts.onlineshop.model.Product;
import tech.bts.onlineshop.model.ShoppingCart;

public class ProductService {

    private ProductDatabase productDatabase;

    public ProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    // returns the id oа the product.
    public long createProduct(Product product) {

      long productId = this.productDatabase.add(product);
      return productId;
    }

    public int getCount() {
       return productDatabase.getCount();
    }

    public void  addProductStock( long productId, int quantity) {

        Product product = this.productDatabase.get(productId);
        int total = product.getQuantity() + quantity;
        product.setQuantity(total);
    }

    public Product getProductById(long productId) {

        Product p = productDatabase.get(productId);
        return p;
    }


    //1- create a method in ProductService that, given a product id and a desired quantity, returns true if the quantity is possible to deliver, or false otherwise.
    // For example, imagine that there are 15 units of that product in stock.
    // If I want 20 units then the method would return false. If I want 10 units then the method would return true.

    public boolean checkProductAvailability( long productId, int quantity) {

        Product product = productDatabase.get(productId);
        if (product.getQuantity() >= quantity ) {
            return true;
        } else {
            return false;
        }

    }

    //2- create a method in ProductService that, given a product id and a desired quantity, returns the quantity that is possible to deliver.
    // For example, imagine that there are 15 units of that product in stock.
    // If I want 20 units then the method would return 15.
    // If I want 10 units then the method would return 10.

    public int getAvailiableQuantity(long productId, int quantity) {

        Product product = productDatabase.get(productId);
        return Math.min(product.getQuantity(), quantity);

    }


    /** Reduces the quantities of the products by the quantities in the cart */
    public void purchase(ShoppingCart cart) {

        for (CartItem item : cart.getItems()) {
            Product product = productDatabase.get(item.getProductId());
            int remainingQuantity = product.getQuantity() - item.getQuantity();
            product.setQuantity(remainingQuantity);
        }
    }
}
