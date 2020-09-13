package com.service;

import com.beanvo.BuyVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
public interface BuyServiceInter {
    /**
     * 数据类型工厂设置
     * @param column 
     * @param mapper
     * @return void 
     * @Author Ryo     
     * @create 2020/9/11 21:33
    */
     <T> void setBuyCellValueFactory(JFXTreeTableColumn<BuyVo, T> column, Function<BuyVo, ObservableValue<T>> mapper);
    /**
     * 查找被选中的然后删除
     * @return int 
     * @Author Ryo     
     * @create 2020/9/11 21:33
    */
     int buySelected();
     /**
      * 显示采购树形表
      * @return void 
      * @Author Ryo     
      * @create 2020/9/11 21:34
     */
     void show_BuyJFXTreeTableColumn();
     /**
      * 设置buyJFXTree的数据类型格式
      * @param column 
      * @return void 
      * @Author Ryo     
      * @create 2020/9/11 21:34
     */
     void setBuyJFXTreeTableColumn(JFXTreeTableColumn... column);
     /**
      * 向数据库提交或者修改
      * @param type 
      * @param strings 
      * @param inTimeStamp 
      * @param producedTimeStamp
      * @return void 
      * @Author Ryo     
      * @create 2020/9/11 21:34
     */
     void upDateInsert(String type, List<String> strings, Timestamp inTimeStamp, Timestamp producedTimeStamp);

    /**
     * 获取一星期内的采购热力图
     * @param strings 
     * @return java.util.List<java.lang.Integer> 
     * @Author Ryo     
     * @create 2020/9/11 21:35
    */
     List<Integer> getEveryDayBuyRecord(List<String> strings);

    /**
     * 获取最后的id然后递增一个
     * @return Integer
     * @Author Ryo
     * @create 2020/9/12 13:02
     */
    Integer getNewIDByLastID();
}
