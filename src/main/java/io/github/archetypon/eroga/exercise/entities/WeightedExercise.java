package io.github.archetypon.eroga.exercise.entities;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@DiscriminatorValue("WEIGHTED_EXERCISE")
@RequiredArgsConstructor
public class WeightedExercise extends Exercise {

    @Id
    public UUID getId() {
        return this.id;
    }

}