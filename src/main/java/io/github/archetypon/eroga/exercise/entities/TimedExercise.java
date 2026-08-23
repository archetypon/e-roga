package io.github.archetypon.eroga.exercise.entities;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@DiscriminatorValue("TIMED_EXERCISE")
@RequiredArgsConstructor
public class TimedExercise extends Exercise {
    @Id
    public UUID getId() {
        return this.id;
    }
}
