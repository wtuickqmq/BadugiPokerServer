package com.badugi.game.logic.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * CardExchangeChipsLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="card_exchange_chips_log")
public class CardExchangeChipsLog  extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Long fbid;
     private Double ownerValue;
     private Double value;
     private Double chips;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public CardExchangeChipsLog() {
    }

	/** minimal constructor */
    public CardExchangeChipsLog(Long fbid, Double value, Double chips, Timestamp createTime) {
        this.fbid = fbid;
        this.value = value;
        this.chips = chips;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public CardExchangeChipsLog(Long fbid, Double ownerValue, Double value, Double chips, Timestamp createTime) {
        this.fbid = fbid;
        this.ownerValue = ownerValue;
        this.value = value;
        this.chips = chips;
        this.createTime = createTime;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="Id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="Fbid", nullable=false)

    public Long getFbid() {
        return this.fbid;
    }
    
    public void setFbid(Long fbid) {
        this.fbid = fbid;
    }
    
    @Column(name="OwnerValue", scale=4)

    public Double getOwnerValue() {
        return this.ownerValue;
    }
    
    public void setOwnerValue(Double ownerValue) {
        this.ownerValue = ownerValue;
    }
    
    @Column(name="value", nullable=false, scale=4)

    public Double getValue() {
        return this.value;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }
    
    @Column(name="chips", nullable=false, scale=4)

    public Double getChips() {
        return this.chips;
    }
    
    public void setChips(Double chips) {
        this.chips = chips;
    }
    
    @Column(name="CreateTime", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
   








}