package com.service.impl;

import com.bean.buy.Intable;
import com.beanvo.IntableVo;
import com.dao.InTableMapper;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.service.InTableServiceInter;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import view.util.Manage;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
@Service("inTableService")
public class InTableServiceImpl implements InTableServiceInter {

    @Autowired
    InTableMapper mapper;
    private static ObservableList<IntableVo> inTableDate= FXCollections.observableArrayList();


    @Override
    public void setInTableJFXTreeTableColumn(JFXTreeTableColumn...columns){
        //    设置数据源
        setinTableCellValueFactory(columns[0], IntableVo ->  new SimpleBooleanProperty(IntableVo.getSelected()));
        setinTableCellValueFactory(columns[1], IntableVo->  new SimpleIntegerProperty(IntableVo.getInid()).asObject());
        setinTableCellValueFactory(columns[2], IntableVo->  new SimpleIntegerProperty(IntableVo.getGid()).asObject());
        setinTableCellValueFactory(columns[3], IntableVo->  new SimpleIntegerProperty(IntableVo.getInPerid()).asObject());
        setinTableCellValueFactory(columns[4], IntableVo->  new SimpleIntegerProperty(IntableVo.getBuyid()).asObject());
        setinTableCellValueFactory(columns[5], IntableVo->  new SimpleStringProperty(IntableVo.getQuantity()));
        setinTableCellValueFactory(columns[6], IntableVo->  new SimpleStringProperty(IntableVo.getCometime().toString()));
        /** 数据库内灭有对应的 stockroom 列需要添加**/
        setinTableCellValueFactory(columns[7], IntableVo->  new SimpleStringProperty(IntableVo.getWname()));
        setinTableCellValueFactory(columns[8], IntableVo->  new SimpleStringProperty(IntableVo.getCometime().toString()));
        setinTableCellValueFactory(columns[9], IntableVo->  new SimpleStringProperty(IntableVo.getPname()));
        setinTableCellValueFactory(columns[10], IntableVo->  new SimpleStringProperty(IntableVo.getGname()));

        columns[0].setEditable(true);
        columns[0].setCellFactory(new Callback<TreeTableColumn<IntableVo, Boolean>, TreeTableCell<IntableVo, Boolean>>() {
            @Override
            public TreeTableCell<IntableVo, Boolean> call(TreeTableColumn<IntableVo, Boolean> buyTreeTableView) {
                TreeTableCell<IntableVo, Boolean> tc = new TreeTableCell<IntableVo, Boolean>() {
                    @Override
                    public void updateItem(Boolean item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);
                        if (item != null) {
                            CheckBox checkBox = new CheckBox();
                            setGraphic(checkBox);
                            if (this.getTreeTableRow() != null) {
                                IntableVo g = inTableDate.get(getIndex());
                                checkBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent mouseEvent) {
                                        g.setSelected(checkBox.selectedProperty().getValue());
                                    }
                                });
                            }
                        }

                    }
                };
                tc.setAlignment(Pos.CENTER);
                return tc;

            }

        });

    }
    @Override
    public void showInTableJFXTreeTableColumn(){
        inTableDate= FXCollections.observableArrayList();
//        从数据库获取数据
        for(IntableVo p :mapper.findInTableVoAll()){
            inTableDate.add(p);
        }
        //          存入TreeTableView
        Manage.getBuyController().inTableTreeTableView.setRoot(new RecursiveTreeItem<>(inTableDate, RecursiveTreeObject::getChildren));
//        关闭主节点的显示
        Manage.getBuyController().inTableTreeTableView.setShowRoot(false);
//        设置树形结构可以编辑
        Manage.getBuyController().inTableTreeTableView.setEditable(true);
    }
    @Override
    public <T> void setinTableCellValueFactory(JFXTreeTableColumn<IntableVo, T> column, Function<IntableVo, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<IntableVo, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    @Override
    public int Selected(){
        List<Integer> list = new ArrayList<>();
        for(IntableVo p:inTableDate){
            if (p.getSelected()){
                list.add(p.getInid());
            }
        }
        if(list.size()!=0){
            mapper.deleteIntableByIds(list);
            return 1;
        }
        return list.size();
    }
    @Override
    public int inTableUpdate(List<String> list, Timestamp timestamp){
        Intable intable =new Intable();
        intable.setInPerid(Integer.valueOf(list.get(0)));
        intable.setInStockroom(Integer.valueOf(list.get(1)));
        intable.setBuyid(Integer.valueOf(list.get(2)));
        intable.setGid(Integer.valueOf(list.get(3)));
        intable.setQuantity(list.get(4));
        intable.setCometime(timestamp);
        mapper.insertIntable(intable);
        return intable.getInid();
    }

    @Override
    public Integer getNewIDByLastID() {
        List<IntableVo> inTableVoAll  =mapper.findInTableVoAll();
        return inTableVoAll.get(inTableVoAll.size()-1).getInid()+1;
    }
}
