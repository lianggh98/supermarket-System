package com.Bean.Buy;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://www.tablego.cn
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author: bianj
 * Email: tablego@qq.com
 * Version: 6.8.0
 */
import java.sql.Timestamp;

/**
 * buy
 * 
 * @author bianj
 * @version 1.0.0 2020-07-17
 */
public class Buy implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 8064735027355732924L;

    /** ID */
    private Integer buyid;

    /** 物品id */
    private Integer gid;

    /** 进货日期 */
    private Timestamp comeTime;

    /** 规格型号 */
    private String model;

    /** 数量 */
    private String quantity;

    /** 进货价格 */
    private Double price;

    /** 总价 */
    private Double prices;

    /** 生产日期 */
    private Timestamp produced;

    /** 进货商id */
    private Integer supplier;

    /** 采购人员id */
    private Integer pid;

    /** 保质期 */
    private String expiration;

    /**
     * 获取ID
     * 
     * @return ID
     */
    public Integer getBuyid() {
        return this.buyid;
    }

    /**
     * 设置ID
     * 
     * @param buyid
     *          ID
     */
    public void setBuyid(Integer buyid) {
        this.buyid = buyid;
    }

    /**
     * 获取物品id
     * 
     * @return 物品id
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置物品id
     * 
     * @param gid
     *          物品id
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取进货日期
     * 
     * @return 进货日期
     */
    public Timestamp getComeTime() {
        return this.comeTime;
    }

    /**
     * 设置进货日期
     * 
     * @param comeTime
     *          进货日期
     */
    public void setComeTime(Timestamp comeTime) {
        this.comeTime = comeTime;
    }

    /**
     * 获取规格型号
     * 
     * @return 规格型号
     */
    public String getModel() {
        return this.model;
    }

    /**
     * 设置规格型号
     * 
     * @param model
     *          规格型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取数量
     * 
     * @return 数量
     */
    public String getQuantity() {
        return this.quantity;
    }

    /**
     * 设置数量
     * 
     * @param quantity
     *          数量
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取进货价格
     * 
     * @return 进货价格
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * 设置进货价格
     * 
     * @param price
     *          进货价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取总价
     * 
     * @return 总价
     */
    public Double getPrices() {
        return this.prices;
    }

    /**
     * 设置总价
     * 
     * @param prices
     *          总价
     */
    public void setPrices(Double prices) {
        this.prices = prices;
    }

    /**
     * 获取生产日期
     * 
     * @return 生产日期
     */
    public Timestamp getProduced() {
        return this.produced;
    }

    /**
     * 设置生产日期
     * 
     * @param produced
     *          生产日期
     */
    public void setProduced(Timestamp produced) {
        this.produced = produced;
    }

    /**
     * 获取进货商id
     * 
     * @return 进货商id
     */
    public Integer getSupplier() {
        return this.supplier;
    }

    /**
     * 设置进货商id
     * 
     * @param supplier
     *          进货商id
     */
    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    /**
     * 获取采购人员id
     * 
     * @return 采购人员id
     */
    public Integer getPid() {
        return this.pid;
    }

    /**
     * 设置采购人员id
     * 
     * @param pid
     *          采购人员id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取保质期
     * 
     * @return 保质期
     */
    public String getExpiration() {
        return this.expiration;
    }

    /**
     * 设置保质期
     * 
     * @param expiration
     *          保质期
     */
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}