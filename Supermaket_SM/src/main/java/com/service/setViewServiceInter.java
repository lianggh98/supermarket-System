package com.service;

import com.BeanVo.SupplierVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.util.List;
import java.util.function.Function;

public interface setViewServiceInter {
    void set_SupplierTreeTableView();
    void supplierInsetUpdate(String type, List<String> list);
    <T> void setSupplierCellValueFactory(JFXTreeTableColumn<SupplierVo, T> column, Function<SupplierVo, ObservableValue<T>> mapper);
    void show_SupplierJFXTreeTableColumn();

}
