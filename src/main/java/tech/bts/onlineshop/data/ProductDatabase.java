package tech.bts.onlineshop.data;

import tech.bts.onlineshop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    // TODO: method getByPriceRange, given 2 prices(minPrice, maxPrice) returns a list
    // of products that are in that price range (included)

    // TODO: method remove, given an id, removes that product from the database

    public int getCountByBrand(String brand) {

        List<Product> products = getByBrand(brand);
        return products.size();

    }

    public List<Product> getByBrand(String brand) {
        List<Product> result = new ArrayList<>();

        for (Product product : productMap.values()) {
            if (product.getBrand().equals(brand)) {
                result.add(product);
            }

        }
        return result;
    }
}
