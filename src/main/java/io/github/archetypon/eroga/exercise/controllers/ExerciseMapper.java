package io.github.archetypon.eroga.exercise.controllers;

import io.github.archetypon.eroga.exercise.entities.BodyWeightedExercise;
import io.github.archetypon.eroga.exercise.entities.Exercise;
import io.github.archetypon.eroga.exercise.entities.TimedExercise;
import io.github.archetypon.eroga.exercise.entities.WeightedExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ExerciseMapper {

    public abstract ExerciseDTO toDto(Exercise exercise);

    public Exercise toEntity(ExerciseDTO dto) {
        if (dto == null) {
            return null;
        }

        return switch (dto.type()) {
            case "BODY_WEIGHTED_EXERCISE" -> toBodyWeightedExercise(dto);
            case "TIMED_EXERCISE" -> toTimedExercise(dto);
            case "WEIGHTED_EXERCISE" -> toWeightedExercise(dto);
            // TODO: Sostituire con eccezione e handler
            default -> throw new IllegalArgumentException("Tipo esercizio non supportato: " + dto.type());
        };
    }

    protected abstract BodyWeightedExercise toBodyWeightedExercise(ExerciseDTO dto);

    protected abstract TimedExercise toTimedExercise(ExerciseDTO dto);

    protected abstract WeightedExercise toWeightedExercise(ExerciseDTO dto);

}