package io.github.archetypon.eroga.exercise.exceptions;


public class ExerciseNotFoundException extends RuntimeException {

    public ExerciseNotFoundException(String id) {
        super(String.format("Excercise with ID %s not found", id));
    }

}
