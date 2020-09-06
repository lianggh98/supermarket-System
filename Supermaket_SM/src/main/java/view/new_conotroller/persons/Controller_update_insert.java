package view.new_conotroller.persons;

import com.BeanVo.PersonsVo;
import com.dao.personsMapper;
import com.jfoenix.controls.*;
import com.service.Impl.personsServiceImpl;
import com.spring.BaseHolder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

public class Controller_update_insert extends ViewAssistImpl implements Initializable {



    /**
     *
     * temp = 0; 增加数据
     * temp =1; 修改数据
     * **/
    private static Integer temp=0;
    public static void setTemp(Integer temp) {
        Controller_update_insert.temp = temp;
    }
    private static PersonsVo personsVo;
    public static void setPersonsVo(PersonsVo personsVo) {
        Controller_update_insert.personsVo = personsVo;
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
    HBox P_out;
    @FXML
    JFXTextField pid,pname,age,pnumber,tel;
    @FXML
    JFXComboBox<String> sex,dep,post;
    @FXML
    JFXTimePicker inTime,outTime;
    @FXML
    JFXDatePicker inDate,outDate;
    private personsServiceImpl service;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(service==null)
            service = BaseHolder.getApplicationContext().getBean("personsService", personsServiceImpl.class);
//        清除dialog顯示
        root.getChildren().remove(dialog);
//        绑定dilog按鈕
        acceptButton.setOnAction(action -> dialog.close());
//      部门下选款的显示
        service.show_Dep_ComboBox(dep);
//      职位下选款的显示
        service.show_Post_ComboBox(post);

         if(temp==1){
            P_out.setVisible(true);
            pid.setText(personsVo.getId().toString());
            pname.setText(personsVo.getPname());
            age.setText(personsVo.getAge().toString());
            sex.setValue(personsVo.getSex());
            pnumber.setText(personsVo.getPnumber());
            tel.setText(personsVo.getTel());
            dep.setValue(personsVo.getDepid()+personsVo.getDepname());
            post.setValue(personsVo.getPostid()+personsVo.getPostname());
             String comeTime = personsVo.getCometime().toString();
             inDate.setValue(LocalDate.parse(comeTime.substring(0,comeTime.indexOf(" "))));
             inTime.setValue(LocalTime.parse(comeTime.substring(comeTime.indexOf(" ")+1)));
             if(personsVo.getOuttime()!=null) {
                 String string = personsVo.getOuttime().toString();
                 outDate.setValue(LocalDate.parse(string.substring(0, string.indexOf(" "))));
                 outTime.setValue(LocalTime.parse(string.substring(string.indexOf(" ")+1)));
             }
        }
    }

    public void clearInsertDate(){
        super.clearText(pid,pname,age,pnumber,tel);
        inDate.setValue(null);
        inTime.setValue(null);
                outDate.setValue(null);
                outTime.setValue(null);

    }
    @FXML
    public void B_closeMaster(){
        P_out.setVisible(false);
       Stage stage = (Stage) B_close.getScene().getWindow();
       stage.close();
        clearInsertDate();
    }

    @FXML
    public void B_update(){
        if(super.TextisNull(pid,pname,age,pnumber,tel)==null){
            show_Dialog("输入框不能为空");
            return;
        }else if(!super.isnumber(age.getText())){
            show_Dialog("输入的年龄不为数字");
            return;
        }else if(!super.isnumber(tel.getText())||!super.isnumber(pnumber.getText())){
            show_Dialog("输入的联系方式或身份证号码不为数字");
            return;
        }
        else if(sex.getValue()==null||super.isnumber(sex.getValue())){
            show_Dialog("性别输入不正确");
            return;
        }
        else if(dep.getValue()==null||post.getValue()==null){
            show_Dialog("部门选择或职位选择不能为空");
            return;
        }else if(super.getTime(inDate,inTime)==null){
            show_Dialog("入职时间不能为空");
            return;
        }
//        在这里开始提取数据后向服务层提交
        List<String> list = super.TextisNull(pid,pname,age,pnumber,tel);
        list.add(sex.getValue().substring(0,1));
        list.add(super.fromStringGetInteger(dep.getValue()).toString());
        list.add(super.fromStringGetInteger(post.getValue()).toString());
        Timestamp inTimeStamp = super.getTime(inDate,inTime);
        Timestamp outTimeStamp = super.getTime(outDate,outTime);


//       开始向服务层提交
        switch (temp){
            case 0:/**提交**/
                service.persons_Insert$Update("insert",list,inTimeStamp,outTimeStamp);
                Manage.getController_persons().L_Error.setText("数据提交成功");
                break;
            case 1:/**修改**/
                service.persons_Insert$Update("update",list,inTimeStamp,outTimeStamp);
                Manage.getController_persons().L_Error.setText("数据修改成功");
                break;
        }


//        刷新界面
        service.show_JFXTreeTableColumn();
        super.setMessageType(Manage.getController_persons().P_Error,Manage.getController_persons().L_Error,"message");
        B_closeMaster();
    }
    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }
    @FXML
    public void existPersonsId(){
        if(super.isnumber(pid.getText())){
            personsMapper mapper = BaseHolder.getApplicationContext().getBean("personsMapper",personsMapper.class);
            if(mapper.findPersonsByIds(Integer.valueOf(pid.getText()))!=null){
                show_Dialog("当前id已经存在,请重新输入");
            }

        }
    }
}
