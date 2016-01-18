package com.badugi.game.logic.model.utils.exception;


@SuppressWarnings("serial")
public class BusinessProcessException extends BaseException {

	
	/**
	 * constructs
	 */
	public BusinessProcessException() {
		super();
	}

	/**
	 * constructs
	 */
	public BusinessProcessException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public BusinessProcessException(String errorCode,Throwable e) {
		super(e);
		this.errorCode = errorCode;
		this.rootCause = e;
	}


}
