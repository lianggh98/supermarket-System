package view.controller.goods;
import com.beanvo.GoodsVo;
import com.jfoenix.controls.*;
import com.spring.BeanManage;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.util.Manage;
import view.util.StageManage;
import view.util.ViewAssistImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.spring.BeanManage.goodsService;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/12 17:29
 * @Version 1.0
 **/
public class GoodsController extends ViewAssistImpl implements Initializable {
    @FXML
    public JFXTextField goodsSearchField;
    @FXML
    public JFXTreeTableView<GoodsVo> goodsTreeTableView;
    @FXML
    public JFXTreeTableColumn<GoodsVo, Boolean> select;
    @FXML
    public JFXTreeTableColumn<GoodsVo, Integer> id, bClass;
    @FXML
    public JFXTreeTableColumn<GoodsVo, String> merchid, gname, gaddr,bName;
    @FXML
    public JFXTreeTableColumn<GoodsVo, Double> money;
    @FXML
    public JFXTreeTableColumn<GoodsVo, String> set;

    @FXML
    HBox P_Error;
    @FXML
    Label L_Error;

    public void Error_hide(){
        P_Error.setVisible(false);
    }

    private static ObservableList<GoodsVo> GoodsDate=FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Error_hide();
        Manage.setGoodsController(this);

        goodsService.setJFXTreeTableColumn(select,id,bClass,merchid,gname,gaddr,money,bName,set);

        goodsService.showJFXTreeTableColumn();
//        模糊查询
        goodsSearchField.textProperty().addListener(setupSearchField(goodsTreeTableView));
    }


    /**
    * @Description: 查找Checked的数据
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/15
    */
    @FXML
    public void B_selected() {
        if( goodsService.selected()==0){
            super.setMessageType(P_Error,L_Error,"error");
            L_Error.setText("请至少选中一个需要删除的对象");
            return;
        }
        goodsService.showJFXTreeTableColumn();
        super.setMessageType(P_Error,L_Error,"message");
        L_Error.setText("选中的对象删除成功");
    }
    /**
    * @Description: 刷新整个界面
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/15
    */
    @FXML
    public void B_refresh(){
        System.out.println("商品管理刷新按钮按下");
        goodsTreeTableView.setRoot(null);
        goodsService.showJFXTreeTableColumn();
    }

    @FXML
    public void Open_updateView() throws IOException {
        GoodsControllerInsertUpdate.setTemp(0);
        //        设置自增长
        Manage.getGoodsControllerInsertUpdate().gid.setText(goodsService.getNewIDByLastID().toString());
        StageManage.getGoodsAddStage().show();
    }


























    /**
     * @Description: 模糊查询
     * @Param: [tableView]
     * @return: javafx.beans.value.ChangeListener<java.lang.String>
     * @Author: Ryo
     * @Date: 2020/7/15
     */
    private ChangeListener<String> setupSearchField(final JFXTreeTableView<GoodsVo> tableView) {
        return (o, oldVal, newVal) ->
                tableView.setPredicate(GoodsVo -> {
                    final GoodsVo goodsVo = GoodsVo.getValue();
                    return Double.toString(goodsVo.getMoney()).contains(newVal)
                            || goodsVo.getGaddr().contains(newVal)
                            || goodsVo.getGname().contains(newVal)
                            ||Integer.toString(goodsVo.getId()).contains(newVal)
                            || goodsVo.getMerchid().contains(newVal)
                            || Integer.toString(goodsVo.getBClass()).contains(newVal)
                            || goodsVo.getGname().contains(newVal);
                });
    }
}
