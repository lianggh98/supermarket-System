package view.new_conotroller.goods;

import com.BeanVo.GoodsVo;
import com.dao.goodsMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import com.service.Impl.goodsServiceImpl;
import com.spring.BaseHolder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class goodsUpdate_InsertController extends ViewAssistImpl implements Initializable {

    private static Integer temp=0;
    public static void setTemp(Integer temp) {
        goodsUpdate_InsertController.temp = temp;
    }
    private static GoodsVo g;
    public static void setG(GoodsVo g) {
        goodsUpdate_InsertController.g = g;
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
    JFXTextField gid,gname,merchId,money,addr,bid;
    @FXML
    JFXComboBox<String> bname;

    private goodsServiceImpl service;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(service==null)
            service=BaseHolder.getApplicationContext().getBean("goodsService", goodsServiceImpl.class);
            ViewAssistImpl viewAssist = BaseHolder.getApplicationContext().getBean("ViewAssistImpl",ViewAssistImpl.class);
//        清除dialog顯示
        root.getChildren().remove(dialog);
//        绑定dilog按鈕
        acceptButton.setOnAction(action -> dialog.close());
//        查找数据库下有多少类别
        service.showBClassComboBox(bname);
        if(temp==1){
                gid.setText(g.getId().toString());
                gname.setText(g.getGname());
                merchId.setText(g.getMerchid());
                money.setText(g.getMoney().toString());
                addr.setText(g.getGaddr());
                bid.setText(g.getBClass().toString());
                bname.setValue(g.getBClass()+g.getBname());

        }
    }

    @FXML
    public void B_update(){
        if(super.TextisNull(gid,gname,merchId,money,addr,bid)==null){
            show_Dialog("输入框内不能为空");
            return;
        }else if(bname.getValue().length()==0){
            show_Dialog("类别不能为空,请选中对应的类别");
            return;
        }

        List<String> stringList  = super.TextisNull(gid,gname,merchId,money,addr,bid);
        stringList.add(super.fromStringGetInteger(bname.getValue()).toString());




        switch (temp){
            case 0:/**提交**/
                service.goods_Update$Insert("insert",stringList);
                Manage.getController_goods().L_Error.setText("对象添加成功");
                super.clearText(gid,gname,merchId,money,addr,bid);
            break;
            case 1:/**修改**/
                service.goods_Update$Insert("update",stringList);
                Manage.getController_goods().L_Error.setText("对象修改成功");
            break;
        }
        B_closeMaster();
        service.show_JFXTreeTableColumn();
        super.setMessageType(Manage.getController_goods().P_Error,Manage.getController_goods().L_Error,"message");
    }
    @FXML
    public void B_closeMaster(){
        Stage stage = (Stage) B_close.getScene().getWindow();
        super.clearText(gid,gname,merchId,money,addr,bid);
        stage.close();
    }
    @FXML public void auto_Bname(){
        if(super.isnumber(bid.getText())){
           List<String>  strings=  bname.getItems();
            for(int i=0;i<strings.size();i++){
                int index = strings.get(i).indexOf(bid.getText());
                if(index!=-1){
                    bname.getSelectionModel().select(i);
                    return;
                }
            }
            show_Dialog("没有对应的类型编号,请重新输入");
        }
    }
    public void existGoodsId(){
        if(super.isnumber(gid.getText())){
            goodsMapper mapper = BaseHolder.getApplicationContext().getBean("goodsMapper",goodsMapper.class);
            if(mapper.findGoodNameById(Integer.valueOf(gid.getText()))!=null){
                show_Dialog("数据库内已经存在此商品编号,请重新输入");
            }
        }
    }

    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }
}
