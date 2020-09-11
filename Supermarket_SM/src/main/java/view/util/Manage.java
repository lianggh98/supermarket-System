package view.util;

import com.bean.account.Account;
import com.bean.persons.Pcount;
import com.dao.DepartmentMapper;
import com.dao.PersonsMapper;
import com.spring.BaseHolder;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;
import view.new_conotroller.buy.Controller_buy;
import view.new_conotroller.buy.Controller_buy_update_insert;
import view.new_conotroller.goods.Controller_goods;
import view.new_conotroller.index.indexController;
import view.new_conotroller.index.setController;
import view.new_conotroller.persons.Controller_persons;
import view.new_conotroller.stock.Controller_stock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/17 10:02
 * @Version 1.0
 **/
@Service("stateManagement")
public class Manage {
    private static Stage MenuStage;
    public static void setMenuStage(Stage menuStage) {
        MenuStage = menuStage;
    }
    public static Stage getMenuStage() {
        return MenuStage;
    }

    private static Account account;
    public static void setAccount(Account account) {
        Manage.account = account;
    }
    public static Account getAccount() {
        return account;
    }

    private static indexController controller;
    public static void setController(indexController controller) {
        Manage.controller = controller;
    }
    public static indexController getController() {
        return controller;
    }

    private static Controller_buy controller_buy;
    public static void setController_buy(Controller_buy controller_buy) {
        Manage.controller_buy = controller_buy;
    }
    public static Controller_buy getController_buy() {
        return controller_buy;
    }

    private static Controller_buy_update_insert controller_buy_update_insert;
    public static void setController_buy_update_insert(Controller_buy_update_insert controller_buy_update_insert) {
        Manage.controller_buy_update_insert = controller_buy_update_insert;
    }
    public static Controller_buy_update_insert getController_buy_update_insert() {
        return controller_buy_update_insert;
    }

    private static Controller_persons controller_persons;
    public static void setController_persons(Controller_persons controller_persons) {
        Manage.controller_persons = controller_persons;
    }
    public static Controller_persons getController_persons() {
        return controller_persons;
    }


    public static Controller_goods controller_goods;
    public static void setController_goods(Controller_goods controller_goods) {
        Manage.controller_goods = controller_goods;
    }
    public static Controller_goods getController_goods() {
        return controller_goods;
    }


    public static view.new_conotroller.index.setController setController;
    public static void setSetController(setController setController) {
        Manage.setController = setController;
    }
    public static setController getSetController() {
        return setController;
    }

    public static Controller_stock controller_stock;

    public static void setController_stock(Controller_stock controller_stock) {
        Manage.controller_stock = controller_stock;
    }

    public static Controller_stock getController_stock() {
        return controller_stock;
    }

    public WebEngine personsWebEngine;
    private List<Integer> personsCountList;
    private  JSObject personsWin;
    public void personsWebViewInit(){
        personsWebEngine = controller.html.getEngine();
        personsWebEngine.load(this.getClass().getClassLoader().getResource("html/personsChart.html").toExternalForm());
        personsWebEngine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> ov, Worker.State oldState,
                 Worker.State newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        personsWin= (JSObject) personsWebEngine.executeScript("window");
                        PersonsModelRStart();
                    }
                });
    }
    private void depCharts_RStart(){
        DepartmentMapper mapper = BaseHolder.getApplicationContext().getBean("departmentMapper", DepartmentMapper.class);
        personsCountList = new ArrayList<>();
        for(Pcount p:mapper.count_personsByDep())
            personsCountList.add(p.getPcount());
        personsWin.eval("getChart_Date_ByJava("+personsCountList+")");
    }

    private void inCompanyPersonsCounts(){
        Integer count  = 0;
        for(Integer i :personsCountList)
            count+=i;
        controller.L_personCount.setText(count.toString());
    }

    public void PersonsModelRStart(){
        depCharts_RStart();
        inCompanyPersonsCounts();
        entrant();
    }










    /**
    * @Description: 写入今日入职人数
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/19
    */
    private void entrant(){
        controller.L_entrantPersons.setText(getToday_entry().toString());
    }
    /**
    * @Description: 获取当日入职人数
    * @Param: []
    * @return: java.lang.Integer
    * @Author: Ryo
    * @Date: 2020/7/19
    */
    private Integer getToday_entry() {
        LocalDate localDate = LocalDate.now();
        String today = localDate.toString();
        String startTime = today+" 00:00:00";
        String endTime = today+" 23:59:00";
        PersonsMapper mapper = BaseHolder.getApplicationContext().getBean("personsMapper", PersonsMapper.class);
//        System.out.println(localDate);
//        System.out.println(startTime);
//        System.out.println(endTime);
        HashMap map  =new HashMap();
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        Integer temp  = mapper.getToday_entry(map).size();
        return temp;
    }
}
