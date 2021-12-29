package pl.dariuszewski;

import org.springframework.context.annotation.Bean;
import pl.dariuszewski.greetings.Greeter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.dariuszewski.productcatalog.DatabaseProductStorage;
import pl.dariuszewski.productcatalog.ProductCatalog;
import pl.dariuszewski.productcatalog.InMemoryProductStorage;
import pl.dariuszewski.productcatalog.ProductStorage;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        Greeter greeter = new Greeter();
        System.out.println(greeter.hello("Darius"));
    }
    @Bean
    Greeter createGreeter() {
        return new Greeter();
    }

    @Bean
    ProductCatalog createCatalog(InMemoryProductStorage productStorage) { return new ProductCatalog(productStorage); }

    @Bean
    DatabaseProductStorage createDbProductStorage() {
        return new DatabaseProductStorage();
    }

    @Bean
    ProductStorage provideProductStorage() {
        return createProductStorage();
    }

    @Bean
    InMemoryProductStorage createProductStorage() {
        return new InMemoryProductStorage();
    }
}
