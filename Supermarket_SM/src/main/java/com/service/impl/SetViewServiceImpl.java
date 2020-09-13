package com.service.impl;

import com.bean.buy.Supplier;
import com.beanvo.SupplierVo;
import com.dao.SetMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.service.SetViewServiceInter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import view.controller.index.SetController;
import view.util.Manage;

import java.util.List;
import java.util.function.Function;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/22 14:19
 * @Version 1.0
 **/
@Service("setViewService")
public class SetViewServiceImpl implements SetViewServiceInter {
    @Autowired
    Manage manage;
    @Autowired
    SetMapper setMapper;
    /**  Sync from Mysql date**/

    private static ObservableList<SupplierVo> supplierDate= FXCollections.observableArrayList();
    @Override
    public void setSupplierTreeTableView() {

        setSupplierCellValueFactory(Manage.getSetController().supplierId,SupplierVo-> new SimpleStringProperty(SupplierVo.getId().toString()));
        setSupplierCellValueFactory(Manage.getSetController().supplierName,SupplierVo-> new SimpleStringProperty(SupplierVo.getName().toString()));
        setSupplierCellValueFactory(Manage.getSetController().supplierTel,SupplierVo-> new SimpleStringProperty(SupplierVo.getTel().toString()));
        setSupplierCellValueFactory(Manage.getSetController().supplierAddr,SupplierVo-> new SimpleStringProperty(SupplierVo.getAddr().toString()));
        setSupplierCellValueFactory(Manage.getSetController().supplierUpdate,SupplierVo-> new SimpleStringProperty(SupplierVo.getId().toString()));
        setSupplierCellValueFactory(Manage.getSetController().supplierDelete,SupplierVo-> new SimpleStringProperty(SupplierVo.getId().toString()));
        /**
         * @Description:设置set为button居中
         */
        Manage.getSetController().supplierUpdate.setCellFactory(new Callback<TreeTableColumn<SupplierVo, String>, TreeTableCell<SupplierVo, String>>() {
            @Override
            public TreeTableCell<SupplierVo, String> call(TreeTableColumn<SupplierVo, String> buyTreeTableView) {
                TreeTableCell<SupplierVo, String> tc = new TreeTableCell<SupplierVo, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        setText(null);
                        setGraphic(null);
                        if (item != null) {
                            if(this.getTreeTableRow()!=null) {
                                JFXButton jfxButton = new JFXButton("修改");
                                jfxButton.setStyle("-fx-background-color: #87CEEB");
                                SupplierVo s =  supplierDate.get(getIndex());
//                                跳转至修改界面
                                jfxButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        Manage.getSetController().supplierIdText.setText(s.getId().toString());
                                        Manage.getSetController().supplierNameText.setText(s.getName());
                                        Manage.getSetController().supplierTelText .setText(s.getTel());
                                        Manage.getSetController().supplierAddrText.setText(s.getAddr());
                                        SetController.setSupplierTemp(1);
                                    }
                                });




                                setGraphic(jfxButton);

                            }
                        }
                    }
                };
                tc.setAlignment(Pos.CENTER);
                return tc;
            }
        });

        Manage.getSetController().supplierDelete.setCellFactory(new Callback<TreeTableColumn<SupplierVo, String>, TreeTableCell<SupplierVo, String>>() {
            @Override
            public TreeTableCell<SupplierVo, String> call(TreeTableColumn<SupplierVo, String> buyTreeTableView) {
                TreeTableCell<SupplierVo, String> tc = new TreeTableCell<SupplierVo, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        setText(null);
                        setGraphic(null);
                        if (item != null) {
                            if(this.getTreeTableRow()!=null) {
                                JFXButton jfxButton = new JFXButton("删除");
                                jfxButton.setStyle("-fx-background-color: #C82333");
                                jfxButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        SupplierVo s = supplierDate.get(getIndex());
                                        Manage.getSetController().supplierDeletedAcceptButton.setOnAction(action->{
                                            setMapper.deleteSupplierById(Integer.valueOf(s.getId()));/**提交删除申请**/
                                            show_SupplierJFXTreeTableColumn();/**更新数据**/
                                            Manage.getSetController().supplierDeletedDialog.close();
                                        });
                                        Manage.getSetController().supplierDeletedDialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
                                        Manage.getSetController().L_supplierDeletedDialog.setText("是否删除选中的,名称为:"+s.getName()+"供应商");
                                        Manage.getSetController().supplierDeletedDialog.show(Manage.getSetController().supplierRoot);
                                    }
                                });

                                setGraphic(jfxButton);
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
    public void supplierInsetUpdate(String type, List<String> list){
        Supplier s = new Supplier();
        s.setId(Integer.valueOf(list.get(0)));
        s.setName(list.get(1));
        s.setTel(list.get(2));
        s.setAddr(list.get(3));
        System.out.println(s);
        switch (type){
            case "insert":
                setMapper.insertSupplier(s);
                break;
            case "update":
                setMapper.updateSupplier(s);
                SetController.setSupplierTemp(0);
                break;
        }

    }
    @Override
    public<T> void setSupplierCellValueFactory(JFXTreeTableColumn<SupplierVo, T> column, Function<SupplierVo, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<SupplierVo, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    @Override
    public void show_SupplierJFXTreeTableColumn(){
        supplierDate= FXCollections.observableArrayList();
//        从数据库获取数据
        for(SupplierVo p :setMapper.findSupplierAll()){
            supplierDate.add(p);
        }
        //          存入TreeTableView
        Manage.getSetController().supplierTreeTableView.setRoot(new RecursiveTreeItem<>(supplierDate, RecursiveTreeObject::getChildren));
//        关闭主节点的显示
        Manage.getSetController().supplierTreeTableView.setShowRoot(false);
    }

}
