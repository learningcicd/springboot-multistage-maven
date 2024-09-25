package com.service.app.exception;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.service.app.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger log = Logger.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseEntity<ErrorDTO> handle(HttpMessageNotReadableException exception) {
		log.error("Exception occured " + ExceptionLogHelper.convertToString(exception));
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setException(exception.getMessage());
		errorDTO.setErrorCode("SC001");
		ResponseEntity<ErrorDTO> entity = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
		return entity;
	}

	@ExceptionHandler(value = AuthorizationException.class)
	@ResponseBody
	public ResponseEntity<ErrorDTO> handle(AuthorizationException exception) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setException(exception.getErrorMessage());
		errorDTO.setErrorCode(exception.getErrorCode());
		ResponseEntity<ErrorDTO> entity = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.FORBIDDEN);
		return entity;
	}
	
	@ExceptionHandler(value=InputValidationException.class)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public  ErrorDTO handle(InputValidationException exception){
		log.error("Exception occured "+ExceptionLogHelper.convertToString(exception));
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setException(exception.getMessage());
		errorDTO.setErrorCode("BR001");
		return errorDTO;
	}


	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDTO handle(Throwable throwable) {
		Exception exception = (Exception) throwable;
		log.error("Exception occured " + ExceptionLogHelper.convertToString(exception));
		ErrorDTO errorDTO = new ErrorDTO();
		if (StringUtils.isNotEmpty(exception.getMessage())) {
			errorDTO.setException(exception.getMessage());
		} else {
			errorDTO.setException(ExceptionLogHelper.convertToString(exception));
		}

		errorDTO.setErrorCode("TE001");
		return errorDTO;
	}
}
