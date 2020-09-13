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
import view.controller.buy.BuyController;
import view.controller.buy.BuyControllerInsertUpdate;
import view.controller.goods.GoodsController;
import view.controller.goods.GoodsControllerInsertUpdate;
import view.controller.index.IndexController;
import view.controller.index.SetController;
import view.controller.persons.PersonsController;
import view.controller.persons.PersonsControllerInsertUpdate;
import view.controller.stock.StockController;
import view.controller.stock.StockControllerInsertUpdate;

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
    private static Account account;
    private static IndexController controller;
    private static BuyController buyController;
    private static BuyControllerInsertUpdate buyControllerInsertUpdate;
    private static PersonsController personsController;
    private static PersonsControllerInsertUpdate personsControllerInsertUpdate;
    private static GoodsController goodsController;
    private static GoodsControllerInsertUpdate goodsControllerInsertUpdate;
    private static StockController stockController_;
    private static StockControllerInsertUpdate stockControllerInsertUpdate;
    private static SetController setController;


    public static Stage getMenuStage() {
        return MenuStage;
    }

    public static void setMenuStage(Stage menuStage) {
        MenuStage = menuStage;
    }

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        Manage.account = account;
    }

    public static IndexController getController() {
        return controller;
    }

    public static void setController(IndexController controller) {
        Manage.controller = controller;
    }

    public static BuyController getBuyController() {
        return buyController;
    }

    public static void setBuyController(BuyController buyController) {
        Manage.buyController = buyController;
    }

    public static BuyControllerInsertUpdate getBuyControllerInsertUpdate() {
        return buyControllerInsertUpdate;
    }

    public static void setBuyControllerInsertUpdate(BuyControllerInsertUpdate buyControllerInsertUpdate) {
        Manage.buyControllerInsertUpdate = buyControllerInsertUpdate;
    }

    public static PersonsController getPersonsController() {
        return personsController;
    }

    public static void setPersonsController(PersonsController personsController) {
        Manage.personsController = personsController;
    }

    public static PersonsControllerInsertUpdate getPersonsControllerInsertUpdate() {
        return personsControllerInsertUpdate;
    }

    public static void setPersonsControllerInsertUpdate(PersonsControllerInsertUpdate personsControllerInsertUpdate) {
        Manage.personsControllerInsertUpdate = personsControllerInsertUpdate;
    }

    public static GoodsControllerInsertUpdate getGoodsControllerInsertUpdate() {
        return goodsControllerInsertUpdate;
    }

    public static void setGoodsControllerInsertUpdate(GoodsControllerInsertUpdate goodsControllerInsertUpdate) {
        Manage.goodsControllerInsertUpdate = goodsControllerInsertUpdate;
    }

    public static SetController getSetController() {
        return setController;
    }

    public static void setSetController(SetController setController) {
        Manage.setController = setController;
    }

    public static StockController getStockController_() {
        return stockController_;
    }

    public static void setStockController_(StockController stockController_) {
        Manage.stockController_ = stockController_;
    }

    public static GoodsController getGoodsController() {
        return goodsController;
    }

    public static void setGoodsController(GoodsController goodsController) {
        Manage.goodsController = goodsController;
    }

    public static StockControllerInsertUpdate getStockControllerInsertUpdate() {
        return stockControllerInsertUpdate;
    }

    public static void setStockControllerInsertUpdate(StockControllerInsertUpdate stockControllerInsertUpdate) {
        Manage.stockControllerInsertUpdate = stockControllerInsertUpdate;
    }

    public WebEngine personsWebEngine;
    private List<Integer> personsCountList;
    private  JSObject personsWin;
    /**
     * Persons图表初始化
     * @return void
     * @Author Ryo
     * @create 2020/9/12 17:04
    */
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
        for(Pcount p:mapper.count_personsByDep()) {
            personsCountList.add(p.getPcount());
        }
        personsWin.eval("getChart_Date_ByJava("+personsCountList+")");
    }

    private void inCompanyPersonsCounts(){
        Integer count  = 0;
        for(Integer i :personsCountList) {
            count+=i;
        }
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
        HashMap map  =new HashMap();
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        Integer temp  = mapper.getToday_entry(map).size();
        return temp;
    }
}
