package io.github.archetypon.eroga.exercise.services;

import io.github.archetypon.eroga.exercise.controllers.ExerciseDTO;
import io.github.archetypon.eroga.exercise.controllers.ExerciseMapper;
import io.github.archetypon.eroga.exercise.entities.Exercise;
import io.github.archetypon.eroga.exercise.exceptions.ExerciseNotFoundException;
import io.github.archetypon.eroga.exercise.exceptions.NotUUIDException;
import io.github.archetypon.eroga.exercise.repositories.ExerciseRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseService {

    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    public ExerciseService(@Autowired ExerciseRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(ExerciseMapper.class);
    }

    public ExerciseDTO createExercise(ExerciseDTO exercise) {
        return mapper.toDto(repository.save(mapper.toEntity(exercise)));
    }

    public ExerciseDTO getById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new NotUUIDException();
        }
        final Optional<Exercise> exercise = repository.findById(uuid);
        if (exercise.isEmpty())
            throw new ExerciseNotFoundException(id);
        return mapper.toDto(exercise.get());
    }
}
