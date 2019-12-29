package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    private VetService vetService;

    @Mock
    private Model model;

    @InjectMocks
    private VetController vetController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listVets() {
        Vet vet = new Vet(1L, "firstName", "lastName", Collections.emptySet());
        List<Vet> vets = Arrays.asList(vet);

        BDDMockito.when(vetService.findAll()).thenReturn(new HashSet<>(vets));
        String view = vetController.listVets(model);

        Assertions.assertEquals("vets/index", view);
        BDDMockito.then(vetService).should().findAll();
        BDDMockito.then(model).should().addAttribute(ArgumentMatchers.anyString(), ArgumentMatchers.any(Set.class));

    }

}