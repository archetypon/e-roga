package io.github.archetypon.eroga.activity.entities;

import io.github.archetypon.eroga.exercise.entities.Exercise;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Activity {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    private int dayOrder;
    private Date activityDate;

}
