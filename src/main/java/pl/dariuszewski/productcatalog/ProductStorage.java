package pl.dariuszewski.productcatalog;

import java.util.List;

public interface ProductStorage {
    void save(Product product);

    Product loadById(String productId);

    List<Product> allProducts();
}
