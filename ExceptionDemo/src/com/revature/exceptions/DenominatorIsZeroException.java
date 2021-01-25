package com.revature.exceptions;

//Because this extends Exception, it becomes a checked Exception
//If it extends RuntimeException, it becomes an unchecked Exception
public class DenominatorIsZeroException extends Exception{

	public DenominatorIsZeroException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DenominatorIsZeroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DenominatorIsZeroException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DenominatorIsZeroException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DenominatorIsZeroException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
