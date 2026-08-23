package io.github.archetypon.eroga.exercise.controllers;

import io.github.archetypon.eroga.common.ControllerExceptionHandler;
import io.github.archetypon.eroga.exercise.exceptions.ExerciseNotFoundException;
import io.github.archetypon.eroga.exercise.services.ExerciseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExerciseController.class)
@Import(ControllerExceptionHandler.class) // Se l'handler non è nello stesso package
class ExerciseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ExerciseService service;

    @Test
    void getExerciseNotFound() throws Exception {
        final String genericUUID = UUID.randomUUID().toString();
        when(service.getById(genericUUID)).thenThrow(new ExerciseNotFoundException(genericUUID));

        mockMvc.perform(get("/exercise/" + genericUUID))
                .andExpect(status().isNotFound())
                .andExpect(content().string(String.format("Excercise with ID %s not found", genericUUID)))
                .andExpect(result -> assertInstanceOf(ExerciseNotFoundException.class, result.getResolvedException()));
    }

    @Test
    void createExercise() {

    }


}