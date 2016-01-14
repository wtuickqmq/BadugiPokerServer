package com.joker.common.exception;

public class ConfigurationException
extends RuntimeException
{
    private static final long serialVersionUID = -4891898485346985591L;

	public ConfigurationException()
	{
	}

	/**
	 * @param message
	 */
	public ConfigurationException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConfigurationException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConfigurationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
