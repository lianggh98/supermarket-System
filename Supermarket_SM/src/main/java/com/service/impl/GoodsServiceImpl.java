package com.service.impl;

import com.bean.goods.Bclass;
import com.bean.goods.Goods;
import com.beanvo.GoodsVo;
import com.dao.GoodsMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.service.GoodsServiceInter;
import com.spring.BaseHolder;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
import view.new_conotroller.goods.goodsUpdate_InsertController;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsServiceInter {


    @Autowired
    ViewAssistImpl viewAssist;
    @Autowired
    GoodsMapper mapper;
    private static ObservableList<GoodsVo> GoodsDate=FXCollections.observableArrayList();
    @Override
    public void setJFXTreeTableColumn(JFXTreeTableColumn... columns){
        //设置数据源
        setGoodsCellValueFactory(columns[0], GoodsVo->  new SimpleBooleanProperty(GoodsVo.getSelected()));
        setGoodsCellValueFactory(columns[1], GoodsVo->  new SimpleIntegerProperty(GoodsVo.getId()).asObject());
        setGoodsCellValueFactory(columns[2], GoodsVo->  new SimpleIntegerProperty(GoodsVo.getBClass()).asObject());
        setGoodsCellValueFactory(columns[3], GoodsVo->  new SimpleStringProperty(GoodsVo.getMerchid()) );
        setGoodsCellValueFactory(columns[4], GoodsVo->  new SimpleStringProperty(GoodsVo.getGname()));
        setGoodsCellValueFactory(columns[5], GoodsVo->  new SimpleStringProperty(GoodsVo.getGaddr()));
        setGoodsCellValueFactory(columns[6], GoodsVo-> new SimpleDoubleProperty(GoodsVo.getMoney()).asObject() );
        setGoodsCellValueFactory(columns[7], GoodsVo->  new SimpleStringProperty(GoodsVo.getBname()));

        setGoodsCellValueFactory(columns[8], GoodsVo->  new SimpleStringProperty(GoodsVo.getId().toString()));

        columns[0].setCellFactory(new Callback<TreeTableColumn<GoodsVo, Boolean>, TreeTableCell<GoodsVo, Boolean>>() {
            @Override
            public TreeTableCell<GoodsVo, Boolean> call(TreeTableColumn<GoodsVo, Boolean> buyTreeTableView) {
                TreeTableCell<GoodsVo, Boolean> tc = new TreeTableCell<GoodsVo, Boolean>() {
                    @Override
                    public void updateItem(Boolean item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);
                        if (item != null) {
                            CheckBox checkBox = new CheckBox();
                            setGraphic(checkBox);
                            if (this.getTreeTableRow() != null) {
                                GoodsVo g = GoodsDate.get(getIndex());
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


        /**
         * @Description:设置set为button居中
         */
        columns[8].setCellFactory(new Callback<TreeTableColumn<GoodsVo, String>, TreeTableCell<GoodsVo, String>>() {
            @Override
            public TreeTableCell<GoodsVo, String> call(TreeTableColumn<GoodsVo, String> goodsVoStringTreeTableColumn) {
                TreeTableCell<GoodsVo, String> tc = new TreeTableCell<GoodsVo, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);
                        final JFXButton progress = new JFXButton("测试");
                        if (item != null){
//                            setText(item);
                            progress.setText("修改");
                            progress.setStyle("-fx-background-color: #3fc1c9;-fx-text-fill: #f5f5f5");
                            if(this.getTreeTableRow()!=null){
                                progress.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent mouseEvent) {
                                        goodsUpdate_InsertController.setTemp(1);
                                        goodsUpdate_InsertController.setG(GoodsDate.get(getIndex()));
                                        try {
                                            viewAssist.getNO_Title_Stage(863,469,"測試", "/new_fxml/goods/goodsAdd.fxml","/new_images/shop_car.png",null).show();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                            setGraphic(progress);
                        }
                    }
                };

                tc.setAlignment(Pos.CENTER);
                return tc;
            }
        });



    }
    @Override
    public int selected() {
        List<Integer> list = new ArrayList<>();
        for(GoodsVo p:GoodsDate){
            if (p.getSelected()){
                list.add(p.getId());
            }
        }
        if(list.size()!=0){
            mapper.deleteGoodsByIds(list);
            return 1;
        }
        return list.size();
    }
    @Override
    public void showJFXTreeTableColumn(){
        GoodsDate= FXCollections.observableArrayList();
         mapper = BaseHolder.getApplicationContext().getBean("goodsMapper", GoodsMapper.class);

//        从数据库获取数据
        for(GoodsVo p :mapper.findGoodsVoAll()) {
            GoodsDate.add(p);
        }

        //          存入TreeTableView
       Manage.getController_goods().goodsTreeTableView.setRoot(new RecursiveTreeItem<>(GoodsDate, RecursiveTreeObject::getChildren));
//        关闭主节点的显示
        Manage.getController_goods().goodsTreeTableView.setShowRoot(false);
//        设置树形结构可以编辑
        Manage.getController_goods().goodsTreeTableView.setEditable(true);
    }
    @Override
    public  <T> void setGoodsCellValueFactory(JFXTreeTableColumn<GoodsVo, T> column, Function<GoodsVo, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<GoodsVo, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    @Override
    public void goodsUpdate$Insert(String type , List<String> strings){
        List<Goods> list =new ArrayList<>();
        Goods g = new Goods();
        g.setId(Integer.valueOf(strings.get(0)));
        g.setGname(strings.get(1));
        g.setMerchid(strings.get(2));
        g.setMoney(Double.parseDouble(strings.get(3)));
        g.setGaddr(strings.get(4));
        g.setBClass(Integer.valueOf(strings.get(5)));

        list.add(g);

        switch (type){
            case "insert":
                mapper.insertGoods(list);
                break;
            case "update":
                mapper.updateGoods(list);
                break;
        }

    }



    @Override
    public void showBClassComboBox(JFXComboBox jfxComboBox){
        for(Bclass b:mapper.findBClassAll()){
            jfxComboBox.getItems().add(b.getBid()+b.getBname());
        }
    }
}
