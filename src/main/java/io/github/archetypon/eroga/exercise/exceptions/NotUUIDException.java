package io.github.archetypon.eroga.exercise.exceptions;

public class NotUUIDException extends RuntimeException{
    public NotUUIDException() {
        super("Not an UUID");
    }
}
