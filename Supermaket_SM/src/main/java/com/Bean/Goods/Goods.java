package com.Bean.Goods;
/**
 * goods
 * 
 * @author bianj
 * @version 1.0.0 2020-06-11
 */
public class Goods implements java.io.Serializable {

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", merchid='" + merchid + '\'' +
                ", gname='" + gname + '\'' +
                ", bClass=" + bClass +
                ", money=" + money +
                ", gaddr='" + gaddr + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = 4282945076611091084L;

    /** 商品编号 */
    private Integer id;

    /** 商品条形码 */
    private String merchid;

    /** 名称 */
    private String gname;

    /** 类别编号 */
    private Integer bClass;

    /** 出售价格 */
    private Double money;

    /** 商品产地 */
    private String gaddr;

    /**
     * 获取商品编号
     *
     * @return 商品编号
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置商品编号
     *
     * @param id
     *          商品编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品条形码
     *
     * @return 商品条形码
     */
    public String getMerchid() {
        return this.merchid;
    }

    /**
     * 设置商品条形码
     *
     * @param merchid
     *          商品条形码
     */
    public void setMerchid(String merchid) {
        this.merchid = merchid;
    }

    /**
     * 获取名称
     *
     * @return 名称
     */
    public String getGname() {
        return this.gname;
    }

    /**
     * 设置名称
     *
     * @param gname
     *          名称
     */
    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * 获取类别编号
     *
     * @return 类别编号
     */
    public Integer getBClass() {
        return this.bClass;
    }

    /**
     * 设置类别编号
     *
     * @param bClass
     *          类别编号
     */
    public void setBClass(Integer bClass) {
        this.bClass = bClass;
    }

    /**
     * 获取出售价格
     *
     * @return 出售价格
     */
    public Double getMoney() {
        return this.money;
    }

    /**
     * 设置出售价格
     *
     * @param money
     *          出售价格
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取商品产地
     *
     * @return 商品产地
     */
    public String getGaddr() {
        return this.gaddr;
    }

    /**
     * 设置商品产地
     *
     * @param gaddr
     *          商品产地
     */
    public void setGaddr(String gaddr) {
        this.gaddr = gaddr;
    }
}