package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EntranceTicket entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entrance_ticket")
public class EntranceTicket extends BaseEntity implements java.io.Serializable {

	/**
	 * 是否固定周期
	 */
	public static final Short ISFIX_TRUE = 1;
	/**
	 * 不是固定周期
	 */
	public static final Short ISFIX_FALSE = 0;
	/**
	 * 商场是否可购买：1是
	 */
	public static final Short ISCANBUY_TRUE = 1;
	/**
	 * 商场是否可购买：0否
	 */
	public static final Short ISCANBUY_FALSE = 0;
	/**
	 * 类型:0门票
	 */
	public static final Short TYPE_TICKET = 0;
	/**
	 * 类型:1充值卡
	 */
	public static final Short TYPE_CARD = 1;
	/**
	 * 类型:2实物
	 */
	public static final Short TYPE_ENTITY = 2;
	/**
	 * 类型:4饰品
	 */
	public static final Short TYPE_DECORATE = 4;
	/**
	 * 所属类型:1坐满就玩
	 */
	public static final Short CATE_1 = 1;
	/**
	 * 所属类型:2锦标赛
	 */
	public static final Short CATE_2 = 2;


	// Fields

	private Integer id;
	private String name;
	private Short isCanBuy;
	private Double chips;
	private Double thaiValue;
	private Short isFix;
	private Timestamp validFrom;
	private Timestamp validTo;
	private Integer howLong;
	private Short entranceType;
	private Short myCate;
	private Timestamp createTime;
	private String imageName;
	private String smallImagename;

	// Constructors

	/** default constructor */
	public EntranceTicket() {
	}

	/** minimal constructor */
	public EntranceTicket(String name, Short isCanBuy, Double chips,
			Timestamp validFrom, Timestamp validTo, Timestamp createTime) {
		this.name = name;
		this.isCanBuy = isCanBuy;
		this.chips = chips;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.createTime = createTime;
	}

	/** full constructor */
	public EntranceTicket(String name, Short isCanBuy,
			Double chips, Short isFix, Timestamp validFrom, Timestamp validTo,
			Integer howLong, Short entranceType, Short myCate,
			Timestamp createTime, String imageName, String smallImagename) {
		super();
		this.name = name;
		this.isCanBuy = isCanBuy;
		this.chips = chips;
		this.isFix = isFix;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.howLong = howLong;
		this.entranceType = entranceType;
		this.myCate = myCate;
		this.createTime = createTime;
		this.imageName = imageName;
		this.smallImagename = smallImagename;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IsCanBuy", nullable = false)
	public Short getIsCanBuy() {
		return this.isCanBuy;
	}

	public void setIsCanBuy(Short isCanBuy) {
		this.isCanBuy = isCanBuy;
	}

	@Column(name = "Chips", nullable = false, scale = 4)
	public Double getChips() {
		return this.chips;
	}

	public void setChips(Double chips) {
		this.chips = chips;
	}
	
	@Column(name = "IsFix", nullable = false)
	public Short getIsFix() {
		return isFix;
	}
	
	public void setIsFix(Short isFix) {
		this.isFix = isFix;
	}

	@Column(name = "ValidFrom", length = 19)
	public Timestamp getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	@Column(name = "ValidTo", length = 19)
	public Timestamp getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}

	@Column(name = "HowLong")
	public Integer getHowLong() {
		return howLong;
	}
	
	public void setHowLong(Integer howLong) {
		this.howLong = howLong;
	}
	
	@Column(name = "EntranceType", nullable = false)
	public Short getEntranceType() {
		return entranceType;
	}
	
	public void setEntranceType(Short entranceType) {
		this.entranceType = entranceType;
	}
	
	@Column(name = "MyCate")
	public Short getMyCate() {
		return myCate;
	}
	
	public void setMyCate(Short myCate) {
		this.myCate = myCate;
	}

	@Column(name = "CreateTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "imageName", length = 50)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Column(name = "SmallImagename", length = 50)
	public String getSmallImagename() {
		return smallImagename;
	}
	
	public void setSmallImagename(String smallImagename) {
		this.smallImagename = smallImagename;
	}
	
	@Column(name = "ThaiValue", nullable = false, scale = 4)
	public Double getThaiValue() {
		return thaiValue;
	}
	
	public void setThaiValue(Double thaiValue) {
		this.thaiValue = thaiValue;
	}


}