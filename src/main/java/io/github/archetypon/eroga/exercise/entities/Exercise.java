package io.github.archetypon.eroga.exercise.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter
    @Getter
    protected UUID id;
    @Setter
    @Getter
    protected String name;

    public static final String DEFAULT_NAME = "DEFAULT";

    public Exercise() {
        this.name = DEFAULT_NAME;
    }
}
