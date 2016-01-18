package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

import com.badugi.game.logic.helper.LobbyUserHelper;

public class DealerStatus  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;//庄家信息命令
	private Long fbId;//庄家ID
	private String fbName;
	private String imageUrl;
	/**
	 * wtu.add 2015-11-26 
	 * 增加 vip等级，和礼物图片
	 */
	private String  viplv;
	private String  adorn;
	private boolean robot;
	private Double lobbyLeftChips;//大厅剩余筹码
	private Long upDealerChips;//上庄筹码 当前庄家上庄次数,仅保存当前唯一庄家信息
	private Integer inning; //连续上庄次数
	private Integer limitInning;//连庄上限局数
	private boolean isButtonEnable;//下庄按钮是否可用
	private boolean nextDownDealer;//下局是否下庄
    private Integer wining = 0; //庄家当前连赢局数
	
    public DealerStatus(){}
	
    public DealerStatus(Long fbId,String fbName,String imageUrl,boolean robot,Double lobbyLeftChips,Long upDealerChips,Integer inning,Integer limitLnning,boolean isButtonEnable,boolean nextDownDealer){
		this.fbId = fbId;
		this.fbName =fbName;
		this.imageUrl = imageUrl;
		this.inning = inning;
		this.robot = robot;
		this.lobbyLeftChips = lobbyLeftChips;
		this.upDealerChips = upDealerChips;
		this.isButtonEnable = isButtonEnable;
		this.limitInning = limitLnning;
		this.nextDownDealer = nextDownDealer;
		InitVipAndAdorn();
	}
    private void InitVipAndAdorn()
    {
    	try {
    		this.viplv=LobbyUserHelper.getUserVipLv(this.fbId).toString();
        	this.adorn=LobbyUserHelper.getUserAdron(this.fbId);
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
    	
    	
    }

	public DealerStatus(Long fbId,String fbName,String imageUrl,boolean robot,Double lobbyLeftChips,Long upDealerChips,Integer inning,Integer limitLnning,boolean isButtonEnable,boolean nextDownDealer,Integer wining){
		this(fbId, fbName, imageUrl, robot, lobbyLeftChips, upDealerChips, inning, limitLnning, isButtonEnable, nextDownDealer);
		this.wining = wining;
	}
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public Long getFbId() {
		return fbId;
	}
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}
	public Double getLobbyLeftChips() {
		return lobbyLeftChips;
	}
	public void setLobbyLeftChips(Double lobbyLeftChips) {
		this.lobbyLeftChips = lobbyLeftChips;
	}
	public Integer getInning() {
		return inning;
	}
	public void setInning(Integer inning) {
		this.inning = inning;
	}
	public boolean isButtonEnable() {
		return isButtonEnable;
	}
	public void setButtonEnable(boolean isButtonEnable) {
		this.isButtonEnable = isButtonEnable;
	}
	public Long getUpDealerChips() {
		return upDealerChips;
	}
	public void setUpDealerChips(Long upDealerChips) {
		this.upDealerChips = upDealerChips;
	}
	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getLimitInning() {
		return limitInning;
	}
	public boolean isRobot() {
		return robot;
	}
	public void setRobot(boolean robot) {
		this.robot = robot;
	}
	
	
	/**
	 * @return viplv
	 */
	public String getViplv() {
		return viplv;
	}

	/**
	 * @param viplv 要设置的 viplv
	 */
	public void setViplv(String viplv) {
		this.viplv = viplv;
	}

	/**
	 * @return adorn
	 */
	public String getAdorn() {
		return adorn;
	}

	/**
	 * @param adorn 要设置的 adorn
	 */
	public void setAdorn(String adorn) {
		this.adorn = adorn;
	}

	public void setLimitInning(Integer limitLnning) {
		this.limitInning = limitLnning;
	}
	public boolean isNextDownDealer() {
		return nextDownDealer;
	}
	public void setNextDownDealer(boolean nextDownDealer) {
		this.nextDownDealer = nextDownDealer;
	}
        public void setWining(Integer wining) {
            this.wining = wining;
        }
        public Integer getWining() {
            return wining;
        }
        
}
