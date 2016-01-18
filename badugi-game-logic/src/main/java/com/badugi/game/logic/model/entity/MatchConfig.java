package com.badugi.game.logic.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * MatchConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "match_config")
public class MatchConfig extends BaseEntity implements java.io.Serializable {

	// Fields

	public Integer matchConfigId;
	public String matchName;
	public String matchNameDisp;
	public Short cateId1;
	public Short cateId2;
	public Short cateId3;
	public Short matchTypeId;
	public Short blindTypeId;
	public Short blindIncCfgId;
	public Integer tableUserCount;
	public Integer emptyTable;
	public Integer completeTable;
	public Integer minUsersCount;//最少人数
	public Integer maxUsersCount;//最多人数
	public Double registFee;
	public Double serviceFee;
	public String reward;//赏金
	public Double initChip;
	public Integer timeBankInitValue;
	public Integer timeBankIncLevel;
	public Integer timeBankAddSecond;
	public Integer timeBankFinalTable;
	public Integer breakProtectionTimes;
	public String breakProtectionCfg;
	public Short minsPerHour;//每小时第几分钟休息
	public Short minsOfRest;//休息时长(分钟)
	public Integer lastUserCount;
	public Integer moneyUserCount;
	public Integer moneyType;//0:(NULL) Fifty50,1:[{'rk','am'}] 普通,2:[{'rk','tt','am','ti'}] 资格赛,3:[{'from','to','rs':[{'rk','pct'}]}] 普通定时赛,4:{'ck','mgt','mgc','am','rs':[{'rk','ti','tt','am'}]}定时赛多余部分奖品赠送
	public String fixPoints;//固定积分 ft:类型 0普通0.0252倍，1固定积分{'ft','v'}
	public Integer userCustomType;
	public String moneyCfg;
	public Short matchStatus;
	public String remark;
	public String managerName;
	public Timestamp operatedTime;
	public String PassWord;
	public Integer matchId;

	// Constructors

	/** default constructor */
	public MatchConfig() {
	}

	/** minimal constructor */
	public MatchConfig(Short cateId1, Short cateId2, Short cateId3,
			Short matchTypeId, Short blindTypeId, Short blindIncCfgId,
			Integer tableUserCount, Integer emptyTable, Integer completeTable,
			Double registFee, Double serviceFee, Double initChip,
			Integer timeBankInitValue, Integer timeBankIncLevel,
			Integer timeBankAddSecond, Integer timeBankFinalTable,
			Integer breakProtectionTimes, Integer lastUserCount,
			Integer moneyUserCount, Short matchStatus) {
		this.cateId1 = cateId1;
		this.cateId2 = cateId2;
		this.cateId3 = cateId3;
		this.matchTypeId = matchTypeId;
		this.blindTypeId = blindTypeId;
		this.blindIncCfgId = blindIncCfgId;
		this.tableUserCount = tableUserCount;
		this.emptyTable = emptyTable;
		this.completeTable = completeTable;
		this.registFee = registFee;
		this.serviceFee = serviceFee;
		this.initChip = initChip;
		this.timeBankInitValue = timeBankInitValue;
		this.timeBankIncLevel = timeBankIncLevel;
		this.timeBankAddSecond = timeBankAddSecond;
		this.timeBankFinalTable = timeBankFinalTable;
		this.breakProtectionTimes = breakProtectionTimes;
		this.lastUserCount = lastUserCount;
		this.moneyUserCount = moneyUserCount;
		this.matchStatus = matchStatus;
	}

