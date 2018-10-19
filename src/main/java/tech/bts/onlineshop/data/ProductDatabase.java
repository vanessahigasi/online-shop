package tech.bts.onlineshop.data;

import tech.bts.onlineshop.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {

    private long nextId;

    private Map<Long, Product> productMap;


    public ProductDatabase() {
        this.nextId = 1;
        this.productMap = new HashMap<>();
    }

    public void add (Product product) {

        product.setId(this.nextId);

        productMap.put(product.getId(),product);

        this.nextId++;
    }

    public Product get(long id){

        return productMap.get(id);
    }

    public int getCount() {

        return productMap.size();
    }
}
