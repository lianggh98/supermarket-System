package view.util;

import com.Bean.Buy.Supplier;
import com.Bean.Goods.Goods;
import com.Bean.Inventory.Warehouse;
import com.Bean.Persons.Persons;
import com.dao.goodsMapper;
import com.dao.personsMapper;
import com.dao.buyMapper;
import com.dao.stockMapper;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.spring.BaseHolder;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/6/2 19:59
 * @Version 1.0
 **/
@Service("ViewAssistImpl")
public class ViewAssistImpl {
    /**
    * @Description: 设置动画
    * @Param: [pane]
    * @return: javafx.animation.TranslateTransition
    * @Author: Ryo
    * @Date: 2020/6/3
    */
    public TranslateTransition getAnimation(Pane pane){
        //设置动画
        TranslateTransition  translate = new TranslateTransition();
        translate.setFromX(0);//设置启动位置
        translate.setToX(10);//设置到达位置
        translate.setDuration(Duration.millis(800));//移动时间
        translate.setAutoReverse(true);//设置反向移动
        translate.setCycleCount(Animation.INDEFINITE);
        translate.setNode(pane);
        return translate;
    }
    /**
    * @Description: 获取Stage
    * @Param: [w, h, title, fxmlUrl, imgUrl, cssUrl]
     *    窗体宽度 高度 标题  fxml地址  标题图片地址  Css地址
    * @return: javafx.stage.Stage
    * @Author: Ryo
    * @Date: 2020/6/4
    */
    public Stage getStage(double w,double h,String title,String fxmlUrl,String imgUrl,String cssUrl ) throws IOException {
        // 创建新的stage
        Stage  secondStage = new Stage();
        //设置标题抬头和图标
        secondStage.setTitle(title);
        secondStage.getIcons().add(new Image(imgUrl));
        //读取Fxml文件
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(fxmlUrl));
        //创建Scene
        Scene scene = new Scene(root, w, h);//显示大小
        //设置窗体
        secondStage.setScene(scene);
        //设置Css文件
        scene.getStylesheets().add(String.valueOf(getClass().getResource(cssUrl)));
//        //设置传窗口不能自由扩展
//        secondStage.setResizable(false);
        return secondStage;
    }

    public Stage getNO_Title_Stage(double w,double h,String title,String fxmlUrl,String imgUrl,String cssUrl ) throws IOException {
        // 创建新的stage
        Stage  secondStage = new Stage();
        //设置标题抬头和图标
        secondStage.setTitle("");
//        創建標題文件
        secondStage.getIcons().add(new Image(imgUrl));
        //读取Fxml文件
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(fxmlUrl));
        //创建Scene
        Scene scene = new Scene(root, w, h);//显示大小
        //设置窗体
        secondStage.setScene(scene);
        if(cssUrl!=null)
        //设置Css文件
        scene.getStylesheets().add(String.valueOf(getClass().getResource(cssUrl)));
//        设置传窗口不能自由扩展
        secondStage.setResizable(false);
