package view.new_conotroller.persons;

import com.BeanVo.PersonsVo;
import com.jfoenix.controls.*;
import com.service.Impl.personsServiceImpl;
import com.spring.BaseHolder;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/12 17:29
 * @Version 1.0
 **/
public class Controller_persons extends ViewAssistImpl implements Initializable {

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
    private personsServiceImpl service;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Manage.setController_persons(this);

        service = BaseHolder.getApplicationContext().getBean("personsService", personsServiceImpl.class);
        service.set_JFXTreeTableColumn(select,id,name,sex,age,tel,number,depName,postName,comeTime,outTime,set);
//        set_JFXTreeTableColumn();
        service.show_JFXTreeTableColumn();
//                   模糊查询
        personsSearchField.textProperty().addListener(setupSearchField(personsTreeTableView));
        P_Error.setVisible(false);

    }



    private Stage updateStage;
    @FXML
    public void open_UpdateView() throws IOException {
        Controller_update_insert.setTemp(0);
        if(updateStage==null)
         updateStage =  super.getNO_Title_Stage(869,469,"測試", "/new_fxml/persons/personsAdd.fxml","/new_images/shop_car.png",null);
        updateStage.show();
    }

    @FXML
    public void B_selected() {
       if(service.selected()==0){
           super.setMessageType(P_Error,L_Error,"error");
           L_Error.setText("请选中需要删除的对象");
           return;
       }
        super.setMessageType(P_Error,L_Error,"message");
        Manage.getController_persons().L_Error.setText("数据删除成功");
        service.show_JFXTreeTableColumn();
        Manage manage = BaseHolder.getApplicationContext().getBean("stateManagement",Manage.class);
        manage.PersonsModelRStart();
        }
    @FXML
    public void B_refresh(){
            System.out.println("人员管理刷新按钮按下");
            personsTreeTableView.setRoot(null);
            service.show_JFXTreeTableColumn();
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

                    if(person.getOuttime()==null)
                        return person.getPostname().contains(newVal)
                                || person.getDepname().contains(newVal)
                                || person.getPname().contains(newVal)
                                || person.getPnumber().contains(newVal)
                                || person.getSex().contains(newVal)
                                || person.getTel().contains(newVal)
                                || Integer.toString(person.getId()).contains(newVal)
                                || Integer.toString(person.getAge()).contains(newVal)
                                ||person.getCometime().toString().contains(newVal);
                    else
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

                });
    }
}
