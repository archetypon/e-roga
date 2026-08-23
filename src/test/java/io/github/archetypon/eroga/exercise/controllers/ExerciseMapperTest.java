package io.github.archetypon.eroga.exercise.controllers;

import io.github.archetypon.eroga.exercise.entities.Exercise;
import io.github.archetypon.eroga.exercise.entities.TimedExercise;
import io.github.archetypon.eroga.exercise.entities.WeightedExercise;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseMapperTest {

    private final String NAME = "Test Name";
    private final ExerciseMapper MAPPER = Mappers.getMapper(ExerciseMapper.class);


    @Test
    void toDto() {
        Exercise exercise = new WeightedExercise();
        exercise.setName(NAME);
        ExerciseDTO dto = MAPPER.toDto(exercise);
        assertEquals(NAME, dto.name());
    }

    @Test
    void toEntity() {
        String id = UUID.randomUUID().toString();
        ExerciseDTO dto = new ExerciseDTO(id, NAME, "TIMED_EXERCISE");
        Exercise exercise = MAPPER.toEntity(dto);
        assertInstanceOf(TimedExercise.class, exercise);
        assertEquals(NAME, exercise.getName());
        assertEquals(id, exercise.getId().toString());
    }

}