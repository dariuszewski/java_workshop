package pl.dariuszewski;

import org.springframework.context.annotation.Bean;
import pl.dariuszewski.greetings.Greeter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
