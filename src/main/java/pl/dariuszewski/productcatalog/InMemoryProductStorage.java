package pl.dariuszewski.productcatalog;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryProductStorage implements ProductStorage {
    Map<String, Product> products;

    public InMemoryProductStorage() {
        this.products = new HashMap<>();
    }

    @Override
    public void save(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public Product loadById(String productId) {
        return products.get(productId);
    }

    @Override
    public List<Product> allProducts() {
        return products.values()
                .stream()
                .collect(Collectors.toList());

    }
}
