package com.service;

import com.beanvo.StockVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
public interface StockServiceInter {

    /**
     * 设置
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:41
    */
    void setJFXTreeTableColumn();
    /**
     * 显示
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:41
    */
    void showJFXTreeTableColumn();
    /**
     * 设置细胞工程
     * @param column
     * @param mapper
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:41
    */
    <T> void setStockCellValueFactory(JFXTreeTableColumn<StockVo, T> column, Function<StockVo, ObservableValue<T>> mapper);
    /**
     * 删除选中
     * @return int
     * @Author Ryo
     * @create 2020/9/11 21:42
    */
    int removeSelected();
    /**
     * 库存插入
     * @param strings
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:42
    */
    void stockInsert(List<String> strings);
    /**
     * 提交
     * @param strings
     * @param timestamp
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:42
    */
    void upDateStock(List<String>strings , Timestamp timestamp);
}
