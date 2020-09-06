package com.BeanVo;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.sql.Timestamp;

/**
 * stock
 * 
 * @author bianj
 * @version 1.0.0 2020-06-17
 */
public class BuyVo extends RecursiveTreeObject<BuyVo> implements java.io.Serializable {


    @Override
    public String toString() {
        return "BuyVo{" +
                "selected=" + selected +
                ", gname='" + gname + '\'' +
                ", supname='" + supname + '\'' +
                ", pname='" + pname + '\'' +
                ", buyid=" + buyid +
                ", gid=" + gid +
                ", comeTime=" + comeTime +
                ", model=" + model +
                ", pid=" + pid +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                ", prices=" + prices +
                ", produced=" + produced +
                ", supplier=" + supplier +
                '}';
    }

    /**选中**/
    private Boolean selected=false;

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    /**保质期**/
    private String expiration;

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpiration() {
        return expiration;
    }

    /** 商品名称**/
    private String gname;

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGname() {
        return gname;
    }

    /** 进货商名称**/
    private String supname;

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getSupname() {
        return supname;
    }

    /**采购人员**/
    private String pname;

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }

    /** 版本号 */
    private static final long serialVersionUID = 7797017553825281737L;

    /** ID */
    private Integer buyid;

    /** 物品id */
    private Integer gid;

    /** 进货日期 */
    private Timestamp comeTime;

    /** 规格型号 */
    private String model;

    /** 人员编号**/
    private Integer pid;
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
     *
     *  设置人员编号
     *
     *
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }
}