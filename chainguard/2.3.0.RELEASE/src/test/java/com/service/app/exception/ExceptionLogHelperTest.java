package com.service.app.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionLogHelperTest {

    @Test
    void convertToStringWhenSuccess() {
        String errorCode = "Err01";
        String errorMsg = "Custom Error Message";
        AuthorizationException authorizationException = new AuthorizationException(errorCode, errorMsg);

        String result = ExceptionLogHelper.convertToString(authorizationException);
        assertTrue(result.contains("Custom Error Message"));
    }

    @Test
    void convertToStringWhenFailure() {
        String result = ExceptionLogHelper.convertToString(null);
        assertNull(result);
    }
}