	/** full constructor */
	public MatchConfig(String matchName, String matchNameDisp, Short cateId1,
			Short cateId2, Short cateId3, Short matchTypeId, Short blindTypeId,
			Short blindIncCfgId, Integer tableUserCount, Integer emptyTable,
			Integer completeTable, Integer minUsersCount,
			Integer maxUsersCount, Double registFee, Double serviceFee,
			String reward, Double initChip, Integer timeBankInitValue,
			Integer timeBankIncLevel, Integer timeBankAddSecond,
			Integer timeBankFinalTable, Integer breakProtectionTimes,
			String breakProtectionCfg, Short minsPerHour, Short minsOfRest,
			Integer lastUserCount, Integer moneyUserCount, String moneyCfg,
			Short matchStatus, String remark, String managerName,
			Timestamp operatedTime,String password) {
		this.matchName = matchName;
		this.matchNameDisp = matchNameDisp;
		this.cateId1 = cateId1;
		this.cateId2 = cateId2;
		this.cateId3 = cateId3;
		this.matchTypeId = matchTypeId;
		this.blindTypeId = blindTypeId;
		this.blindIncCfgId = blindIncCfgId;
		this.tableUserCount = tableUserCount;
		this.emptyTable = emptyTable;
		this.completeTable = completeTable;
		this.minUsersCount = minUsersCount;
		this.maxUsersCount = maxUsersCount;
		this.registFee = registFee;
		this.serviceFee = serviceFee;
		this.reward = reward;
		this.initChip = initChip;
		this.timeBankInitValue = timeBankInitValue;
		this.timeBankIncLevel = timeBankIncLevel;
		this.timeBankAddSecond = timeBankAddSecond;
		this.timeBankFinalTable = timeBankFinalTable;
		this.breakProtectionTimes = breakProtectionTimes;
		this.breakProtectionCfg = breakProtectionCfg;
		this.minsPerHour = minsPerHour;
		this.minsOfRest = minsOfRest;
		this.lastUserCount = lastUserCount;
		this.moneyUserCount = moneyUserCount;
		this.moneyCfg = moneyCfg;
		this.matchStatus = matchStatus;
		this.remark = remark;
		this.managerName = managerName;
		this.operatedTime = operatedTime;
		this.PassWord=password;
	}
	
	

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MatchConfigId", unique = true, nullable = false)
	public Integer getMatchConfigId() {
		return this.matchConfigId;
	}

	public void setMatchConfigId(Integer matchConfigId) {
		this.matchConfigId = matchConfigId;
	}

