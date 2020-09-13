package view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/14 19:08
 * @Version 1.0
 **/
public class Controller_dialog implements Initializable {
    @FXML
    private JFXButton centerButton;
    @FXML
    private JFXButton topButton;
    @FXML
    private JFXButton rightButton;
    @FXML
    private JFXButton bottomButton;
    @FXML
    private JFXButton leftButton;
    @FXML
    private JFXButton acceptButton;
    @FXML
    private JFXButton alertButton;
    @FXML
    private StackPane root;
    @FXML
    private JFXDialog dialog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.getChildren().remove(dialog);
        centerButton.setStyle("-fx-background-color: #FF4040;-fx-text-fill: white");
        centerButton.setOnAction(actionEvent -> {
            System.out.println("点击了");
            dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
            dialog.show(root);
        });

        acceptButton.setOnAction(action -> dialog.close());


    }


}
