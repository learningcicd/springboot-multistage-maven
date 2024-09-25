package com.service.app.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationExceptionTest {

    @Test
    void testNoArgsConstructor() {
        InputValidationException subject  = new InputValidationException();
        assertNotNull(subject);
    }

    @Test
    void testArgsConstructor() {
        InputValidationException subject  = new InputValidationException("My custom Arg");
        assertNotNull(subject);
    }
}