package com.BeanVo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.sql.Timestamp;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/16 14:22
 * @Version 1.0
 **/
public class StockVo extends RecursiveTreeObject<StockVo> {
    /** 选中 **/
    private Boolean selected=false;

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    /**商品名称**/
    private String gname;
    public void setGname(String gname) {
        this.gname = gname;
    }
    public String getGname() {
        return gname;
    }

    /**仓库名称**/
    private String wname;

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWname() {
        return wname;
    }

    /** 保质期**/
    private String expiration;
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    public String getExpiration() {
        return expiration;
    }


    @Override
    public String toString() {
        return "StockVo{" +
                "selected=" + selected +
                ", gname='" + gname + '\'' +
                ", wname='" + wname + '\'' +
                ", expiration='" + expiration + '\'' +
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

    /** 入库日期 */
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
