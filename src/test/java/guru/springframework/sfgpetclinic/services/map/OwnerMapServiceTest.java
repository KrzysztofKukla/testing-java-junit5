package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Krzysztof Kukla
 */
@DisplayName("Owner Map Service Test-> ")
@ExtendWith(MockitoExtension.class)
class OwnerMapServiceTest {

    @Mock
    private PetTypeService petTypeService;
    @Mock
    private PetService petService;

    @InjectMocks
    private OwnerMapService ownerMapService;

    @BeforeEach
    void outerSetUp() {

    }

    @DisplayName("Verify Zero Owners - outer")
    @Test
    void verifyZeroOwners() throws Exception {

    }

    @DisplayName("Pet Type-> ")
    @Nested
    class TestCreatePetType{

        @BeforeEach
        void innerSetUp() {

        }

        //before run this test, first will be run @BeforeEach from outerSetUp()
        //then @BeforeEach innerSetUp()
        // and then run this test
        // so this test will have information from all @BeforeEach method above,
        // but will NOT have information from any other tests
        // each test is run separate
        @Test
        void testPetCount() throws Exception {

        }

        @DisplayName("Save Owner Tests-> ")
        @Nested
        class SaveOwnerTests{

            @DisplayName("Find Owner")
            @Test
            void some() throws Exception {

            }
        }
    }

    @DisplayName("Verify still zero Owners-> ")
    @Test
    void ownersAreStillZero() throws Exception {

    }

}