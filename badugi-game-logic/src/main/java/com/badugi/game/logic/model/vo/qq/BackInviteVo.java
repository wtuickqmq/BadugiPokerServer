package com.badugi.game.logic.model.vo.qq;

/**
 * 召回好友
 * 
 * @author amin
 */
public class BackInviteVo {
	/*{"send":10000,"receive":10000}*/
	private int send;// 发起召者赠送筹码
	private int receive;// 初召都赠送筹码
	public int getSend() {
		return send;
	}
	public void setSend(int send) {
		this.send = send;
	}
	public int getReceive() {
		return receive;
	}
	public void setReceive(int receive) {
		this.receive = receive;
	}

	

}
