package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MatchtypeConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "matchtype_config")
public class MatchtypeConfig extends BaseEntity implements java.io.Serializable {

	/**
	 * 单桌
	 */
	public static final Short TALBETYPE_ONE = 0;
	
	/**
	 * 多桌
	 */
	public static final Short TALBETYPE_MORE = 1;
	
	/**
	 * knockout
	 */
	public static final Integer SPECIALOP_KO = 0;
	
	/**
	 * 明星赏金
	 */
	public static final Integer SPECIALOP_STAR = 1;
	
	/**
	 * 特殊赏金
	 */
	public static final Integer SPECIALOP_OPEC = 2;
	
	
	// Fields

	private Short matchTypeId;
	private String matchTypeName;
	private String matchTypeNameDisp;
	private Short tableType;
	private Short openType;
	private Short userLimit;
	private Short closeType;
	private Short beginType;
	private Short winType;
	private Short isTimeBank;
	private Short isBreakProtection;
	private Short isHalfTime;
	private Short isSyncDeal;
	private Short isDelayRegist;
	private Short isAddChip;
	private Short isFinalChip;
	private String registType;
	private String specialOption;
	private Short bonusBasicConfig;
	private Short bonusConfig;
	private String remark;
	private String managerName;
	private Timestamp operatedTime;

	// Constructors

	/** default constructor */
	public MatchtypeConfig() {
	}

	/** minimal constructor */
	public MatchtypeConfig(Short tableType, Short openType, Short userLimit,
			Short closeType, Short beginType, Short winType, Short isTimeBank,
			Short isBreakProtection, Short isHalfTime, Short isSyncDeal,
			Short isDelayRegist, Short isAddChip, Short isFinalChip,
			Short bonusBasicConfig, Short bonusConfig) {
		this.tableType = tableType;
		this.openType = openType;
		this.userLimit = userLimit;
		this.closeType = closeType;
		this.beginType = beginType;
		this.winType = winType;
		this.isTimeBank = isTimeBank;
		this.isBreakProtection = isBreakProtection;
		this.isHalfTime = isHalfTime;
		this.isSyncDeal = isSyncDeal;
		this.isDelayRegist = isDelayRegist;
		this.isAddChip = isAddChip;
		this.isFinalChip = isFinalChip;
		this.bonusBasicConfig = bonusBasicConfig;
		this.bonusConfig = bonusConfig;
	}

