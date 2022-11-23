package mx.org.coneval.errors;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private HttpStatus statusCode;

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiRequestException(String message) {
		super(message);
	}
	
	public ApiRequestException(String message, HttpStatus statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
}
