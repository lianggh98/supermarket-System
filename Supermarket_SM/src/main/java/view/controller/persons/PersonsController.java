package view.controller.persons;

import com.beanvo.PersonsVo;
import com.jfoenix.controls.*;
import com.spring.BaseHolder;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import view.util.Manage;
import view.util.StageManage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.spring.BeanManage.personsService;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/12 17:29
 * @Version 1.0
 **/
public class PersonsController extends ViewAssistImpl implements Initializable {

    @FXML
    public JFXTreeTableView<PersonsVo> personsTreeTableView;
    @FXML
    public JFXTreeTableColumn<PersonsVo, Boolean> select;
    @FXML
    public JFXTreeTableColumn<PersonsVo, Integer> id,age;
    @FXML
    public JFXTreeTableColumn<PersonsVo, String> name,sex,tel,number,depName,postName,set;
    @FXML
    public JFXTreeTableColumn<PersonsVo, String>comeTime,outTime;
    @FXML
    HBox P_Error;
    @FXML
    Label L_Error;
    @FXML
    public JFXTextField personsSearchField;




    private static ObservableList<PersonsVo> PersonsDate=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manage.setPersonsController(this);


        try {
            personsService.setJFXTreeTableColumn(select,id,name,sex,age,tel,number,depName,postName,comeTime,outTime,set);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        set_JFXTreeTableColumn();
        personsService.showJFXTreeTableColumn();
//                   模糊查询
        personsSearchField.textProperty().addListener(setupSearchField(personsTreeTableView));
        P_Error.setVisible(false);

    }

    @FXML
    public void open_UpdateView() throws IOException {
        PersonsControllerInsertUpdate.setTemp(0);
        if(StageManage.getPersonsAddStage() ==null) {
        }
        //自动递增编号
        Manage.getPersonsControllerInsertUpdate().pid.setText(personsService.getNewIDByLastID().toString());
        StageManage.getPersonsAddStage().show();
    }

    @FXML
    public void B_selected() {
       if(personsService.selected()==0){
           super.setMessageType(P_Error,L_Error,"error");
           L_Error.setText("请选中需要删除的对象");
           return;
       }
        super.setMessageType(P_Error,L_Error,"message");
        Manage.getPersonsController().L_Error.setText("数据删除成功");
        personsService.showJFXTreeTableColumn();
        Manage manage = BaseHolder.getApplicationContext().getBean("stateManagement",Manage.class);
        manage.PersonsModelRStart();
        }
    @FXML
    public void B_refresh(){
            System.out.println("人员管理刷新按钮按下");
            personsTreeTableView.setRoot(null);
        personsService.showJFXTreeTableColumn();
        }
    @FXML
    public void Error_hide(){
        P_Error.setVisible(false);
     }

    //    模糊查询信息
    private ChangeListener<String> setupSearchField(final JFXTreeTableView<PersonsVo> tableView) {
        return (o, oldVal, newVal) ->
                tableView.setPredicate(personProp -> {
                    final PersonsVo person = personProp.getValue();

                    if(person.getOuttime()==null) {
                        return person.getPostname().contains(newVal)
                                || person.getDepname().contains(newVal)
                                || person.getPname().contains(newVal)
                                || person.getPnumber().contains(newVal)
                                || person.getSex().contains(newVal)
                                || person.getTel().contains(newVal)
                                || Integer.toString(person.getId()).contains(newVal)
                                || Integer.toString(person.getAge()).contains(newVal)
                                ||person.getCometime().toString().contains(newVal);
                    } else {
                        return person.getPostname().contains(newVal)
                                || person.getDepname().contains(newVal)
                                || person.getPname().contains(newVal)
                                || person.getPnumber().contains(newVal)
                                || person.getSex().contains(newVal)
                                || person.getTel().contains(newVal)
                                || Integer.toString(person.getId()).contains(newVal)
                                || Integer.toString(person.getAge()).contains(newVal)
                                ||person.getCometime().toString().contains(newVal)
                                ||person.getOuttime().toString().contains(newVal);
                    }

                });
    }
}
