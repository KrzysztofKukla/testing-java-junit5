package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Krzysztof Kukla
 */
@Tag("controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTest {

    @BeforeAll
    default void beforeAll(){
        System.out.println("Before All from ControllerTest");
    }
}
