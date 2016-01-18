package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserLoginLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_login_log")
public class UserLoginLog extends BaseEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long fbId;
	private Short logType = 1;//默认在大厅登陆
	private Timestamp loginTime;
	private Timestamp logoutTime;
	private String ip;
	private Integer roomId;
	private String cuid;
	private String openkey;
	private String pf;
	private String pfkey;
	private Integer ret;
	private Integer is_lost;
	private String msg;

	// Constructors

	/** default constructor */
	public UserLoginLog() {
	}

	/** minimal constructor */
	public UserLoginLog(Long fbId, Short logType, Timestamp loginTime) {
		this.fbId = fbId;
		this.logType = logType;
		this.loginTime = loginTime;
	}

	/** full constructor */
	public UserLoginLog(Long fbId, Short logType, Timestamp loginTime,
			Timestamp logoutTime, String ip, Integer roomId, String cuid) {
		this.fbId = fbId;
		this.logType = logType;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.ip = ip;
		this.roomId = roomId;
		this.cuid = cuid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "FbId", nullable = false)
	public Long getFbId() {
		return this.fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	@Column(name = "LogType", nullable = false)
	public Short getLogType() {
		return this.logType;
	}

	public void setLogType(Short logType) {
		this.logType = logType;
	}

	@Column(name = "LoginTime", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "LogoutTime", length = 19)
	public Timestamp getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	@Column(name = "IP", length = 45)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "RoomID")
	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "CUID", length = 50)
	public String getCuid() {
		return this.cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	@Column(name = "openkey")
	public String getOpenkey() {
		return openkey;
	}

	public void setOpenkey(String openkey) {
		this.openkey = openkey;
	}
	@Column(name = "pf")
	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}
	@Column(name = "pfkey")
	public String getPfkey() {
		return pfkey;
	}

	public void setPfkey(String pfkey) {
		this.pfkey = pfkey;
	}
	@Column(name = "ret")
	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}
	@Column(name = "is_lost")
	public Integer getIs_lost() {
		return is_lost;
	}

	public void setIs_lost(Integer isLost) {
		is_lost = isLost;
	}
	@Column(name = "msg")
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}