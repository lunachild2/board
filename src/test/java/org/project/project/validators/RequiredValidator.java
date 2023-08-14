package org.project.project.validators;

public interface RequiredValidator {

    default void checkRequired(String str, RuntimeException e) {
        if(str == null || str.isBlank()) {
            throw e;
        }
    }
}
