package com.beanvo;/*
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
 * inventory
 * 
 * @author bianj
 * @version 1.0.0 2020-06-21
 */
public class InventoryVo implements java.io.Serializable {
    @Override
    public String toString() {
        return "InventoryVo{" +
                "selected=" + selected +
                ", inventoryid=" + inventoryid +
                ", inid=" + inid +
                ", gid='" + gid + '\'' +
                ", model='" + model + '\'' +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", quantity='" + quantity + '\'' +
                ", cometime=" + cometime +
                ", inperid=" + inperid +
                ", stockroom=" + stockroom +
                '}';
    }

    /** 选中 **/
    private boolean selected;
    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    /** 版本号 */
    private static final long serialVersionUID = 693043893811301911L;

    /** 库存编号 */
    private Integer inventoryid;

    /** 入库编号 */
    private Integer inid;

    /** 商品编号 */
    private Integer gid;

    /** 商品规格 */
    private String model;

    /** 商品名称 */
    private String gname;

    /** 单价 */
    private Double price;

    /** 库存量 */
    private String quantity;

    /** 入库日期 */
    private Timestamp cometime;

    /** 入库操作人员id */
    private Integer inperid;

    /** 仓库编号 */
    private Integer stockroom;

    /**
     * 获取库存编号
     *
     * @return 库存编号
     */
    public Integer getInventoryid() {
        return this.inventoryid;
    }

    /**
     * 设置库存编号
     *
     * @param inventoryid
     *          库存编号
     */
    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
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
     * 获取商品规格
     *
     * @return 商品规格
     */
    public String getModel() {
        return this.model;
    }

    /**
     * 设置商品规格
     *
     * @param model
     *          商品规格
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取商品名称
     *
     * @return 商品名称
     */
    public String getGname() {
        return this.gname;
    }

    /**
     * 设置商品名称
     *
     * @param gname
     *          商品名称
     */
    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * 获取单价
     *
     * @return 单价
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * 设置单价
     *
     * @param price
     *          单价
     */
    public void setPrice(Double price) {
        this.price = price;
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
     * 获取入库日期
     *
     * @return 入库日期
     */
    public Timestamp getCometime() {
        return this.cometime;
    }

    /**
     * 设置入库日期
     *
     * @param cometime
     *          入库日期
     */
    public void setCometime(Timestamp cometime) {
        this.cometime = cometime;
    }

    /**
     * 获取入库操作人员id
     *
     * @return 入库操作人员id
     */
    public Integer getInperid() {
        return this.inperid;
    }

    /**
     * 设置入库操作人员id
     *
     * @param inperid
     *          入库操作人员id
     */
    public void setInperid(Integer inperid) {
        this.inperid = inperid;
    }

    /**
     * 获取仓库编号
     *
     * @return 仓库编号
     */
    public Integer getStockroom() {
        return this.stockroom;
    }

    /**
     * 设置仓库编号
     *
     * @param stockroom
     *          仓库编号
     */
    public void setStockroom(Integer stockroom) {
        this.stockroom = stockroom;
    }
}