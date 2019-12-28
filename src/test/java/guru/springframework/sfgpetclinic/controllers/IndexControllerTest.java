package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}