package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Krzysztof Kukla
 */
//from JUnit 5 your tests can implement interfaces as well
class OwnerTest implements ModelTest {

    private Owner owner1;
    private Owner owner2;

    @BeforeEach
    void setUp() {
        owner1 = createOwner(1L, "Joe", "Buck", "Kasztanowa 31", "Cracow", "32525262");
        owner2 = createOwner(2L, "Peter", "McFly", "Sunny 23", "Warsaw", "112233");
    }

    @DisplayName("Grouped test with many asserts")
    //it allows to run all Assertions even if first is failing like below
    @Test
    void groupedAssertions() {
        Assertions.assertAll("Person properties",
            () -> Assertions.assertAll("Owner1 properties",
                () -> Assertions.assertEquals("Cracowa", owner1.getCity(), "Invalid city"),
                () -> Assertions.assertEquals("32525262", owner1.getTelephone())
            ),
            () -> Assertions.assertAll("Owner2 properties",
                () -> Assertions.assertEquals("Warsaw", owner2.getCity()),
                () -> Assertions.assertEquals("1122233", owner2.getTelephone(), "Invalid telephone")
            )
        );
    }

    @Test
    void hamcrestTest() throws Exception {
        MatcherAssert.assertThat(owner1.getCity(), Matchers.is("Cracow"));
    }

    @DisplayName("Value Source Test-> ")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ParameterizedTest.INDEX_PLACEHOLDER)
    @ValueSource(strings = {"first", "second", "third"})
    void parameterValueSourceTest(String value) throws Exception {
        System.out.println(value);
    }

    private Owner createOwner(Long id, String firstName, String lastName, String address, String city, String telephone) {
        Owner owner = new Owner(id, firstName, lastName);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);
        return owner;
    }

}
