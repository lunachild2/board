package org.project.proejct.validators;

public interface RequiredValidator {

    default void checkRequired(String str, RuntimeException e) {
        if(str == null || str.isBlank()) {
            throw e;
        }
    }
}