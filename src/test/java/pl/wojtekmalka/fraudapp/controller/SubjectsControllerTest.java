package pl.wojtekmalka.fraudapp.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.wojtekmalka.fraudapp.repository.PersonRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SubjectsControllerTest {


    MockMvc mockMvc;

    @Test
    void getSubcjectsManagerPage() throws Exception {
        mockMvc.perform(get("/subjectsManager"))
                .andExpect(status().isOk())
                .andExpect(view().name("subjectsManager"));
    }

    @Test
    void getViewPersonEntitiesPage() {
        PersonRepository mockRepository = Mockito.mock(PersonRepository.class);
        Mockito.when(mockRepository.count())
                .thenReturn(111L);
    }
}