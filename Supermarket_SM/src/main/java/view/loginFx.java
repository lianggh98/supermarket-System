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

import java.util.Optional;

public class loginFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //1.5menu
//        Parent root = FXMLLoader.load(getClass().getResource("/new_fxml/index/new_index.fxml"));
//        System.out.println(root);
//        primaryStage.setTitle("超市后台管理系统");
//        Scene scene = new Scene(root, 1300, 850);//显示大小
//        primaryStage.getIcons().add(new Image("/new_images/shop_car.png"));      //设置标题icon
//        primaryStage.setScene(scene);//设置窗体
//        scene.getStylesheets().add(String.valueOf(getClass().getResource("/new_css/index.css")));//添加css
//        primaryStage.show();//显示



//        登录窗口

        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/new_fxml/index/login.fxml"));
        System.out.println(root);
        primaryStage.setTitle("超市后台管理系统");
        Scene scene = new Scene(root, 500, 600);//显示大小
        primaryStage.getIcons().add(new Image("/new_images/shop_car.png"));      //设置标题icon
        primaryStage.setScene(scene);//设置窗体
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/new_css/index.css")));//添加css
        Manage.setMenuStage(primaryStage);




        primaryStage.show();//显示

    }


}
