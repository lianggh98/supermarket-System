package com.Bean.Buy;

/**
 * model
 * 
 * @author bianj
 * @version 1.0.0 2020-07-14
 */
public class Model implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2517350064192000204L;

    /** 规格编号 */
    private Integer mId;

    /** 规格名 */
    private String mName;

    /**
     * 获取规格编号
     * 
     * @return 规格编号
     */
    public Integer getMId() {
        return this.mId;
    }

    /**
     * 设置规格编号
     * 
     * @param mId
     *          规格编号
     */
    public void setMId(Integer mId) {
        this.mId = mId;
    }

    /**
     * 获取规格名
     * 
     * @return 规格名
     */
    public String getMName() {
        return this.mName;
    }

    /**
     * 设置规格名
     * 
     * @param mName
     *          规格名
     */
    public void setMName(String mName) {
        this.mName = mName;
    }
}