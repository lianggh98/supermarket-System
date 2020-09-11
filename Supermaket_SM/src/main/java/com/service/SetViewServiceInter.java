package com.service;

import com.beanvo.SupplierVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
public interface SetViewServiceInter {
    /**
     * 设置供应商树形列表
     * @return void 
     * @Author Ryo     
     * @create 2020/9/11 19:07
    */
    void setSupplierTreeTableView();
    /**
     * 提交或修改供应商
     * @param type 
     * @param list
     * @return void 
     * @Author Ryo     
     * @create 2020/9/11 19:07
    */
    void supplierInsetUpdate(String type, List<String> list);
    /**
     * 设置供应商细胞值工厂
     * @param column 
     * @param mapper
     * @return void 
     * @Author Ryo     
     * @create 2020/9/11 21:31
    */
    <T> void setSupplierCellValueFactory(JFXTreeTableColumn<SupplierVo, T> column, Function<SupplierVo, ObservableValue<T>> mapper);
    /**
     * 显示供应商树列列表
     * @return void 
     * @Author Ryo     
     * @create 2020/9/11 21:35
    */
    void show_SupplierJFXTreeTableColumn();

}
