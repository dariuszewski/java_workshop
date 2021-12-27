package pl.dariuszewski.greetings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GreeterTest {

    @Test
    public void itGreetsUser() {
        //Arrange //Given
        String name = "Darius";
        Greeter greeter = new Greeter();

        //Act //When
        String message = greeter.hello(name);

        //Assert //Then
        assertEquals("Hello Darius", message);
    }
}
