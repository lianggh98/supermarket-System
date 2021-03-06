package view.controller.stock;


import com.beanvo.StockVo;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import view.util.Manage;
import view.util.ViewAssistImpl;

import java.net.URL;
import java.util.ResourceBundle;

import static com.spring.BeanManage.stockService;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/12 17:29
 * @Version 1.0
 **/
public class StockController extends ViewAssistImpl implements Initializable {



    @FXML public JFXTreeTableView<StockVo>  stockTreeTableView;
    @FXML private JFXTextField stockSearchField;
    @FXML public JFXTreeTableColumn<StockVo,Boolean> selected;
    @FXML public JFXTreeTableColumn<StockVo,Integer> stockid,inid,gid;
    @FXML public JFXTreeTableColumn<StockVo,String> gname,quantity,produced,expiration,wname,update;


    @FXML
    HBox P_stock_Error;
    @FXML
    Label  L_stock_Error;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Manage.setStockController_(this);
            stock_Error_hide();
        stockService.setJFXTreeTableColumn();
        stockService.showJFXTreeTableColumn();
        stockSearchField.textProperty().addListener(stockSetupSearchField(stockTreeTableView));
    }


    //    模糊查询信息
    private ChangeListener<String> stockSetupSearchField(final JFXTreeTableView<StockVo> tableView) {
        return (o, oldVal, newVal) ->
                tableView.setPredicate(intableVoTreeItem -> {
                    final StockVo StockVo = intableVoTreeItem.getValue();
                    return
                            StockVo.getGid().toString().contains(newVal)
                            ||StockVo.getInid().toString().contains(newVal)
                                    ||StockVo.getGid().toString().contains(newVal)
                                    ||StockVo.getProduced().toString().contains(newVal)
                                    ||StockVo.getWname().contains(newVal)
                                    ||StockVo.getQuantity().contains(newVal)
                                    ||StockVo.getExpiration().contains(newVal);

                });
    }

    @FXML
    public void B_StockRefresh(){
        Platform.runLater(()->{
            //        仓库管理刷新按钮按下
            stockService.showJFXTreeTableColumn();
        });
    }



    @FXML
    public void B_stock_remove(){
        if(stockService.removeSelected()==0){
            super.setMessageType(P_stock_Error,L_stock_Error,"error");
            L_stock_Error.setText("至少选中一个需要删除的对象");
        }else{
            super.setMessageType(P_stock_Error,L_stock_Error,"message");
            L_stock_Error.setText("删除成功");
            B_StockRefresh();
        }
    }

    @FXML
    public void stock_Error_hide(){
        P_stock_Error.setVisible(false);
    }

}
