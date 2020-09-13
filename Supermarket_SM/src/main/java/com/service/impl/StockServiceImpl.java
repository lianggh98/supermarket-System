package com.service.impl;

import com.bean.inventory.Stock;
import com.beanvo.StockVo;
import com.dao.StockMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.service.StockServiceInter;
import javafx.application.Platform;
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
import view.controller.stock.StockControllerInsertUpdate;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/16 14:24
 * @Version 1.0
 **/
@Service("stockService")
public class StockServiceImpl implements StockServiceInter {
    @Autowired
    ViewAssistImpl viewAssist;
    @Autowired
    StockMapper mapper;
    private static ObservableList<StockVo> StockDate= FXCollections.observableArrayList();
    @Override
    public void setJFXTreeTableColumn(){
        setStockCellValueFactory(Manage.getStockController_().selected, StockVo -> new SimpleBooleanProperty(StockVo.getSelected()));
        setStockCellValueFactory(Manage.getStockController_().stockid, StockVo -> new SimpleIntegerProperty(StockVo.getStockid()).asObject());
        setStockCellValueFactory(Manage.getStockController_().inid, StockVo -> new SimpleIntegerProperty(StockVo.getInid()).asObject());
        setStockCellValueFactory(Manage.getStockController_().gid, StockVo -> new SimpleIntegerProperty(StockVo.getGid()).asObject());
        setStockCellValueFactory(Manage.getStockController_().gname, StockVo -> new SimpleStringProperty(StockVo.getGname()));
        setStockCellValueFactory(Manage.getStockController_().quantity, StockVo -> new SimpleStringProperty(StockVo.getQuantity()));
        setStockCellValueFactory(Manage.getStockController_().produced, StockVo -> new SimpleStringProperty(StockVo.getProduced().toString()));
        setStockCellValueFactory(Manage.getStockController_().wname, StockVo -> new SimpleStringProperty(StockVo.getWname()));
        setStockCellValueFactory(Manage.getStockController_().expiration, StockVo -> new SimpleStringProperty(StockVo.getExpiration()));
        setStockCellValueFactory(Manage.getStockController_().update, StockVo -> new SimpleStringProperty(StockVo.getStockid().toString()));
        /***设置Checkbox*/
        Manage.getStockController_().selected.setCellFactory(new Callback<TreeTableColumn<StockVo, Boolean>, TreeTableCell<StockVo, Boolean>>() {
            @Override
            public TreeTableCell<StockVo, Boolean> call(TreeTableColumn<StockVo, Boolean> buyTreeTableView) {
                TreeTableCell<StockVo, Boolean> tc = new TreeTableCell<StockVo, Boolean>() {
                    @Override
                    public void updateItem(Boolean item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);
                        if (item != null) {
                            CheckBox checkBox = new CheckBox();
                            setGraphic(checkBox);
                            if (this.getTreeTableRow() != null) {
                                StockVo g = StockDate.get(getIndex());

                                checkBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent mouseEvent) {
                                        g.setSelected(checkBox.selectedProperty().getValue());
                                        System.out.println(g);
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
        /***设置JFX修改按钮*/
        Manage.getStockController_().update.setCellFactory(new Callback<TreeTableColumn<StockVo, String>, TreeTableCell<StockVo, String>>() {
            @Override
            public TreeTableCell<StockVo, String> call(TreeTableColumn<StockVo, String> goodsVoStringTreeTableColumn) {
                TreeTableCell<StockVo, String> tc = new TreeTableCell<StockVo, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);

                        if (item != null){
                            if(this.getTreeTableRow()!=null) {
                                JFXButton jfxButton = new JFXButton("修改");
                                jfxButton.setStyle("-fx-background-color: #3fc1c9;-fx-text-fill: #f5f5f5");
                               jfxButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                   @Override
                                   public void handle(MouseEvent mouseEvent) {
                                       try {
                                           StockVo stockVo = StockDate.get(getIndex());
                                           StockControllerInsertUpdate.setStockVo(stockVo);
                                           viewAssist.getNO_Title_Stage(730,400,"測試", "/new_fxml/stock/stockAdd.fxml","/new_images/shop_car.png",null).show();
                                       } catch (IOException e) {
                                           e.printStackTrace();
                                       }

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
    public void showJFXTreeTableColumn(){
        StockDate= FXCollections.observableArrayList();
//        从数据库获取数据
        for(StockVo p :mapper.findStockVoAll()) {
            StockDate.add(p);
        }

        //          存入TreeTableView
        Manage.getStockController_().stockTreeTableView.setRoot(new RecursiveTreeItem<>(StockDate, RecursiveTreeObject::getChildren));
//        关闭主节点的显示
        Manage.getStockController_().stockTreeTableView.setShowRoot(false);
//        设置树形结构可以编辑
        Manage.getStockController_().stockTreeTableView.setEditable(true);
    }
    @Override
    public <T> void setStockCellValueFactory(JFXTreeTableColumn<StockVo, T> column, Function<StockVo, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<StockVo, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    @Override
    public int removeSelected(){
        List<Integer> list = new ArrayList<>();
        for(StockVo s: StockDate) {
            if(s.getSelected()) {
                list.add(s.getStockid());
            }
        }
            if(list.size()!=0){
//                这里开始想数据库传递需要删除的数据
                System.out.println(list);
                mapper.deleteStockByIds(list);
                return 1;
            }
            return 0;

    }
    @Override
    public void stockInsert(List<String> strings){
        Stock s =  new Stock();
        s.setInid(Integer.valueOf(strings.get(0)));
        s.setQuantity(strings.get(1));
        s.setWarehouseId(Integer.valueOf(strings.get(2)));
        s.setGid(Integer.valueOf(strings.get(3)));
        s.setProduced(Timestamp.valueOf(strings.get(4)));
        s.setExpiration(strings.get(5));
        mapper.insertStock(s);
        Platform.runLater(()->{
            showJFXTreeTableColumn();
        });
    }
    @Override
    public void upDateStock(List<String>strings , Timestamp timestamp){
        Stock stock = new Stock();
        stock.setStockid(Integer.valueOf(strings.get(0)));
        stock.setInid(Integer.valueOf(strings.get(1)));
        stock.setQuantity(strings.get(2));
        stock.setWarehouseId(Integer.valueOf(strings.get(3)));
        stock.setGid(Integer.valueOf(strings.get(4)));
        stock.setExpiration(strings.get(5));
        stock.setProduced(timestamp);


        mapper.updateStock(stock);
        System.out.println(mapper);
        System.out.println(stock);
    }
}
