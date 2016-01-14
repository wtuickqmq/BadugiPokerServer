package io.nadron.util;

public class NadronConfig 
{
	public static final String NODE_NAME = "NadNode";
	public static final String RECONNECT_KEY = "RECONNECT_KEY";
	public static final String RECONNECT_REGISTRY = "RECONNECT_REGISTRY";
	public static final String ROOM_REF_NAME = "room";
	public static final String GROUP_REF_NAME = "group";
	/**
	 * By default wait for 5 minutes for remote client to reconnect, before
	 * closing session.
	 */
	public static final int DEFAULT_RECONNECT_DELAY =  5 * 60 * 1000;
}
