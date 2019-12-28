package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Krzysztof Kukla
 */
class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(1L, "Joe", "Buck");
    }

    @Test
    void groupedAssertions() {
        Assertions.assertAll("Person details",
            () -> Assertions.assertEquals("Joe", person.getFirstName()),
            () -> Assertions.assertEquals("Buck", person.getLastName())
        );
    }
}