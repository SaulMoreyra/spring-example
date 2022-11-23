package mx.org.coneval.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value= { ApiRequestException.class })
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		
		HttpStatus statusCode = e.getStatusCode();
		if(statusCode == null) statusCode = HttpStatus.BAD_REQUEST;
		
		ApiException apiException =  new ApiException(
			e.getMessage(), 
			statusCode,
			LocalDateTime.now().toString()
		);
		
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
	}
}
