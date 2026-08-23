package io.github.archetypon.eroga.common.exceptions;

public class NotUUIDException extends RuntimeException{
    public NotUUIDException() {
        super("Not an UUID");
    }
}
