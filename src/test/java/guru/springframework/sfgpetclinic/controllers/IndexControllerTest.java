package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
class IndexControllerTest {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void someException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> indexController.someException());
    }

    @Test
    void timeoutTest() throws Exception {
        //maximum duration time for this method is 100 milliseconds, but execution time method takes 5000 milliseconds
        //test and method are executed in the same thread, so wee need to wait until to the end of method execution
        Assertions.assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(5000));

        //we have to be aware - duration time execution of method on local system versus CI system can be very, very different
    }

    @Test
    void timeoutPreemptivelyTest() throws Exception {
        //maximum duration time for this method is 100 milliseconds, but execution time method takes 5000 milliseconds
        //test and method are executed in different threads, that means we don't wait to finish method execution
        //when duration time is exceeded ( przekroczony ) then it terminates ( przerywa ) our test - kill that thread earlier
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(5000));
    }

    @Test
    void assumptionTest() throws Exception {
        //Assumptions allow to invoke tests only if specified condition is achieved
        //used especially to run tests for different environments
        Assumptions.assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));

        //this assert test will be invoke only if Assumption above is achieved
        //otherwise will be ignore/disable
        Assertions.assertEquals("inadex", indexController.index());
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac() throws Exception {
        System.out.println("Running only on Mac");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() throws Exception {
        System.out.println("Running only on Windows");
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJava8() throws Exception {
        System.out.println("Running on Java8");
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testOnJava11() throws Exception {
        System.out.println("Running on Java11");
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Krzysztof")
    @Test
    void testOnKrzysztofUsername() throws Exception {
        System.out.println("Running on Krzysztof user");
    }

    @Disabled
    @Test
    void allEnvironmentVariables() throws Exception {
        Map<String, String> variables = System.getenv();
        variables.forEach((key, value) -> System.out.println(key + "-> " + value));
    }
}