	@Column(name = "MatchName", length = 50)
	public String getMatchName() {
		return this.matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	@Column(name = "MatchNameDisp", length = 50)
	public String getMatchNameDisp() {
		return this.matchNameDisp;
	}

	public void setMatchNameDisp(String matchNameDisp) {
		this.matchNameDisp = matchNameDisp;
	}

	@Column(name = "CateId1", nullable = false)
	public Short getCateId1() {
		return this.cateId1;
	}

	public void setCateId1(Short cateId1) {
		this.cateId1 = cateId1;
	}

	@Column(name = "CateId2", nullable = false)
	public Short getCateId2() {
		return this.cateId2;
	}

	public void setCateId2(Short cateId2) {
		this.cateId2 = cateId2;
	}

	@Column(name = "CateId3", nullable = false)
	public Short getCateId3() {
		return this.cateId3;
	}

	public void setCateId3(Short cateId3) {
		this.cateId3 = cateId3;
	}

	@Column(name = "MatchTypeId", nullable = false)
	public Short getMatchTypeId() {
		return this.matchTypeId;
	}

	public void setMatchTypeId(Short matchTypeId) {
		this.matchTypeId = matchTypeId;
	}

	@Column(name = "BlindTypeId", nullable = false)
	public Short getBlindTypeId() {
		return this.blindTypeId;
	}

	public void setBlindTypeId(Short blindTypeId) {
		this.blindTypeId = blindTypeId;
	}

	@Column(name = "BlindIncCfgId", nullable = false)
	public Short getBlindIncCfgId() {
		return this.blindIncCfgId;
	}

	public void setBlindIncCfgId(Short blindIncCfgId) {
		this.blindIncCfgId = blindIncCfgId;
	}

	@Column(name = "TableUserCount", nullable = false)
	public Integer getTableUserCount() {
		return this.tableUserCount;
	}

	public void setTableUserCount(Integer tableUserCount) {
		this.tableUserCount = tableUserCount;
	}

	@Column(name = "EmptyTable", nullable = false)
	public Integer getEmptyTable() {
		return this.emptyTable;
	}

	public void setEmptyTable(Integer emptyTable) {
		this.emptyTable = emptyTable;
	}

	@Column(name = "CompleteTable", nullable = false)
	public Integer getCompleteTable() {
		return this.completeTable;
	}

	public void setCompleteTable(Integer completeTable) {
		this.completeTable = completeTable;
	}

	@Column(name = "MinUsersCount")
	public Integer getMinUsersCount() {
		return this.minUsersCount;
	}

	public void setMinUsersCount(Integer minUsersCount) {
		this.minUsersCount = minUsersCount;
	}

	@Column(name = "MaxUsersCount")
	public Integer getMaxUsersCount() {
		return this.maxUsersCount;
	}

	public void setMaxUsersCount(Integer maxUsersCount) {
		this.maxUsersCount = maxUsersCount;
	}

	@Column(name = "RegistFee", nullable = false, scale = 4)
	public Double getRegistFee() {
		return this.registFee;
	}

	public void setRegistFee(Double registFee) {
		this.registFee = registFee;
	}

	@Column(name = "ServiceFee", nullable = false, scale = 4)
	public Double getServiceFee() {
		return this.serviceFee;
	}

	public void setServiceFee(Double serviceFee) {
		this.serviceFee = serviceFee;
	}

	@Column(name = "Reward")
	public String getReward() {
		return this.reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	@Column(name = "InitChip", nullable = false, scale = 4)
	public Double getInitChip() {
		return this.initChip;
	}

	public void setInitChip(Double initChip) {
		this.initChip = initChip;
	}

	@Column(name = "TimeBankInitValue", nullable = false)
	public Integer getTimeBankInitValue() {
		return this.timeBankInitValue;
	}

	public void setTimeBankInitValue(Integer timeBankInitValue) {
		this.timeBankInitValue = timeBankInitValue;
	}

	@Column(name = "TimeBankIncLevel", nullable = false)
	public Integer getTimeBankIncLevel() {
		return this.timeBankIncLevel;
	}

	public void setTimeBankIncLevel(Integer timeBankIncLevel) {
		this.timeBankIncLevel = timeBankIncLevel;
	}

	@Column(name = "TimeBankAddSecond", nullable = false)
	public Integer getTimeBankAddSecond() {
		return this.timeBankAddSecond;
	}

	public void setTimeBankAddSecond(Integer timeBankAddSecond) {
		this.timeBankAddSecond = timeBankAddSecond;
	}

	@Column(name = "TimeBankFinalTable", nullable = false)
	public Integer getTimeBankFinalTable() {
		return this.timeBankFinalTable;
	}

	public void setTimeBankFinalTable(Integer timeBankFinalTable) {
		this.timeBankFinalTable = timeBankFinalTable;
	}

	@Column(name = "BreakProtectionTimes", nullable = false)
	public Integer getBreakProtectionTimes() {
		return this.breakProtectionTimes;
	}

	public void setBreakProtectionTimes(Integer breakProtectionTimes) {
		this.breakProtectionTimes = breakProtectionTimes;
	}

	@Column(name = "BreakProtectionCfg", length = 500)
	public String getBreakProtectionCfg() {
		return this.breakProtectionCfg;
	}

	public void setBreakProtectionCfg(String breakProtectionCfg) {
		this.breakProtectionCfg = breakProtectionCfg;
	}

	@Column(name = "MinsPerHour")
	public Short getMinsPerHour() {
		return this.minsPerHour;
	}

	public void setMinsPerHour(Short minsPerHour) {
		this.minsPerHour = minsPerHour;
	}

	@Column(name = "MinsOfRest")
	public Short getMinsOfRest() {
		return this.minsOfRest;
	}

	public void setMinsOfRest(Short minsOfRest) {
		this.minsOfRest = minsOfRest;
	}

	@Column(name = "LastUserCount", nullable = false)
	public Integer getLastUserCount() {
		return this.lastUserCount;
	}

	public void setLastUserCount(Integer lastUserCount) {
		this.lastUserCount = lastUserCount;
	}

	@Column(name = "MoneyUserCount", nullable = false)
	public Integer getMoneyUserCount() {
		return this.moneyUserCount;
	}

	public void setMoneyUserCount(Integer moneyUserCount) {
		this.moneyUserCount = moneyUserCount;
	}
	
	@Column(name = "MoneyType", nullable = false)
	public Integer getMoneyType() {
		return moneyType;
	}
	
	public void setMoneyType(Integer moneyType) {
		this.moneyType = moneyType;
	}
	
	@Column(name = "FixPoints")
	public String getFixPoints() {
		return fixPoints;
	}
	
	public void setFixPoints(String fixPoints) {
		this.fixPoints = fixPoints;
	}
	
	@Column(name = "UserCustomType", nullable = false)
	public Integer getUserCustomType() {
		return userCustomType;
	}
	
	public void setUserCustomType(Integer userCustomType) {
		this.userCustomType = userCustomType;
	}

	@Column(name = "MoneyCfg", length = 10000)
	public String getMoneyCfg() {
		return this.moneyCfg;
	}

	public void setMoneyCfg(String moneyCfg) {
		this.moneyCfg = moneyCfg;
	}

	@Column(name = "MatchStatus", nullable = false)
	public Short getMatchStatus() {
		return this.matchStatus;
	}

	public void setMatchStatus(Short matchStatus) {
		this.matchStatus = matchStatus;
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
	
	
	@Column(name = "PassWord", length = 11)
	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	@Transient
	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

}