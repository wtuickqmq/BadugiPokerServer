package com.badugi.game.logic.util;

import java.util.UUID;

public class IdGenerator {
	
    public static String getNextId() { 
    	return UUID.randomUUID().toString();
    } 
}
