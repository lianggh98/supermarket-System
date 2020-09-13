package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import view.util.Manage;
import view.util.StageManage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.util.Optional;

import static com.spring.BeanManage.viewAssistImpl;

public class loginFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //1.5menu 直接打开
//        Parent root = FXMLLoader.load(getClass().getResource("/new_fxml/index/new_index.fxml"));
//        System.out.println(root);
//        primaryStage.setTitle("超市后台管理系统");
//        //显示大小
//        Scene scene = new Scene(root, 1300, 850);
//        //设置标题icon
//        primaryStage.getIcons().add(new Image("/new_images/shop_car.png"));
//        //设置窗体
//        primaryStage.setScene(scene);
//        //添加css
//        scene.getStylesheets().add(String.valueOf(getClass().getResource("/new_css/index.css")));
//        Manage.setMenuStage(primaryStage);
//        primaryStage.show();//显示



//        登录界面打开
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/new_fxml/index/login.fxml"));
        System.out.println(root);
        primaryStage.setTitle("超市后台管理系统");
        //显示大小
        Scene scene = new Scene(root, 500, 600);
        //设置标题icon
        primaryStage.getIcons().add(new Image("/new_images/shop_car.png"));
        //设置窗体
        primaryStage.setScene(scene);
        //添加css
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/new_css/index.css")));
//        存入全局管理控制
        Manage.setMenuStage(primaryStage);
        primaryStage.show();//显示




    }


}
