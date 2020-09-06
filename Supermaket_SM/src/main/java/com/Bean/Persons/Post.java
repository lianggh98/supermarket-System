package com.Bean.Persons;
/**
 * post
 * 
 * @author bianj
 * @version 1.0.0 2020-06-07
 */
public class Post implements java.io.Serializable {


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postname='" + postname + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = -7638533143066263839L;

    /** 职位表id */
    private Integer id;

    /** 职位名称 */
    private String postname;

    /**
     * 获取职位表id
     * 
     * @return 职位表id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置职位表id
     * 
     * @param id
     *          职位表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取职位名称
     * 
     * @return 职位名称
     */
    public String getPostname() {
        return this.postname;
    }

    /**
     * 设置职位名称
     * 
     * @param postname
     *          职位名称
     */
    public void setPostname(String postname) {
        this.postname = postname;
    }
}