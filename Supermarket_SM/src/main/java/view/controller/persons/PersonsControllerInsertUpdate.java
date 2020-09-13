package view.controller.persons;

import com.beanvo.PersonsVo;
import com.dao.PersonsMapper;
import com.jfoenix.controls.*;
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
import java.util.List;
import java.util.ResourceBundle;

import static com.spring.BeanManage.personsService;

/**
 * @author liamg
 */
public class PersonsControllerInsertUpdate extends ViewAssistImpl implements Initializable {



    /**
     *
     * temp = 0; 增加数据
     * temp =1; 修改数据
     * **/
    private static Integer temp=0;
    public static void setTemp(Integer temp) {
        PersonsControllerInsertUpdate.temp = temp;
    }
    private static PersonsVo personsVo;
    public static void setPersonsVo(PersonsVo personsVo) {
        PersonsControllerInsertUpdate.personsVo = personsVo;
    }
    @FXML
    public StackPane root;
    @FXML
    public Label L_model,L_Dialog;
    @FXML
    public JFXDialog dialog;
    @FXML
    public JFXButton B_close,acceptButton;

    @FXML
    public HBox P_out;
    @FXML
    public JFXTextField pid,pname,age,pnumber,tel;
    @FXML
    public JFXComboBox<String> sex,dep,post;
    @FXML
    public JFXTimePicker inTime,outTime;
    @FXML
    public JFXDatePicker inDate,outDate;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manage.setPersonsControllerInsertUpdate(this);
//        清除dialog顯示
        root.getChildren().remove(dialog);
//        绑定dilog按鈕
        acceptButton.setOnAction(action -> dialog.close());
//      部门下选款的显示
        personsService.show_Dep_ComboBox(dep);
//      职位下选款的显示
        personsService.show_Post_ComboBox(post);

    }

    public void clearInsertDate(){
        super.clearText(pid,pname,age,pnumber,tel);
        inDate.setValue(null);
        inTime.setValue(null);
        outDate.setValue(null);
        outTime.setValue(null);
        sex.setValue("");
        dep.setValue("");
        post.setValue("");

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
        else if(personsService.getAgeByPersonsNumber(pnumber.getText())==-450){
            show_Dialog("身份证长度不合格");
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
//            提交
            case 0:
                personsService.persons_Insert$Update("insert",list,inTimeStamp,outTimeStamp);
                Manage.getPersonsController().L_Error.setText("数据提交成功");
                break;
//             修改
            case 1:
                personsService.persons_Insert$Update("update",list,inTimeStamp,outTimeStamp);
                Manage.getPersonsController().L_Error.setText("数据修改成功");
                break;
        }


//        刷新界面
        personsService.showJFXTreeTableColumn();
        super.setMessageType(Manage.getPersonsController().P_Error,Manage.getPersonsController().L_Error,"message");
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
            PersonsMapper mapper = BaseHolder.getApplicationContext().getBean("personsMapper", PersonsMapper.class);
            if(mapper.findPersonsByIds(Integer.valueOf(pid.getText()))!=null){
                show_Dialog("当前id已经存在,请重新输入");
            }

        }
    }

    /**
     * 从人员身份证获取年龄
     * @return void
     * @Author Ryo
     * @create 2020/9/12 13:28
    */
    @FXML
    public void CheckPNumber(){
       Integer temp = personsService.getAgeByPersonsNumber(pnumber.getText());
       if(temp==-450){
           return;
       }
       if(temp==0){
           show_Dialog("年月日输入不正确");
           return;
       }
       age.setText(temp.toString());
        System.out.println(temp);
    }
}
