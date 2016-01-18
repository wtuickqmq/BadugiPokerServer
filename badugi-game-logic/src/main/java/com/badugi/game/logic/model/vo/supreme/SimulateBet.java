package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;
import java.util.List;

public class SimulateBet implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
     private SimulateBetMap simulatebetMap;
     public SimulateBet(){}
     public SimulateBet(String cmd,SimulateBetMap simulatebetMap){
    	 this.cmd = cmd;
    	 this.simulatebetMap = simulatebetMap;
     }
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public SimulateBetMap getSimulatebetMap() {
		return simulatebetMap;
	}
	public void setSimulatebetMap(SimulateBetMap simulatebetMap) {
		this.simulatebetMap = simulatebetMap;
	}
	
}
