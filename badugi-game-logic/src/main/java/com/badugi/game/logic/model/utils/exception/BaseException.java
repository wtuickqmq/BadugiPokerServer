
package com.badugi.game.logic.model.utils.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class BaseException extends Exception {

	private static final long serialVersionUID = 899477426265773750L;

	protected Throwable rootCause = null;
	
	protected String errorCode;

	private List<BaseException> exceptions = new ArrayList<BaseException>();

	public BaseException() {
		super();
	}
	

	public BaseException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}


	public BaseException(Throwable cause) {
		super(cause);
	}

	public List getExceptions() {
		return exceptions;
	}

	public void addException(BaseException ex) {
		exceptions.add(ex);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	@Override
	public void printStackTrace() {
		printStackTrace(System.err);
	}

	@Override
	public void printStackTrace(PrintStream s) {
		printStackTrace(new PrintWriter(s));
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		if (getRootCause() != null) {
			getRootCause().printStackTrace(s);
		}
		s.flush();
	}

}
