package com.badugi.game.logic.model.vo.supreme;

import java.io.Serializable;

public class PlayerWinVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long playerfbId;
	private String fbName;
	private String imageUrl;
	private Long winChips;
	private Integer isRobot;
	private Long commission;

	public PlayerWinVo() {
	}

	public PlayerWinVo(Long playerfbId, String fbName, String imageUrl, Long winChips) {
		this.playerfbId = playerfbId;
		this.fbName = fbName;
		this.imageUrl = imageUrl;
		this.winChips = winChips;
	}

	public Long getPlayerfbId() {
		return playerfbId;
	}

	public void setPlayerfbId(Long playerfbId) {
		this.playerfbId = playerfbId;
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

	public Long getWinChips() {
		return winChips;
	}

	public void setWinChips(Long winChips) {
		this.winChips = winChips;
	}

	public Integer getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(Integer isRobot) {
		this.isRobot = isRobot;
	}

	public Long getCommission() {
		return commission;
	}

	public void setCommission(Long commission) {
		this.commission = commission;
	}

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayerWinVo [playerfbId=" + playerfbId + ", fbName=" + fbName
				+ ", imageUrl=" + imageUrl + ", winChips=" + winChips
				+ ", isRobot=" + isRobot + ", commission=" + commission + "]";
	}
	
	

}
