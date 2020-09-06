package com.service.Impl;

import com.Bean.Persons.Department;
import com.Bean.Persons.Persons;
import com.Bean.Persons.Post;
import com.BeanVo.PersonsVo;
import com.dao.departmentMapper;
import com.dao.personsMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.service.personsServiceInter;
import com.spring.BaseHolder;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import view.new_conotroller.persons.Controller_persons;
import view.new_conotroller.persons.Controller_update_insert;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service("personsService")
public class personsServiceImpl implements personsServiceInter {
    @Autowired
    departmentMapper departmentMapper;
    @Autowired
    private personsMapper mapper;
    @Autowired
    private Manage manage;
    private static ObservableList<PersonsVo> PersonsDate= FXCollections.observableArrayList();
    @Autowired
    ViewAssistImpl viewAssist;


    @Override
    public void set_JFXTreeTableColumn(JFXTreeTableColumn...columns){

        System.out.println(columns.length);
        setPersonsCellValueFactory(columns[0], PersonsVo->  new SimpleBooleanProperty(PersonsVo.getSelected()));
        setPersonsCellValueFactory(columns[1], PersonsVo->  new SimpleIntegerProperty(PersonsVo.getId()).asObject());
        setPersonsCellValueFactory(columns[2], PersonsVo->  new SimpleStringProperty(PersonsVo.getPname()));
        setPersonsCellValueFactory(columns[3], PersonsVo->  new SimpleStringProperty(PersonsVo.getSex()));
        setPersonsCellValueFactory(columns[4], PersonsVo->  new SimpleIntegerProperty(PersonsVo.getAge()).asObject());
        setPersonsCellValueFactory(columns[5], PersonsVo->  new SimpleStringProperty(PersonsVo.getTel()));
        setPersonsCellValueFactory(columns[6], PersonsVo->  new SimpleStringProperty(PersonsVo.getPnumber()));
        setPersonsCellValueFactory(columns[7], PersonsVo->  new SimpleStringProperty(PersonsVo.getDepname()));
        setPersonsCellValueFactory(columns[8], PersonsVo->  new SimpleStringProperty(PersonsVo.getPostname()));
        setPersonsCellValueFactory(columns[9], PersonsVo->  new SimpleStringProperty(PersonsVo.getCometime().toString()));

//            单独设置为空时不报错
        columns[10].setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PersonsVo, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PersonsVo, String> p) {

                return new ReadOnlyObjectWrapper(p.getValue().getValue().getOuttime());
            }
        });

        setPersonsCellValueFactory(columns[11], PersonsVo->  new SimpleStringProperty(PersonsVo.getCometime().toString()));
        /**
         * @Description:设置set为button居中
         */

        columns[11].setCellFactory(new Callback<TreeTableColumn<PersonsVo, String>, TreeTableCell<PersonsVo, String>>() {
            @Override
            public TreeTableCell<PersonsVo, String> call(TreeTableColumn<PersonsVo, String> goodsVoStringTreeTableColumn) {
                TreeTableCell<PersonsVo, String> tc = new TreeTableCell<PersonsVo, String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);
                        final JFXButton jfxButton = new JFXButton("修改");
                        jfxButton.setStyle("-fx-background-color: #3fc1c9;-fx-text-fill: #f5f5f5");
                        if (item != null) {
                            if (this.getTreeTableRow() != null) {
                                    jfxButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {
                                            PersonsVo p = PersonsDate.get(getIndex());
                                            Controller_update_insert.setPersonsVo(p);
                                            Controller_update_insert.setTemp(1);
                                            try {
                                                Stage stage = viewAssist.getNO_Title_Stage(863, 469, "測試", "/new_fxml/persons/personsAdd.fxml", "/new_images/shop_car.png", null);
                                                stage.show();
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

        columns[0].setCellFactory(new Callback<TreeTableColumn<PersonsVo, Boolean>, TreeTableCell<PersonsVo, Boolean>>() {
            @Override
            public TreeTableCell<PersonsVo, Boolean> call(TreeTableColumn<PersonsVo, Boolean> buyTreeTableView) {
                TreeTableCell<PersonsVo, Boolean> tc = new TreeTableCell<PersonsVo, Boolean>() {
                    @Override
                    public void updateItem(Boolean item, boolean empty) {
                        //清空样式
                        setText(null);
                        setGraphic(null);
                        if (item != null) {
                            CheckBox checkBox = new CheckBox();
                            setGraphic(checkBox);
                            if (this.getTreeTableRow() != null) {
                                PersonsVo g = PersonsDate.get(getIndex());
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
    }
    @Override
    public void show_JFXTreeTableColumn(){
        PersonsDate=FXCollections.observableArrayList();
//               从数据源转换
        for(PersonsVo p :mapper.findPersonsVoAll()){
            PersonsDate.add(p);
        }
//          存入TreeTableView
        Manage.getController_persons().personsTreeTableView.setRoot(new RecursiveTreeItem<>(PersonsDate, RecursiveTreeObject::getChildren));
//        关闭主节点的显示
        Manage.getController_persons(). personsTreeTableView.setShowRoot(false);
//        设置树形结构可以编辑
        Manage.getController_persons().personsTreeTableView.setEditable(true);
    }
    @Override
    public  <T> void setPersonsCellValueFactory(JFXTreeTableColumn<PersonsVo, T> column, Function<PersonsVo, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<PersonsVo, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    @Override
    public int selected() {
        List<Integer> list = new ArrayList<>();
        for(PersonsVo p:PersonsDate){
            if (p.getSelected()){
                list.add(p.getId());
            }
        }
        if(list.size()!=0){

            mapper.deletePersonsByIds(list);
//            manage.PersonsModelRStart();
            return 1;
        }
        return list.size();
    }

    @Override
    public void show_Dep_ComboBox(JFXComboBox<String> comboBox){
        List<Department> list =  departmentMapper.findDepartmentAll();
        for(Department d:list)
            comboBox.getItems().add(d.getId()+d.getDepname());
    }
    @Override
    public void show_Post_ComboBox(JFXComboBox<String> comboBox){
        List<Post> list =  departmentMapper.findPostAll();
        for(Post p:list)
            comboBox.getItems().add(p.getId()+p.getPostname());
    }
    @Override
    public void persons_Insert$Update(String type, List<String> strings, Timestamp inTimeStamp,Timestamp outTimeStamp){
        List<Persons> list = new ArrayList<>();
        Persons p = new Persons();
        p.setId(Integer.valueOf(strings.get(0)));
        p.setPname(strings.get(1));
        p.setAge(Integer.valueOf(strings.get(2)));
        p.setPnumber(strings.get(3));
        p.setTel(strings.get(4));
        p.setSex(strings.get(5));
        p.setDepid(Integer.valueOf(strings.get(6)));
        p.setPostid(Integer.valueOf(strings.get(7)));
        p.setCometime(inTimeStamp);
        if(outTimeStamp!=null)
            p.setCometime(outTimeStamp);
        list.add(p);
        switch (type){
            case "insert":
                mapper.insertPersonss(list);
                manage.PersonsModelRStart();
                break;
            case "update":
                mapper.updatePersonss(list);
                break;
        }
    }
}
