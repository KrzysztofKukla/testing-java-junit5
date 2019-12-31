package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
    @Disabled
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
    void valueSourceParameterizedTest(String value) throws Exception {
        System.out.println(value);
    }

    @DisplayName("Enum Source Test-> ")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ParameterizedTest.INDEX_PLACEHOLDER)
    @EnumSource(value = OwnerType.class)
    void enumSourceParameterizedTest(OwnerType ownerType) throws Exception {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Source Test-> ")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ParameterizedTest.INDEX_PLACEHOLDER)
    @CsvSource(value = {
        "A,1,1",
        "B,2,2",
        "3,4,4"
    })
    void csvSourceTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    @DisplayName("CSV input File Test-> ")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ParameterizedTest.INDEX_PLACEHOLDER)
    @CsvFileSource(resources = {"/input.csv"}, numLinesToSkip = 1)
    void csvFileSource(String stateName, int val1, int val2) throws Exception {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    @DisplayName("Method provider Test-> ")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ParameterizedTest.INDEX_PLACEHOLDER)
    @MethodSource(value = {"getArgs"})
    void methodProviderTest(String stateName, int val1, int val2) throws Exception {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    @DisplayName("Class arguments provider Test-> ")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(value = CustomArgsProvider.class)
    void classArgumentsProviderTest(String stateName, int val1, int val2) throws Exception {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    private Owner createOwner(Long id, String firstName, String lastName, String address, String city, String telephone) {
        Owner owner = new Owner(id, firstName, lastName);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);
        return owner;
    }

    //here we can provide arguments from many sources like database, message queue, xml file, json etc.
    private static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of("AAA", 111, 222),
            Arguments.of("BBB", 333, 666),
            Arguments.of("CCC", 444, 777)
        );
    }

}
