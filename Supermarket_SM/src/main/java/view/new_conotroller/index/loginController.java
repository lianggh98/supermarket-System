package view.new_conotroller.index;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.service.impl.AccountServiceImpl;
import com.spring.BaseHolder;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController extends ViewAssistImpl implements Initializable {

    @FXML
    JFXButton B_close;
    @FXML
    JFXTextField user;
    @FXML
    JFXPasswordField password;


    @FXML
    StackPane root;
    @FXML
    Label L_Dialog;
    @FXML
    JFXDialog dialog;
    @FXML
    JFXButton acceptButton;


    private AccountServiceImpl service;
    private Stage menu;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Thread(()->{
            //绑定dilog按鈕
            acceptButton.setOnAction(action -> dialog.close());
            service = BaseHolder.getApplicationContext().getBean("accountService", AccountServiceImpl.class);
        }).start();


        try {
            menu = super.getStage(1300,850,"超市管理系统","/new_fxml/index/new_index.fxml","/new_images/shop_car.png","/new_css/index.css");
            menu.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    /**缩小**/
//                primaryStage.setIconified(true);
                    Manage.getController().show_Dialog("是否需要退出此程序");
                    /***销毁此事件***/
                    event.consume();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
//        监听menu页面被现实后 需要执行的操作
        menu.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                close_Login();
                Manage.getController().show();
                Manage.getController().L_userName.setText(Manage.getAccount().getComment());
                System.out.println("被显示了");

            }
        });

    }

    @FXML
    public void close_Login(){
        Stage stage = (Stage)acceptButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void login() throws IOException {
        if(user.getText().length()==0||password.getText().length()==0){
            show_Dialog("账号密码不能为空");
            return;
        }
        /**存入中央管理区域**/
        Manage.setAccount(service.login(user,password));
        if( Manage.getAccount()==null){
            show_Dialog("账号或密码错误！！！");
            return;
        }else if(Manage.getAccount()!=null){
            Manage.getSetController().accountName.setText(Manage.getAccount().getUser());
            Manage.getController().show();
            menu.show();

        }
    }

    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }

}
