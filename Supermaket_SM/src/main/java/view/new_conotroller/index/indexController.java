package view.new_conotroller.index;



import com.Bean.Account.loginRecordCount;
import com.dao.accountMapper;
import com.dao.buyMapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.service.Impl.buyServiceImpl;
import com.service.Impl.accountServiceImpl;
import com.spring.BaseHolder;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.net.URL;
import java.util.*;

import static java.lang.Long.MAX_VALUE;


/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/6 8:30
 * @Version 1.0
 **/
public class indexController extends ViewAssistImpl implements Initializable {


    /**JFXDialog**/
    @FXML
    StackPane root;
    @FXML
    Label L_Dialog;
    @FXML
    JFXDialog dialog;
    @FXML
    JFXButton quitButton,logoutButton;
    public void show_Dialog(String str){
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        L_Dialog.setText(str);
        dialog.show(root);
    }
    @FXML
    BorderPane menu;

    @FXML
    VBox vbox;
    @FXML
    public WebView html,loginChart,buyChart;
    @FXML
    public Label L_personCount,L_entrantPersons;

    @FXML
    VBox P_menu,P_goods,P_buy,P_persons,P_saleRecord,P_stock,P_set;

    @FXML
    JFXListView<String> contentList;
    @FXML
    Label L_loginrecord,L_todayIntable,L_todaySpending,L_waitIntable,L_userName;


    private  Manage management;
    private JSObject  loginRecordWin,buyWin;
    private Integer[] integers = new Integer[]{2,3,4,5,6,7};



    public void Open_goods(){
        show_View(P_goods,P_menu,P_buy,P_persons,P_saleRecord,P_stock,P_set);
    }
    public void Open_buy(){
        show_View(P_buy,P_menu,P_goods,P_persons,P_saleRecord,P_stock,P_set);
    }
    public void Open_set(){
        show_View(P_set,P_menu,P_buy,P_goods,P_persons,P_saleRecord,P_stock);
    }

    public void Open_stock(){
        show_View(P_stock,P_menu,P_buy,P_goods,P_persons,P_saleRecord,P_set);
    }
    public void Open_persons(){
        show_View(P_persons,P_menu,P_buy,P_goods,P_stock,P_saleRecord,P_set);
    }
    public void Open_menu(){
        show_View(P_menu,P_persons,P_buy,P_goods,P_stock,P_saleRecord,P_set);
    }
    public void left_menu_init(){

        HBox ainhbox  = (HBox) vbox.getChildren().get(2);
        ImageView ainimg = (ImageView) ainhbox.getChildren().get(0);
        Label ainlabel = (Label) ainhbox.getChildren().get(1);
        //先选中主菜单
        String mainurl = "/new_images/icon_" + 2 + "_hover.png";
        //设置被点击后的字体背景图片
        ainlabel.setStyle("-fx-text-fill: #FFFFFF");
        ainhbox.setStyle("-fx-background-color:#27A9E3;");
        ainimg.setImage(new Image(getClass().getResourceAsStream(mainurl)));

        for(Integer i:integers){
            HBox hbox  = (HBox) vbox.getChildren().get(i);
            ImageView img = (ImageView) hbox.getChildren().get(0);
            Label label = (Label) hbox.getChildren().get(1);
            hbox.setOnMouseClicked(event -> {

                switch (i){
                    case 2:Open_menu();
                        break;
                    case 3:Open_persons();
                        break;
                    case 4:Open_goods();
                        break;
                    case 5:Open_buy();
                        break;
                    case 6:Open_stock();
                        break;
                    case 7:Open_set();
                        break;
                }

                String url = "/new_images/icon_" + i + "_hover.png";
                //设置被点击后的字体背景图片
                label.setStyle("-fx-text-fill: #FFFFFF");
                hbox.setStyle("-fx-background-color:#27A9E3;");
                img.setImage(new Image(getClass().getResourceAsStream(url)));
                for(Integer x:integers){
                    if(i!=x){/** 取消其他的未被选中样式**/
                        HBox change_box  = (HBox) vbox.getChildren().get(x);
                        ImageView change_img = (ImageView) change_box.getChildren().get(0);
                        Label change_label = (Label) change_box.getChildren().get(1);
                        url = "/new_images/icon_" + x + ".png";
                        change_label.setStyle("-fx-text-fill: #a5a8ab");
                        change_box.setStyle("");
                        change_img.setImage(new Image(getClass().getResourceAsStream(url)));
                    }
                }
            });
            hbox.setOnMouseEntered(event -> {
                String url = "/new_images/icon_" + i + "_hover.png";
                label.setStyle("-fx-text-fill: #FFFFFF");
                img.setImage(new Image(getClass().getResourceAsStream(url)));

            });
            hbox.setOnMouseExited(event -> {
                if(hbox.getStyle().indexOf("#27A9E3")==-1) {
                    String url = "/new_images/icon_" + i + ".png";
                    label.setStyle("-fx-text-fill: #a5a8ab");
                    img.setImage(new Image(getClass().getResourceAsStream(url)));
                }
            });
        }
    }


