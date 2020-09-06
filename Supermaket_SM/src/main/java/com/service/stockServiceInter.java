package com.service;

import com.BeanVo.StockVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

public interface stockServiceInter {
    void set_JFXTreeTableColumn();
    void show_JFXTreeTableColumn();
    <T> void setStockCellValueFactory(JFXTreeTableColumn<StockVo, T> column, Function<StockVo, ObservableValue<T>> mapper);
    int remove_selected();
    void stockInsert(List<String> strings);
    void updateStock(List<String>strings , Timestamp timestamp);
}
