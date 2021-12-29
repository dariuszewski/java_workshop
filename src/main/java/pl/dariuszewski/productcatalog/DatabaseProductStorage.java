package pl.dariuszewski.productcatalog;

import java.util.List;

public class DatabaseProductStorage implements ProductStorage {
    @Override
    public void save(Product product) {
        //SQL to DB
    }

    @Override
    public Product loadById(String productId) {
        //SQL to DB
        return null;
    }

    @Override
    public List<Product> allProducts() {
        //SQL To DB list
        return null;
    }
}
