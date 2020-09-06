package view.new_conotroller.buy;

import com.BeanVo.BuyVo;
import com.dao.buyMapper;
import com.jfoenix.controls.*;
import com.service.Impl.buyServiceImpl;
import com.spring.BaseHolder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.util.Manage;
import view.util.ViewAssistImpl;


import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class Controller_buy_update_insert extends ViewAssistImpl implements Initializable {



    /**
     * 重新定义数据库里德model表
     * 解决修改增加表无法添加Date Time 控件
     *
     *  后端开始 实现数据的增加修改。保证测试可用性
     *  页面修改
     *
     *  考虑商品分类的添加，部门添加放在哪个位置
     *
     * 关闭 提交按钮整体往下移动
     * 关闭按钮改色 建议炎色
     * 提交按钮改色 改浅一点
     * 补充整个表单图片
     *
     * 可以开始设计下个Person的增加界面，增加界面修改界面全部用一个即可
     *
     * */



    /**
     *
     *  temp = 0 為增加數據
     *  temp = 1 為修改數據
     *
     * **/
    private static Integer temp=0;
    /**公共存储数据源**/
    private static BuyVo buyV;
    public static void setTemp(Integer temp) {
        Controller_buy_update_insert.temp = temp;
    }
    public static void setBuyV(BuyVo buyV) {
        Controller_buy_update_insert.buyV = buyV;
    }
    @FXML
    Label L_model,L_Dialog,supplierName;
    @FXML
    StackPane root;
    @FXML
    JFXDialog dialog;
    @FXML
    JFXButton B_close;
    @FXML
    JFXButton acceptButton;
    @FXML
    JFXTextField inid,number,gid,gname,model,price,prices,pid,pname,supplier,expiration;
    @FXML
    JFXTimePicker inTime,producedTime;
    @FXML
    JFXDatePicker inDate,producedDate;
    private buyServiceImpl buyService;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        清除dialog顯示
        root.getChildren().remove(dialog);
//        绑定dilog按鈕
        acceptButton.setOnAction(action -> dialog.close());
        if(temp==0){
            L_model.setText("修改");
            System.out.println("進入增加");
        }
        if(temp==1){
            L_model.setText("修改");
            System.out.println("進入修改");
            inid.setText(buyV.getBuyid().toString());
            number.setText(buyV.getQuantity());
            gid.setText(buyV.getGid().toString());
            gname.setText(buyV.getGname());
            model.setText(buyV.getModel());
            price.setText(buyV.getPrice().toString());
            prices.setText(buyV.getPrices().toString());
            pid.setText(buyV.getPid().toString());
            pname.setText(buyV.getPname());
            supplier.setText(buyV.getSupplier().toString());
            expiration.setText(buyV.getExpiration());



            String comtime = buyV.getComeTime().toString();
            inDate.setValue(LocalDate.parse(comtime.substring(0,comtime.indexOf(" "))));
            inTime.setValue(LocalTime.parse(comtime.substring(comtime.indexOf(" ")+1)));
            String produced  = buyV.getProduced().toString();
            producedDate.setValue(LocalDate.parse(produced.substring(0,produced.indexOf(" "))));
            producedTime.setValue(LocalTime.parse(produced.substring(comtime.indexOf(" ")+1)));

//             保质期
        }
        if(buyService==null)
            buyService = BaseHolder.getApplicationContext().getBean("buyService", buyServiceImpl.class);
    }
    @FXML/**Dialog关闭事件**/
    public void B_closeMaster(){
       Stage  stage= (Stage)B_close.getScene().getWindow();
       stage.close();
        clear_InsertTemp();
    }
    @FXML/**数据提交**/
    public void B_update(){
//        判斷輸入款的數據是否為空
        if(super.TextisNull(inid,number,gid,gname,model,price,prices,pid,pname,expiration)==null){
            show_Dialog("输入框不能为空");
            return;
        }else if(super.getTime(inDate,inTime)==null||super.getTime(producedDate,producedTime)==null){
            show_Dialog("入库时间或生产时间不能为空");
            return;
        }
        else {
//            提交數據
            List<String> strings = super.TextisNull(inid,gid,model,number,price,prices,supplier,pid,expiration);
            Timestamp inTimeStamp = super.getTime(inDate,inTime);
            Timestamp producedDateTimeStamp = super.getTime(producedDate,producedTime);
//          向服务层开始提交数据
                switch (temp){
                    case 0:
                        buyService.update_inser("insert",super.TextisNull(inid,gid,model,number,price,prices,supplier,pid,expiration),inTimeStamp,producedDateTimeStamp);
                        super.setMessageType( Manage.getController_buy().P_buy_Error,  Manage.getController_buy().L_buy_Error, "message");
                        Manage.getController_buy().L_buy_Error.setText("已经成功添加对象");
                        clear_InsertTemp();
                        B_closeMaster();
                        break;
                    case 1:
                        buyService.update_inser("update",super.TextisNull(inid,gid,model,number,price,prices,supplier,pid,expiration),inTimeStamp,producedDateTimeStamp);
                        super.setMessageType( Manage.getController_buy().P_buy_Error,  Manage.getController_buy().L_buy_Error, "message");
                        Manage.getController_buy().L_buy_Error.setText("已经成功修改,编号为:"+buyV.getBuyid()+"对象");
                        B_closeMaster();
                        break;
                }
            Manage.getController().buyModelRStart();
        }
    }
    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }
    /**自动获取**/
    @FXML
    public void get_Ginfo(){
        if(gid.getText().length()!=0||super.isnumber(gid.toString()))
        super.autoSelectedGid(gid.getText(),gname);
    }
    @FXML
    public void get_Pinfo(){
        if(pid.getText().length()!=0||super.isnumber(pid.toString()))
        super.autoSelectedPid(pid.getText(),pname);
    }
    @FXML
    public void get_supplierInfo(){
        if(supplier.getText().length()!=0||super.isnumber(supplier.toString()))
            super.autoSelectedSupplier(supplier.getText(),supplierName);
    }
    @FXML
    public void auto_sumPrices(){
        if(price.getText().length()!=0&&number.getText().length()!=0) {
            if (!(super.isnumber(this.price.getText()) && super.isnumber(number.getText()))) {
                show_Dialog("输入的单价或数量必须为数字类型");
                return;
            }
            Double price = Double.valueOf(this.price.getText());
            Double number = Double.valueOf(this.number.getText());
            Double sum = price * number;
            prices.setText(sum.toString());
        }
    }
    @FXML/**输入时候判断是否存在**/
    public void existBuyId(){
        if(super.isnumber(inid.getText())){
            buyMapper mapper = BaseHolder.getApplicationContext().getBean("buyMapper",buyMapper.class);
            if(mapper.findBuyByIds(Integer.valueOf(inid.getText()))!=null){
                show_Dialog("当前编号已经存在,请重新输入");
            }

        }
    }

    /****/
    public void clear_InsertTemp(){
        super.clearText(inid,number,gid,gname,model,price,prices,pid,pname,expiration);
        inDate.setValue(null);
        inTime.setValue(null);
        producedDate.setValue(null);
        producedTime.setValue(null);
    }
}
