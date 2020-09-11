package com.bean.inventory;/*
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
 * stock
 * 
 * @author bianj
 * @version 1.0.0 2020-07-18
 */
public class Stock implements java.io.Serializable {


    @Override
    public String toString() {
        return "Stock{" +
                "expiration='" + expiration + '\'' +
                ", stockid=" + stockid +
                ", inid=" + inid +
                ", quantity='" + quantity + '\'' +
                ", warehouseId=" + warehouseId +
                ", gid=" + gid +
                ", produced=" + produced +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = -4637622128649823752L;

    /** 保质期**/
    private String expiration;

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpiration() {
        return expiration;
    }

    /** 库存编号 */
    private Integer stockid;

    /** 入库编号 */
    private Integer inid;

    /** 库存量 */
    private String quantity;

    /** 仓库名称 */
    private Integer warehouseId;

    /** 商品编号 */
    private Integer gid;

    /** 生产日期 */
    private Timestamp produced;

    /**
     * 获取库存编号
     *
     * @return 库存编号
     */
    public Integer getStockid() {
        return stockid;
    }

    /**
     * 设置库存编号
     *
     * @param stockid
     *          库存编号
     */
    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    /**
     * 获取入库编号
     *
     * @return 入库编号
     */
    public Integer getInid() {
        return this.inid;
    }

    /**
     * 设置入库编号
     *
     * @param inid
     *          入库编号
     */
    public void setInid(Integer inid) {
        this.inid = inid;
    }

    /**
     * 获取库存量
     *
     * @return 库存量
     */
    public String getQuantity() {
        return this.quantity;
    }

    /**
     * 设置库存量
     *
     * @param quantity
     *          库存量
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取仓库名称
     *
     * @return 仓库名称
     */
    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    /**
     * 设置仓库名称
     *
     * @param warehouseId
     *          仓库名称
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取商品编号
     *
     * @return 商品编号
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置商品编号
     *
     * @param gid
     *          商品编号
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取入库日期
     *
     * @return 入库日期
     */
    public Timestamp getProduced() {
        return produced;
    }

    /**
     * 设置入库日期
     *
     * @param produced
     *          入库日期
     */
    public void setProduced(Timestamp produced) {
        this.produced = produced;
    }
}