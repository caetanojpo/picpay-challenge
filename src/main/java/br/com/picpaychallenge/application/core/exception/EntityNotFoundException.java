package br.com.picpaychallenge.application.core.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String objectName, UUID id) {
        super(objectName + " not found by ID: " + id);
    }

}