    /**
    * @Description: 显示各个图表
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/20
    */
    public void show(){
        Platform.runLater(()->{
            try {
                management.PersonsModelRStart();
                loginRecordModelRStart();
                buyModelRStart();
            }catch (Exception e){
                new Exception("无效错误");
            }
        });


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**Dialog退出按钮事件**/
        quitButton.setOnAction(action-> {
            Stage stage = (Stage) menu.getScene().getWindow();
            stage.close();
        });
        /**Dialog注销按钮事件**/
        logoutButton.setOnAction(action->{
                    Stage stage = (Stage) menu.getScene().getWindow();
                    stage.close();
                    dialog.close();
                    Manage.getMenuStage().show();
                });


        /***关闭其他Pane**/
        Vbox_Init(P_goods,P_buy,P_persons,P_saleRecord,P_stock,P_set);
        /**把当前Controller层传入中央共享**/
        Manage.setController(this);
        management= BaseHolder.getApplicationContext().getBean("stateManagement", Manage.class);




        /**启动Persons图表**/
        management.personsWebViewInit();

        /**启动loginRecord图表**/
        final WebEngine webengine = loginChart.getEngine();
        webengine.load(this.getClass().getClassLoader().getResource("html/loginChart.html").toExternalForm());
        webengine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> ov, Worker.State oldState,
                 Worker.State newState) -> {
                      loginRecordWin= (JSObject) webengine.executeScript("window");
                        loginRecordModelRStart();

                });
        /**启动buy图表**/
        final WebEngine buyWebngine= buyChart.getEngine();
        buyWebngine.load(this.getClass().getClassLoader().getResource("html/buyChart.html").toExternalForm());
        buyWebngine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> ov, Worker.State oldState,
                 Worker.State newState) -> {
                     buyWin= (JSObject) buyWebngine.executeScript("window");
                    buyModelRStart();
                });

        /**图表再次加载**/

        /**初始化并加载左边的menu控件**/
        left_menu_init();


    }




    /**
    * @Description: 登录记录格子的重新加载
    * @Param: [loginRecordWin]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/20s
    */
    public void loginRecordModelRStart(){
        accountServiceImpl accountService = BaseHolder.getApplicationContext().getBean("accountService",accountServiceImpl.class);
        /**从数据库开始读写当日的登录记录**/
        Integer todayLogin = accountService.get_LoginRecord(contentList);
        /**从数据库开始读写当日的登录记录**/
        L_loginrecord.setText(todayLogin.toString()+" 次");

        accountMapper mapper = BaseHolder.getApplicationContext().getBean("accountMapper",accountMapper.class);
        List<Integer> loginRecord = new ArrayList<>();
        for(loginRecordCount l : mapper.CountTodayLoginRecordAll()){
            loginRecord.add(l.getLcount());
        }
        /**通过json发送给HTml页面**/
        loginRecordWin.eval("getLoginRecordDateByJava("+loginRecord+")");
    }


    /**
    * @Description: buy格子的重新加载
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/20
    */
    public void buyModelRStart(){
        buyServiceImpl buyService = BaseHolder.getApplicationContext().getBean("buyService", buyServiceImpl.class);
        buyMapper mapper = BaseHolder.getApplicationContext().getBean("buyMapper", com.dao.buyMapper.class);
        List<Integer> list =   buyService.get_EveryDayBuyRecord(super.get_Moday_Sunday());
        /**通过json发送给HTml页面**/
        try {
            buyWin.eval("getbuyDateByJava("+list+")");
        }catch (Exception e){
            new Exception("无效错误");
        }

        /**写入今日采购次数**/
        L_todayIntable.setText("");
        Integer temp = mapper.findEveryDayBuyRecord(super.get_00_23()).size();
        if(temp!=null)
        L_todayIntable.setText(temp.toString());

        /**写入今日开销**/
        L_todaySpending.setText("");
        Double todayExpend = mapper.sumTodayExpend(super.get_00_23());
        if(todayExpend!=null)
            L_todaySpending.setText(todayExpend.toString());

        /**写入待入库**/
        L_waitIntable.setText("");
        Integer notDate = mapper.findinTbaleNoDate().size();
        if(notDate!=null)
            L_waitIntable.setText(notDate.toString());


        contentList.getItems().removeAll();
    }

    /**
     * @Description: 打开需要显示 View 隐藏其他View
     * @Param: [show, close]
     * @return: void
     * @Author: Ryo
     * @Date: 2020/7/20
     */
    public void show_View(VBox show,VBox...close){
        show.setMaxHeight(MAX_VALUE);
        show.setMaxWidth(MAX_VALUE);
        show.setVisible(true);
        show.setManaged(true);
        for(int i=0;i<close.length;i++){
            close[i].setMaxHeight(0);
            close[i].setMaxWidth(0);
            close[i].setVisible(false);
            close[i].setManaged(false);
        }
    }


    /**
    * @Description: 初始化各个窗口并且设为最小
    * @Param: [list]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/20
    */
    public void Vbox_Init(VBox...list){
        for(VBox v:list){
            v.setPrefHeight(0);
            v.setPrefWidth(0);
            v.setVisible(false);
        }
    }
}
