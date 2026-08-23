package io.github.archetypon.eroga.exercise.repositories;

import io.github.archetypon.eroga.exercise.entities.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, UUID> {
}
