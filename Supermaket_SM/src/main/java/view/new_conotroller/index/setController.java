package view.new_conotroller.index;

import com.bean.goods.Bclass;
import com.bean.inventory.Warehouse;
import com.beanvo.SupplierVo;
import com.dao.GoodsMapper;
import com.dao.SetMapper;
import com.jfoenix.controls.*;
import com.service.impl.SetViewServiceImpl;
import com.spring.BaseHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/20 15:50
 * @Version 1.0
 **/
public class setController extends ViewAssistImpl implements Initializable {


    /**自定义的StockListView**/
    @FXML  JFXListView<HBoxCell>listView;
    class HBoxCell extends HBox {
        Label Wid = new Label();
        Label Wname = new Label();
         JFXButton button = new JFXButton("修改");
         JFXButton delButton = new JFXButton("删除");
         JFXTextField WidtextField = new JFXTextField();
         JFXTextField WnametexeField = new JFXTextField();
         Integer old = null;
         private HBox hBox = null;
        HBoxCell(String wid, String wname,JFXListView listView) {
            super();
            hBox = this;
            Wid.setText(wid);
            Wname.setText(wname);


            HBox.setMargin(Wid,new Insets(0,10,0,0));
            HBox.setMargin(Wname,new Insets(0,10,0,0));
            HBox.setMargin(WidtextField,new Insets(0,10,0,0));
            HBox.setMargin(WnametexeField,new Insets(0,10,0,0));
            HBox.setMargin(button,new Insets(0,30,0,10));

            Wid.setPrefWidth(50);
            WidtextField.setPrefWidth(50);

            Wname.setPrefWidth(80);
            WnametexeField.setPrefWidth(80);

            HBox setBox = new HBox();
            setBox.setPrefHeight(21);
            button.setPrefHeight(55);
            delButton.setPrefHeight(55);
            setBox.getChildren().addAll(button,delButton);



            button.setStyle("-fx-background-color: #87CEEB");
            /**设置按钮事件**/
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    if(button.getText().equals("修改")){
                        button.setStyle("-fx-background-color: #FF4040");
                        hBox.getChildren().remove(0,2);
                        listView.setEditable(true);

                        old = Integer.valueOf(Wid.getText());
                        System.out.println(old);
                        WidtextField.setText(Wid.getText());
                        WnametexeField.setText(Wname.getText());

                        hBox.getChildren().add(0,WidtextField);
                        hBox.getChildren().add(1,WnametexeField);


                        button.setText("保存");
                    }
                    else if(button.getText().equals("保存")){
                        button.setStyle("-fx-background-color: #87CEEB");
                        Wid.setText(WidtextField.getText());
                        Wname.setText(WnametexeField.getText());

                        hBox.getChildren().remove(0,2);
                        SetMapper setMapper = BaseHolder.getApplicationContext().getBean("setMapper", SetMapper.class);
                        Warehouse w = new Warehouse();



                        w.setWid(old);
                        w.setNewid(Integer.valueOf(WidtextField.getText()));
                        w.setWname(WnametexeField.getText());
                        System.out.println(w);
                        System.out.println(setMapper.updateWarehouse(w));

                        hBox.getChildren().add(0,Wid);
                        hBox.getChildren().add(1,Wname);
                        button.setText("修改");
                    }

                }
            });
            /**删除按钮事件**/
            delButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Integer id  =  Integer.valueOf(Wid.getText());
                    setMapper.deleteWarehouseById(id);
                    show_WDialog("删除成功");
                    showWarehouseListView(listView);
                }
            });
            hBox.getChildren().addAll(Wid, Wname,setBox);
        }
    }



    /**自定义的BClassListView**/
    @FXML JFXListView<bClassHboxCell>  bClassListView;
    class bClassHboxCell extends  HBox{
        Label bid = new Label();
        Label bName = new Label();
        JFXButton button = new JFXButton("修改");
        JFXButton delButton = new JFXButton("删除");
        JFXTextField bIdTextField = new JFXTextField();
        JFXTextField bNameTextField = new JFXTextField();
        Integer old = null;
        private HBox hBox = null;
        bClassHboxCell(String wid, String wname,JFXListView listView) {
            super();
            hBox = this;
            bid.setText(wid);
            bName.setText(wname);


            HBox.setMargin(bid,new Insets(0,10,0,0));
            HBox.setMargin(bName,new Insets(0,10,0,0));
            HBox.setMargin(bIdTextField,new Insets(0,10,0,0));
            HBox.setMargin(bNameTextField,new Insets(0,10,0,0));
            HBox.setMargin(button,new Insets(0,30,0,10));

            bid.setPrefWidth(50);
            bName.setPrefWidth(50);

            bIdTextField.setPrefWidth(80);
            bNameTextField.setPrefWidth(80);

            HBox setBox = new HBox();
            setBox.setPrefHeight(21);
            button.setPrefHeight(55);
            delButton.setPrefHeight(55);
            setBox.getChildren().addAll(button,delButton);



            button.setStyle("-fx-background-color: #87CEEB");

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    if(button.getText().equals("修改")){
                        button.setStyle("-fx-background-color: #FF4040");
                        hBox.getChildren().remove(0,2);
                        listView.setEditable(true);

                        old = Integer.valueOf(bid.getText());
                        System.out.println(old);
                        bIdTextField.setText(bid.getText());
                        bNameTextField.setText(bName.getText());

                        hBox.getChildren().add(0,bIdTextField);
                        hBox.getChildren().add(1,bNameTextField);


                        button.setText("保存");
                    }
                    else if(button.getText().equals("保存")){
                        button.setStyle("-fx-background-color: #87CEEB");
                        bid.setText(bIdTextField.getText());
                        bName.setText(bNameTextField.getText());

                        hBox.getChildren().remove(0,2);
                        SetMapper setMapper = BaseHolder.getApplicationContext().getBean("setMapper", SetMapper.class);
                        Bclass b  = new Bclass();
                        b.setBid(old);
                        b.setNewid(Integer.valueOf(bIdTextField.getText()));
                        b.setBname(bNameTextField.getText());

                        Integer temp = setMapper.updateBclass(b);

                        hBox.getChildren().add(0,bid);
                        hBox.getChildren().add(1,bName);
                        button.setText("修改");
                    }

                }
            });
            delButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Integer id  = Integer.valueOf(bid.getText());
                    setMapper.deleteBclassById(id);
                    show_bDialog("删除成功!!");
                    showBClassListView(bClassListView);
                }
            });
            hBox.getChildren().addAll(bid, bName,setBox);
        }
    }



    /**显示登陆的账号名称**/
    @FXML  public JFXButton accountName;




    /**显示仓库ListView**/
    public void showWarehouseListView(JFXListView listView){
        listView.getItems().clear();
        List<HBoxCell> list = new ArrayList<>();
        for(Warehouse w:setMapper.findWareHouseAll())
            list.add(new HBoxCell(w.getWid().toString(), w.getWname(),listView));

        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
    }
    /**显示商品分类ListView**/
    public void showBClassListView(JFXListView listView){
        GoodsMapper goodsMapper = BaseHolder.getApplicationContext().getBean("goodsMapper", GoodsMapper.class);
        bClassListView.getItems().clear();
        List<bClassHboxCell> list = new ArrayList<>();
        for(Bclass b:goodsMapper.findBClassAll())
            list.add(new bClassHboxCell(b.getBid().toString(),b.getBname(),listView));

        ObservableList<bClassHboxCell> myObservableList = FXCollections.observableList(list);
        bClassListView.setItems(myObservableList);
    }





    /**密码的Dialog配置**/
    @FXML
    StackPane root;
    @FXML
    Label L_Dialog;
    @FXML
    JFXDialog dialog;
    @FXML
    JFXButton acceptButton;
    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }
    @FXML/**用于新旧密**/JFXPasswordField oldPwd,newPwd;
    @FXML/**向数据库提交修改密码**/
    public void updatePwd(){
        if(super.TextisNull(newPwd,oldPwd)==null){
            show_Dialog("没有输入数据");
            return;
        }

        HashMap<String,String > map=new HashMap<>();
        map.put("newPwd",newPwd.getText());
        map.put("oldPwd",oldPwd.getText());
        map.put("id", Manage.getAccount().getId().toString());


        Integer temp = setMapper.accountUpdatePwd(map);
        if(temp==0){
            show_Dialog("原密码错误请重新输入");
            oldPwd.clear();
            newPwd.clear();
        }else {
            show_Dialog("新密码修改成功!!!!新密码为："+newPwd.getText());
            oldPwd.clear();
            newPwd.clear();
        }

    }


    /**仓库配置**/
    @FXML
    JFXTextField widText,wNameText;
    @FXML
    StackPane wRoot;
    @FXML
    Label L_wDialog;
    @FXML
    JFXDialog Wdialog;
    @FXML
    JFXButton WacceptButton;
    @FXML/**插入数据**/
    public void whouseInsert(){
        if(super.TextisNull(widText,wNameText)==null){
            show_WDialog("没有输入数据");
            return;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setWid(Integer.valueOf(widText.getText()));
        warehouse.setWname(wNameText.getText());

        setMapper.insertWarehouse(warehouse);
        show_WDialog("添加成功");
        widText.clear();
        wNameText.clear();
        showWarehouseListView(listView);
    }
    /**显示仓库Dialog**/
    public void show_WDialog(String str){
        Wdialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_wDialog.setText(str);
        Wdialog.show(wRoot);
    }
    /**查找是否已经存在Wid**/
    public void selectWid(){

        if(widText.getText().length()!=0) {
            if (!super.isnumber(widText.getText())){
                show_WDialog("请输入为数字的编号");
                return;
            }else
                if (setMapper.findWarehouseById(Integer.valueOf(widText.getText())) != null) {
                    show_WDialog("当前库存编号已经存在");
                }
        }
    }



    /**仓库配置**/
    @FXML
    StackPane bRoot;
    @FXML
    Label L_bDialog;
    @FXML
    JFXDialog bDialog;
    @FXML
    JFXButton bAcceptButton;
    @FXML JFXTextField bidText,bNameTxt;
    @FXML
    public void bClassInsert(){
        if(super.TextisNull(bidText,bNameTxt)==null){
            show_bDialog("没有输入任何数据");
            return;
        }
        if(!super.isnumber(bidText.getText())){
            show_bDialog("请输入数字类型");
            return;
        }
        Bclass bclass = new Bclass();
        bclass.setBid(Integer.valueOf(bidText.getText()));
        bclass.setBname(bNameTxt.getText());
        setMapper.insertBclass(bclass);
        show_bDialog("添加成功");
        bidText.clear();
        bNameTxt.clear();
        showBClassListView(bClassListView);

    }
    public void show_bDialog(String str){
        bDialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_bDialog.setText(str);
        bDialog.show(bRoot);
    }
    @FXML/**查找是否存在当前的Bid类别编号**/
    public void existThisBid(){
        if(bidText.getText().length()!=0){
            if(!super.isnumber(bidText.getText())){
                show_bDialog("请输入数字类型的编号");
                return;
            }
            if(setMapper.findBclassByIds(Integer.valueOf(bidText.getText()))!=null){
                show_bDialog("当前编号已经存在,请重新输入");
                return;
            }
        }
    }


    /**进货商配置**/
    @FXML
    public StackPane supplierRoot;
    @FXML
    public Label L_supplierDialog,L_supplierDeletedDialog;
    @FXML
    public JFXDialog supplierDialog,supplierDeletedDialog;
    @FXML
    public JFXButton supplierAcceptButton,supplierDeletedAcceptButton;
    @FXML
    public JFXTreeTableView<SupplierVo> supplierTreeTableView;
    @FXML public JFXTextField supplierIdText,supplierNameText,supplierTelText,supplierAddrText;
    private static Integer supplierTemp = 0;
    public static void setSupplierTemp(Integer supplierTemp) {
        setController.supplierTemp = supplierTemp;
    }

    /**显示Dialog**/
    public void show_supplierDialog(String str){
        supplierDialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_supplierDialog.setText(str);
        supplierDialog.show(supplierRoot);
    }
    /***提交或修改进货商
     *
     *  temp = 0 提交;
     *  temp = 1 修改;
     * */
    public void supplierInsertButton(){
        if(super.TextisNull(supplierIdText,supplierNameText,supplierTelText,supplierAddrText)==null){
            show_supplierDialog("输入框为空!!!");
            return;
        }
        List<String> strings = super.TextisNull(supplierIdText,supplierNameText,supplierTelText,supplierAddrText);
        switch (supplierTemp){
            case 0:
                setViewService.supplierInsetUpdate("insert",strings);
                break;
            case 1:
                setViewService.supplierInsetUpdate("update",strings);
                break;
        }
        super.clearText(supplierIdText,supplierNameText,supplierTelText,supplierAddrText);
        /**刷新界面**/
        setViewService.show_SupplierJFXTreeTableColumn();
    }
    @FXML
    public void clearText(){
        super.clearText(supplierIdText,supplierNameText,supplierTelText,supplierAddrText);
    }
    @FXML
    public void thisSupplierIdExist(){
        if(supplierIdText.getText().length()!=0) {
            if (!super.isnumber(supplierIdText.getText())){
                show_supplierDialog("请输入整数类型的数据");
                return;
            }else{
                if(setMapper.findSupplierVoByid(Integer.valueOf(supplierIdText.getText()))!=null)
                    show_supplierDialog("当前编号已经存在!!!");
            }
        }
    }
    /**进货商TreeColumn配置**/
    @FXML
   public JFXTreeTableColumn<SupplierVo,String> supplierId,supplierName,supplierTel,supplierAddr,supplierUpdate,supplierDelete;



    private SetMapper setMapper;
    private SetViewServiceImpl setViewService;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manage.setSetController(this);

        /**配置存在当前目录下Dialog的AcceptButton **/
        acceptButton.setOnAction(action -> dialog.close());
        WacceptButton.setOnAction(action -> Wdialog.close());
        bAcceptButton.setOnAction(action -> bDialog.close());
        supplierAcceptButton.setOnAction(action -> supplierDialog.close());

        /****/
        setMapper = BaseHolder.getApplicationContext().getBean("setMapper", SetMapper.class);
        setViewService =  BaseHolder.getApplicationContext().getBean("setViewService", SetViewServiceImpl.class);

        showWarehouseListView(listView);
        showBClassListView(bClassListView);
        /**初始化Supplier的TreeTableView**/
        setViewService.setSupplierTreeTableView();
        setViewService.show_SupplierJFXTreeTableColumn();


    }
}
