package pl.dariuszewski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.dariuszewski.greetings.Greeter;
import pl.dariuszewski.productcatalog.*;
import pl.dariuszewski.productcatalog.Product;
import pl.dariuszewski.sales.*;
import pl.dariuszewski.sales.cart.InMemoryCartStorage;
import pl.dariuszewski.sales.offerting.OfferMaker;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        Greeter greeter = new Greeter();
        System.out.println(greeter.hello("Darius"));
    }

    @Bean
    Greeter createGreater() {
        return new Greeter();
    }

    @Bean
    ProductCatalog createCatalog(ProductStorage productStorage) {
        ProductCatalog productCatalog = new ProductCatalog(productStorage);

        productCatalog.addProduct(
                "product-1",
                "My Nice Picture",
                "Very nice"
        );

        productCatalog.updatePrice("product-1", BigDecimal.valueOf(10.10));
        productCatalog.publish("product-1");

        productCatalog.addProduct(
                "product-2",
                "My Nice Picture 2",
                "Bla bla"
        );

        productCatalog.updatePrice("product-2", BigDecimal.valueOf(20.10));
        productCatalog.publish("product-2");

        return productCatalog;
    }

    @Bean
    ProductStorage createDbProductStorage(ProductRepository productRepository) {
        return new DatabaseProductStorage(productRepository);
    }

    @Bean
    SalesFacade createSalesFacade(ProductCatalog productCatalog) {
        ProductDetailsProvider productDetailsProvider = (ProductDetailsProvider) (productId) -> {
            Product loadedProduct = productCatalog.loadProduct(productId);

            return new pl.dariuszewski.sales.Product(
                    loadedProduct.getProductId(),
                    loadedProduct.getName(),
                    loadedProduct.getPrice()
            );
        };

        return new SalesFacade(
                new InMemoryCartStorage(),
                productDetailsProvider,
                new OfferMaker(productDetailsProvider)
        );
    }
}