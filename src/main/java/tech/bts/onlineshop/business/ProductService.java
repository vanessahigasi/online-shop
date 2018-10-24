package tech.bts.onlineshop.business;

import tech.bts.onlineshop.data.ProductDatabase;
import tech.bts.onlineshop.model.Product;

public class ProductService {

    private ProductDatabase productDatabase;

    public ProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public long createProduct(Product product) {

      long productId = this.productDatabase.add(product);
      return productId;
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

}
