package com.service.app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AppController {

	@GetMapping("/hello")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Bad Request") })
	public ResponseEntity<String> sayHello(HttpServletRequest request) {
		return new ResponseEntity<String>("Hello Mr Rocky", HttpStatus.OK);
	}
}
