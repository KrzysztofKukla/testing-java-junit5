package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.RepeatedTest.CURRENT_REPETITION_PLACEHOLDER;
import static org.junit.jupiter.api.RepeatedTest.DISPLAY_NAME_PLACEHOLDER;

/**
 * @author Krzysztof Kukla
 */
//from JUnit 5 your tests can implement interfaces as well
class PersonTest implements ModelTest {

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

    @DisplayName("My Repeated test of->")
    @RepeatedTest(value = 10, name = DISPLAY_NAME_PLACEHOLDER + CURRENT_REPETITION_PLACEHOLDER)
    void repeatedTest() throws Exception {

    }
}