//        關閉窗口的標題欄
        secondStage.initStyle(StageStyle.UNDECORATED);
        return secondStage;
    }
    private static Stage menuStage ;
    public Stage getStage(String string) throws IOException {
        switch (string){
            case "menu":
                menuStage = getStage(1000,750,"超市管理系统 V1.0", "/Fxml/index/menu.fxml","/images/003.png/","/Css/menu.css");
                return menuStage;
        }
        return null;
    }
    /**
    * @Description: 判断Text是否有空值
    * @Param: [textFields]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/7
    */
   public List<String> TextisNull(TextField...textFields){
       List<String> list = new ArrayList<String>();
       for(int i=0; i<textFields.length;i++)
           if (textFields[i].getText().equals("")){
               System.out.println(textFields[i]+"为空");
                return null;
           }else {
                list.add(textFields[i].getText());
           }return list;
    }
    /**
    * @Description: 弹出一个Error框
    * @Param: [string]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/7
    */
    public void alertError(String string){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(string);
        alert.showAndWait();
    }
    /**
    * @Description: 从时间选择器获取时间转换成 Timestamp
    * @Param: [datePicker]
    * @return: java.sql.Timestamp
    * @Author: Ryo
    * @Date: 2020/6/7
    */
    public Timestamp getDatePicker(DatePicker datePicker){


              try {

                  //先获取本地时间日期
                  Timestamp t = Timestamp.valueOf(datePicker.getValue()+" 00:00:00");
                  return t;
              } catch (Exception e) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Error");
                  alert.setContentText("请填写入职时间");
                  alert.showAndWait();
                  new Exception("没有选中时间");
              }



     return null;
    }
    /**
    * @Description: 清除TextField输入框内的信息
    * @Param: [textFields]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/23
    */
    public void clearText(TextField...textFields){
        for(int i=0;i<textFields.length;i++)
            textFields[i].clear();
    }
    /**
    * @Description: 获取TextFiled的值
    * @Param: []
    * @return: java.util.List<java.lang.String>
    * @Author: Ryo
    * @Date: 2020/6/7
    */
    public List<String> getText(TextField...textFields){
        List<String> list = new ArrayList<String>();
        for(int i=0; i<textFields.length;i++)
            if (!textFields[i].getText().equals("")){
                list.add(textFields[i].getText());
            }
        return list;
    }
    /**
    * @Description: 获取ChoiceBox选中的值
    * @Param: [choiceBoxes]
    * @return: java.util.List<java.lang.String>
    * @Author: Ryo
    * @Date: 2020/6/7
    */
    public List<String> getChoiceBox(ChoiceBox<String>...choiceBoxes){
        List<String> list = new ArrayList<String>();
        for (int  i = 0 ; i<choiceBoxes.length;i++)
            if (!choiceBoxes[i].getValue().equals(" ")){
                    list.add(choiceBoxes[i].getValue());
            }

            return list;
    }
    /**
    * @Description: 设置ChoiceBox默认选中第一个
    * @Param: [choiceBoxes]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/7
    */
    public void setdefaultSpace(ChoiceBox<String>...choiceBoxes){
        for (int i=0;i<choiceBoxes.length;i++)
            choiceBoxes[i].getSelectionModel().select(0);

    }
    
    /**
    * @Description: 设置时间为当前系统时间
    * @Param: [datePicker, now]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/17
    */
    public void setSystemTime(JFXDatePicker datePicker, JFXTimePicker now){
        //获取当前日期
        LocalDate today = LocalDate.now();
        datePicker.setValue(today);
        //获取当前时间
        LocalTime now1 = LocalTime.now().withNano(0);
        now.setValue(now1);


    }
    /**
    * @Description: 获取当前JFX控件的时间时间
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/17
    */
    public Timestamp getTime(JFXDatePicker datePicker, JFXTimePicker now){
        if(datePicker.getValue()==null||now.getValue()==null)
        return null;
        else {
            LocalDate today = datePicker.getValue();
            LocalTime time =now.getValue();
            DateTimeFormatter f5 = DateTimeFormatter.ofPattern("HH:mm");
            String str = time.format(f5);
            Timestamp t = Timestamp.valueOf(today+" "+str+":00");
            return t;
        }
    }
    /**
    * @Description: 判断是否为数字 检测小数点
    * @Param: [str]
    * @return: java.lang.Boolean
    * @Author: Ryo
    * @Date: 2020/6/19
    */
    public Boolean isnumber(String str){
        Pattern pt=Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
        Matcher mt=pt.matcher(str);
        if(mt.matches())
            return true;
        else
            return false;
    }

    /**
     * @Description: 弹出一个信息框
     * @Param: []
     * @return:
     * @Author: Ryo
     * @Date: 2020/6/19
     */
    public void alert_message(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示对话框");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
    * @Description: 设置Hashmap  传入值名称
    * @Param: [strings]
    * @return: java.util.List<java.lang.String>
    * @Author: Ryo
    * @Date: 2020/6/23
    */
    public List<String>setTempname(String...strings){
        List<String>tempname = new ArrayList<>();
        for(int i=0;i<strings.length;i++)
            tempname.add(strings[i]);
        return tempname;
    }
    /**
    * @Description:获取输入框的值绑定Haspmap
    * @Param: [strings,传入值名称 textFields 输入框]
    * @return: java.util.HashMap<java.lang.String,java.lang.String>
    * @Author: Ryo
    * @Date: 2020/6/23
    */
    public HashMap<String,String> getStrHashMapBytextFields(List<String>strings,TextField...textFields){

        if(strings.size()!=textFields.length) {
            System.out.println("传入的String名称长度 与  textFields 长度不符合");
            return null;
        }
        HashMap strmap = new HashMap<String,String>();
        for(int i=0;i<strings.size();i++){
            strmap.put(strings.get(i),textFields[i].getText());
        }
            return strmap;
    }

    /**
    * @Description: 从商品id获取商品名称
    * @Param: [id, gname]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/5
    */
    public void autoSelectedGid(String id,TextField gname) {
        goodsMapper mapper = BaseHolder.getApplicationContext().getBean("goodsMapper",goodsMapper.class);
        Integer gid  = Integer.valueOf(id);
        Goods goods =  mapper.findGoodNameById(gid);

        if(goods==null){
            gname.setText("该id下没有任何商品信息");
            gname.setStyle("-fx-border-width: 1px;-fx-border-style: solid;-fx-border-color: #ff0000");
        }
        else {
            gname.setText(goods.getGname());
            gname.setStyle("");
        }
    }

    /**
    * @Description: 根据人员id查询对应的人员信息
    * @Param: [id, pname]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/5
    */
    public void autoSelectedPid(String id,TextField pname) {
        personsMapper personsMapper = BaseHolder.getApplicationContext().getBean("personsMapper",personsMapper.class);
        Integer gid  = Integer.valueOf(id);
        Persons persons =  personsMapper.findPersonsByIds(gid);
        if(persons==null){
            pname.setText("该id下没有对应的人员信息");
            pname.setStyle("-fx-border-width: 1px;-fx-border-style: solid;-fx-border-color: #ff0000");
        }
        else {
            pname.setText(persons.getPname());
            pname.setStyle("");
        }
    }
    /**
    * @Description: 根据进货商id获取进货商信息
    * @Param: [id, pname]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/17
    */
    public void autoSelectedSupplier(String id,Label pname){
        buyMapper buyMapper = BaseHolder.getApplicationContext().getBean("buyMapper",buyMapper.class);
        Integer supplierId  = Integer.valueOf(id);
        Supplier supplier =  buyMapper.findSupplierNameByid(supplierId);
        if(supplier==null){
            pname.setText("该id下没有此供应商");
            pname.setStyle("-fx-border-width: 1px;-fx-border-style: solid;-fx-border-color: #ff0000");
        }
        else {
            pname.setText(supplier.getName());
            pname.setStyle("");
        }
    }

    /**
    * @Description: 设置Message 类型
    * @Param: [hBox, label, type]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/18
    */
    public void setMessageType(HBox hBox,Label label,String type){
        hBox.setVisible(true);
        switch (type){
            case "error":
                hBox.setStyle("-fx-background-color: #F8D7DA;");
                label.setStyle("-fx-text-fill: #721c24;");
                break;
            case "message":
                hBox.setStyle("-fx-background-color: #177cb0;");
                label.setStyle("-fx-text-fill: #f3f9f1;");
                break;
        }
    }

    /**
     * @Description: 提取字符串里面的数字
     * @Param: [str]
     * @return: java.lang.Integer
     * @Author: Ryo
     * @Date: 2020/6/7
     */
    public Integer fromStringGetInteger(String str) {
        str =  str.replaceAll("\\D+","");//提取里面的数字
//        System.out.println(Integer.valueOf(str));
        return Integer.valueOf(str);
    }

    public void autoSelectedWid(String id,TextField textField){
        stockMapper mapper = BaseHolder.getApplicationContext().getBean("stockMapper", stockMapper.class);
        Integer wid  = Integer.valueOf(id);
        Warehouse warehouse =  mapper.findWarehouseById(wid);
        if(warehouse==null){
            textField.setText("该编号下不存在此仓库");
            textField.setStyle("-fx-border-width: 1px;-fx-border-style: solid;-fx-border-color: #ff0000");
        }
        else {
            textField.setText(warehouse.getWname());
            textField.setStyle("");
        }
    }


    /**
    * @Description: 星期一到星期天的日期
    * @Param: []
    * @return: java.util.Map<java.lang.String,java.lang.String>
    * @Author: Ryo
    * @Date: 2020/7/19
    */
    public List<String> get_Moday_Sunday(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            dates.add(dateFormat.format(calendar.getTime())) ;
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }

    /**
    * @Description:
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/19
    */
    public  Map<String,String> get_00_23(){
        Map<String,String> map = new HashMap<>();
        LocalDate localDate = LocalDate.now();
        String today = localDate.toString();
        String startTime = today+" 00:00:00";
        String endTime = today+" 23:59:00";

        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return  map;
    }


}
