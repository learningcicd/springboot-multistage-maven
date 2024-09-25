package com.service.app.web;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

	@GetMapping("/hello")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success Response"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Bad Request") })
	public ResponseEntity<String> sayHello(HttpServletRequest request) {
		return new ResponseEntity<String>("Hello Mr Rocky", HttpStatus.OK);
	}
}
