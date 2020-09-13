package view.util;

import javafx.stage.Stage;

/**
 * @Author:liamg
 * @Date:2020/9/12
 */
public class StageManage {
    private static Stage PersonsAddStage;
    public static void setPersonsAddStage(Stage personsAddStage) {
        PersonsAddStage = personsAddStage;
    }
    public static Stage getPersonsAddStage() {
        return PersonsAddStage;
    }

    private static Stage buyAddStage;
    public static void setBuyAddStage(Stage buyAddStage) {
        StageManage.buyAddStage = buyAddStage;
    }
    public static Stage getBuyAddStage() {
        return buyAddStage;
    }

    private static Stage goodsAddStage;
    public static void setGoodsAddStage(Stage goodsAddStage) {
        StageManage.goodsAddStage = goodsAddStage;
    }
    public static Stage getGoodsAddStage() {
        return goodsAddStage;
    }
}
