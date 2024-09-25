package com.service.app.exception;

import com.service.app.dto.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    @Test
    void testHttpMessageNotReadableExceptionHandler() {
        String my_custome_error = "my custome error";
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException(my_custome_error);
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setException(my_custome_error);
        errorDTO.setErrorCode("SC001");
        ResponseEntity<ErrorDTO> expectedResponse = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);

        GlobalExceptionHandler subject = new GlobalExceptionHandler();
        ResponseEntity<ErrorDTO> response = subject.handle(exception);
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
    }

    @Test
    void testAuthorizationExceptionHandle() {
        String error_message = "my custome error";
        String error_code = "Err01";
        AuthorizationException exception = new AuthorizationException(error_code, error_message);
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setException(exception.getErrorMessage());
        errorDTO.setErrorCode("SC001");
        ResponseEntity<ErrorDTO> expectedResponse = new ResponseEntity<>(errorDTO, HttpStatus.FORBIDDEN);
        GlobalExceptionHandler subject = new GlobalExceptionHandler();
        ResponseEntity<ErrorDTO> response = subject.handle(exception);
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
    }

    @Test
    void testInputValidationExceptionHandle() {

        InputValidationException exception = new InputValidationException();
        GlobalExceptionHandler subject = new GlobalExceptionHandler();
        ErrorDTO response = subject.handle(exception);
        assertEquals("BR001", response.getErrorCode());
    }

    @Test
    void testThrowableHandle() {
        String error_message = "my custome error";
        Exception exception = new Exception(error_message);

        GlobalExceptionHandler subject = new GlobalExceptionHandler();
        ErrorDTO response = subject.handle(exception);
        assertEquals("TE001", response.getErrorCode());
    }
}