package com.bean.buy;
import java.sql.Timestamp;

/**
 * intable
 * 
 * @author bianj
 * @version 1.0.0 2020-07-18
 */
public class Intable implements java.io.Serializable {
    @Override
    public String toString() {
        return "Intable{" +
                "inid=" + inid +
                ", buyid=" + buyid +
                ", gid=" + gid +
                ", cometime=" + cometime +
                ", inPerid=" + inPerid +
                ", inStockroom=" + inStockroom +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = -289023032579009666L;

    /** 入库id */
    private Integer inid;

    /** 进货id */
    private Integer buyid;

    /** 商品id */
    private Integer gid;

    /** 入库日期 */
    private Timestamp cometime;

    /**  入库操作人员编号 */
    private Integer inPerid;

    /** 仓库编号 */
    private Integer inStockroom;

    /** 数量 */
    private String quantity;

    /**
     * 获取入库id
     *
     * @return 入库id
     */
    public Integer getInid() {
        return this.inid;
    }

    /**
     * 设置入库id
     *
     * @param inid
     *          入库id
     */
    public void setInid(Integer inid) {
        this.inid = inid;
    }

    /**
     * 获取进货id
     *
     * @return 进货id
     */
    public Integer getBuyid() {
        return this.buyid;
    }

    /**
     * 设置进货id
     *
     * @param buyid
     *          进货id
     */
    public void setBuyid(Integer buyid) {
        this.buyid = buyid;
    }

    /**
     * 获取商品id
     *
     * @return 商品id
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置商品id
     *
     * @param gid
     *          商品id
     */
    public void setGid(Integer gid) {
        this.gid = gid;
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
     * 获取 入库操作人员编号
     *
     * @return  入库操作人员编号
     */
    public Integer getInPerid() {
        return this.inPerid;
    }

    /**
     * 设置 入库操作人员编号
     *
     * @param inPerid
     *           入库操作人员编号
     */
    public void setInPerid(Integer inPerid) {
        this.inPerid = inPerid;
    }

    /**
     * 获取仓库编号
     *
     * @return 仓库编号
     */
    public Integer getInStockroom() {
        return this.inStockroom;
    }

    /**
     * 设置仓库编号
     *
     * @param inStockroom
     *          仓库编号
     */
    public void setInStockroom(Integer inStockroom) {
        this.inStockroom = inStockroom;
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
}