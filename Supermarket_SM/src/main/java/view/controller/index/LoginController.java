package view.controller.index;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.util.Manage;
import view.util.StageManage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.spring.BeanManage.accountService;
import static com.spring.BeanManage.viewAssistImpl;


public class LoginController extends ViewAssistImpl implements Initializable {

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


    private Stage menu;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Thread(()->{
            //绑定dilog按鈕
            acceptButton.setOnAction(action -> dialog.close());
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
                System.out.println("插入界面");
                try {
                    StageManage.setPersonsAddStage(getNO_Title_Stage(863,469,"測試", "/new_fxml/persons/personsAdd.fxml","/new_images/shop_car.png",null));
                    StageManage.setBuyAddStage(getNO_Title_Stage(730,600,"測試", "/new_fxml/buy/buyAdd.fxml","/new_images/shop_car.png",null));
                    StageManage.setGoodsAddStage(getNO_Title_Stage(863,469,"測試", "/new_fxml/goods/goodsAdd.fxml","/new_images/shop_car.png",null));

                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        Manage.setAccount(accountService.login(user,password));
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
