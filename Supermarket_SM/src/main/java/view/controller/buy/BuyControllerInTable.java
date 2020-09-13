package view.controller.buy;

import com.beanvo.BuyVo;
import com.jfoenix.controls.*;
import com.service.impl.StockServiceImpl;
import com.spring.BaseHolder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.spring.BeanManage.buyService;
import static com.spring.BeanManage.inTableService;

/**
 * @author liamg
 */
public class BuyControllerInTable extends ViewAssistImpl implements Initializable {

    private static BuyVo buyVo;

    public static void setBuyVo(BuyVo buyVo) {
        BuyControllerInTable.buyVo = buyVo;
    }

    @FXML
    StackPane root;
    @FXML
    Label L_model,L_Dialog;
    @FXML
    JFXDialog dialog;
    @FXML
    JFXButton B_close,acceptButton;



    @FXML
    JFXTextField inPersonId,inPersonName,inStockroom,wname;
    @FXML
    JFXDatePicker inTableDate;
    @FXML
    JFXTimePicker inTableTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acceptButton.setOnAction(action -> dialog.close());

    }
    @FXML
    public void B_update(){
        if(super.TextisNull(inPersonId,inPersonName,inStockroom)==null){
            show_Dialog("请补齐所有的输入框");
            return;
        }else if(!super.isnumber(inPersonId.getText())||!super.isnumber(inStockroom.getText())){
            show_Dialog("输入的操作员编号或仓库编号不是数字,请重新输入");
            return;
        }else if(super.getTime(inTableDate,inTableTime)==null){
            show_Dialog("请填入入库日期或时间");
            return;
        }

        /**提取数据**/
        List<String> strings =  super.TextisNull(inPersonId,inStockroom);
        strings.add(buyVo.getBuyid().toString());
        strings.add(buyVo.getGid().toString());
        strings.add(buyVo.getQuantity());
        Timestamp timestamp = super.getTime(inTableDate,inTableTime);


        new Thread(()->{
            /**发送给服务层**/
            Integer inid = inTableService.inTableUpdate(strings,timestamp);
            /**开启新线程操作Stock库**/
            List<String> stockList = new ArrayList<>();
            stockList.add(inid.toString());
            stockList.add(buyVo.getQuantity());
            stockList.add(inStockroom.getText());
            stockList.add(buyVo.getGid().toString());
            stockList.add(buyVo.getProduced().toString());
            stockList.add(buyVo.getExpiration());
            StockServiceImpl stockService = BaseHolder.getApplicationContext().getBean("stockService", StockServiceImpl.class);
            stockService.stockInsert(stockList);
            System.out.println("执行了");
        }).start();

        Platform.runLater(()->{
            /**关闭当前窗口**/
            B_closeMaster();
            /**设置显示类型**/
            super.setMessageType(Manage.getBuyController().P_buy_Error,Manage.getBuyController().L_buy_Error,"message");
            /**成功提示**/
            Manage.getBuyController(). L_buy_Error.setText("入库成功!!!");
            /**刷新界面**/
            buyService.show_BuyJFXTreeTableColumn();
            inTableService.showInTableJFXTreeTableColumn();
            Manage.getController().buyModelRStart();
        });
    }


    @FXML
    public void B_closeMaster(){
        Stage stage = (Stage) B_close.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void auto_Pname(){
        if(super.isnumber(inPersonId.getText())) {
            super.autoSelectedPid(inPersonId.getText(),inPersonName);
        }
    }
    @FXML
    public void auto_Wname(){
        if(!super.isnumber(inStockroom.getText())){
            show_Dialog("请输入数字类型的编号");
            return;
        }
        else{
            super.autoSelectedWid(inStockroom.getText(),wname);
        }
    }
    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }


}
