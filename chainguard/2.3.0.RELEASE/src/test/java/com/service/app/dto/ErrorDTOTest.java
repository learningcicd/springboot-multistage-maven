package com.service.app.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDTOTest {

    @Test
    void setException() {
        String expMsg = "my custom Exception";
        ErrorDTO subject = new ErrorDTO();
        subject.setException(expMsg);
        assertEquals(expMsg, subject.getException());
    }


    @Test
    void getErrorCode() {
        String expectedCode = "ERR01";
        ErrorDTO subject = new ErrorDTO();
        subject.setErrorCode(expectedCode);
        assertEquals(expectedCode, subject.getErrorCode());
    }

}