package io.github.archetypon.eroga.exercise.api;

import io.github.archetypon.eroga.exercise.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExerciseController {

    private final ExerciseService service;

    public ExerciseController(@Autowired ExerciseService service) {
        this.service = service;
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<ExerciseDTO> getExercise(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping("/exercise")
    public ResponseEntity<ExerciseDTO> postExercise(@RequestBody ExerciseDTO exercise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createExercise(exercise));
    }
}
