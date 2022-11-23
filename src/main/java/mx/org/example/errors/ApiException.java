package mx.org.example.errors;

import org.springframework.http.HttpStatus;

public class ApiException {
	private final String message;
	private final String status;
	private final int code;
	private final String timestamp;
	
	public ApiException(String message, HttpStatus httpStatus, String timestamp) {
		super();
		this.message = message;
		this.status = httpStatus.getReasonPhrase();
		this.code = httpStatus.value();
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}

	public String getTimestamp() {
		return timestamp;
	}
}
