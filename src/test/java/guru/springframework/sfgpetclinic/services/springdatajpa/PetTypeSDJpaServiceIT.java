package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.junitextension.TimingExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Krzysztof Kukla
 */
@ExtendWith(TimingExtension.class)
//integration tests should be placed in separate 'integration' folder
class PetTypeSDJpaServiceIT {

    @BeforeEach
    void setUp() {
        System.out.println(System.getenv("API_KEY"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

}