package com.service.app.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationExceptionTest {

    @Test
    void getErrorMessage() {
        String errorCode = "Err01";
        String errorMsg = "Custom Error Message";
        AuthorizationException subject = new AuthorizationException(errorCode, errorMsg);
        assertEquals(errorMsg, subject.getErrorMessage());
    }


    @Test
    void getErrorCode() {
        String errorCode = "Err01";
        String errorMsg = "Custom Error Message";
        AuthorizationException subject = new AuthorizationException(errorCode, errorMsg);
        assertEquals(errorCode, subject.getErrorCode());
    }

    @Test
    void setErrorMessage() {
        String errorCode = "Err01";
        String errorMsg = "Custom Error Message";
        AuthorizationException subject = new AuthorizationException(errorCode, errorMsg);
        subject.setErrorMessage(errorMsg);
        assertEquals(errorMsg, subject.getErrorMessage());
    }


    @Test
    void setErrorCode() {
        String errorCode = "Err01";
        String errorMsg = "Custom Error Message";
        AuthorizationException subject = new AuthorizationException(errorCode, errorMsg);
        subject.setErrorCode(errorCode);
        assertEquals(errorCode, subject.getErrorCode());
    }
}