	/** full constructor */
	public MatchtypeConfig(String matchTypeName, String matchTypeNameDisp,
			Short tableType, Short openType, Short userLimit, Short closeType,
			Short beginType, Short winType, Short isTimeBank,
			Short isBreakProtection, Short isHalfTime, Short isSyncDeal,
			Short isDelayRegist, Short isAddChip, Short isFinalChip,
			String registType, String specialOption, Short bonusBasicConfig,
			Short bonusConfig, String remark, String managerName,
			Timestamp operatedTime) {
		this.matchTypeName = matchTypeName;
		this.matchTypeNameDisp = matchTypeNameDisp;
		this.tableType = tableType;
		this.openType = openType;
		this.userLimit = userLimit;
		this.closeType = closeType;
		this.beginType = beginType;
		this.winType = winType;
		this.isTimeBank = isTimeBank;
		this.isBreakProtection = isBreakProtection;
		this.isHalfTime = isHalfTime;
		this.isSyncDeal = isSyncDeal;
		this.isDelayRegist = isDelayRegist;
		this.isAddChip = isAddChip;
		this.isFinalChip = isFinalChip;
		this.registType = registType;
		this.specialOption = specialOption;
		this.bonusBasicConfig = bonusBasicConfig;
		this.bonusConfig = bonusConfig;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MatchTypeId", unique = true, nullable = false)
	public Short getMatchTypeId() {
		return this.matchTypeId;
	}

	public void setMatchTypeId(Short matchTypeId) {
		this.matchTypeId = matchTypeId;
	}

	@Column(name = "MatchTypeName", length = 50)
	public String getMatchTypeName() {
		return this.matchTypeName;
	}

	public void setMatchTypeName(String matchTypeName) {
		this.matchTypeName = matchTypeName;
	}

	@Column(name = "MatchTypeNameDisp", length = 50)
	public String getMatchTypeNameDisp() {
		return this.matchTypeNameDisp;
	}

	public void setMatchTypeNameDisp(String matchTypeNameDisp) {
		this.matchTypeNameDisp = matchTypeNameDisp;
	}

	@Column(name = "TableType", nullable = false)
	public Short getTableType() {
		return this.tableType;
	}

	public void setTableType(Short tableType) {
		this.tableType = tableType;
	}

	@Column(name = "OpenType", nullable = false)
	public Short getOpenType() {
		return this.openType;
	}

	public void setOpenType(Short openType) {
		this.openType = openType;
	}

	@Column(name = "UserLimit", nullable = false)
	public Short getUserLimit() {
		return this.userLimit;
	}

	public void setUserLimit(Short userLimit) {
		this.userLimit = userLimit;
	}

	@Column(name = "CloseType", nullable = false)
	public Short getCloseType() {
		return this.closeType;
	}

	public void setCloseType(Short closeType) {
		this.closeType = closeType;
	}

	@Column(name = "BeginType", nullable = false)
	public Short getBeginType() {
		return this.beginType;
	}

	public void setBeginType(Short beginType) {
		this.beginType = beginType;
	}

	@Column(name = "WinType", nullable = false)
	public Short getWinType() {
		return this.winType;
	}

	public void setWinType(Short winType) {
		this.winType = winType;
	}

	@Column(name = "IsTimeBank", nullable = false)
	public Short getIsTimeBank() {
		return this.isTimeBank;
	}

	public void setIsTimeBank(Short isTimeBank) {
		this.isTimeBank = isTimeBank;
	}

	@Column(name = "IsBreakProtection", nullable = false)
	public Short getIsBreakProtection() {
		return this.isBreakProtection;
	}

	public void setIsBreakProtection(Short isBreakProtection) {
		this.isBreakProtection = isBreakProtection;
	}

	@Column(name = "IsHalfTime", nullable = false)
	public Short getIsHalfTime() {
		return this.isHalfTime;
	}

	public void setIsHalfTime(Short isHalfTime) {
		this.isHalfTime = isHalfTime;
	}

	@Column(name = "IsSyncDeal", nullable = false)
	public Short getIsSyncDeal() {
		return this.isSyncDeal;
	}

	public void setIsSyncDeal(Short isSyncDeal) {
		this.isSyncDeal = isSyncDeal;
	}

	@Column(name = "IsDelayRegist", nullable = false)
	public Short getIsDelayRegist() {
		return this.isDelayRegist;
	}

	public void setIsDelayRegist(Short isDelayRegist) {
		this.isDelayRegist = isDelayRegist;
	}

	@Column(name = "IsAddChip", nullable = false)
	public Short getIsAddChip() {
		return this.isAddChip;
	}

	public void setIsAddChip(Short isAddChip) {
		this.isAddChip = isAddChip;
	}

	@Column(name = "IsFinalChip", nullable = false)
	public Short getIsFinalChip() {
		return this.isFinalChip;
	}

	public void setIsFinalChip(Short isFinalChip) {
		this.isFinalChip = isFinalChip;
	}

	@Column(name = "RegistType", length = 100)
	public String getRegistType() {
		return this.registType;
	}

	public void setRegistType(String registType) {
		this.registType = registType;
	}

	@Column(name = "SpecialOption", length = 100)
	public String getSpecialOption() {
		return this.specialOption;
	}

	public void setSpecialOption(String specialOption) {
		this.specialOption = specialOption;
	}

	@Column(name = "BonusBasicConfig", nullable = false)
	public Short getBonusBasicConfig() {
		return this.bonusBasicConfig;
	}

	public void setBonusBasicConfig(Short bonusBasicConfig) {
		this.bonusBasicConfig = bonusBasicConfig;
	}

	@Column(name = "BonusConfig", nullable = false)
	public Short getBonusConfig() {
		return this.bonusConfig;
	}

	public void setBonusConfig(Short bonusConfig) {
		this.bonusConfig = bonusConfig;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "ManagerName", length = 50)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "OperatedTime", length = 19)
	public Timestamp getOperatedTime() {
		return this.operatedTime;
	}

	public void setOperatedTime(Timestamp operatedTime) {
		this.operatedTime = operatedTime;
	}

}