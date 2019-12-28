package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertThrows(IllegalArgumentException.class, ()->indexController.someException());
    }

    @Test
    void timeoutTest() throws Exception {
        //maximum duration time for this method is 100 milliseconds, but execution time method takes 5000 milliseconds
        //test and method are executed in the same thread, so wee need to wait until to the end of method execution
        Assertions.assertTimeout(Duration.ofMillis(100), ()->Thread.sleep(5000));

        //we have to be aware - duration time execution of method on local system versus CI system can be very, very different
    }

    @Test
    void timeoutPreemptivelyTest() throws Exception {
        //maximum duration time for this method is 100 milliseconds, but execution time method takes 5000 milliseconds
        //test and method are executed in different threads, that means we don't wait to finish method execution
        //when duration time is exceeded ( przekroczony ) then it terminates ( przerywa ) our test - kill that thread earlier
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), ()->Thread.sleep(5000));
    }

}