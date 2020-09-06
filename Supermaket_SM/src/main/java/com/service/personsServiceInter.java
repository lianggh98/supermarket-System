package com.service;

import com.BeanVo.PersonsVo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

public interface personsServiceInter {
    void set_JFXTreeTableColumn(JFXTreeTableColumn...columns);
    void show_JFXTreeTableColumn();
    <T> void setPersonsCellValueFactory(JFXTreeTableColumn<PersonsVo, T> column, Function<PersonsVo, ObservableValue<T>> mapper);
    int selected();
    void show_Dep_ComboBox(JFXComboBox<String> comboBox);
    void show_Post_ComboBox(JFXComboBox<String> comboBox);
    void persons_Insert$Update(String type, List<String> strings, Timestamp inTimeStamp, Timestamp outTimeStamp);
}
