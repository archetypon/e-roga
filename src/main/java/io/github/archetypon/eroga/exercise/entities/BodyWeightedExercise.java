package io.github.archetypon.eroga.exercise.entities;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@DiscriminatorValue("BODY_WEIGHTED_EXERCISE")
@RequiredArgsConstructor
public class BodyWeightedExercise extends Exercise {
    @Id
    public UUID getId() {
        return this.id;
    }
}
