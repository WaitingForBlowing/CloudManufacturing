package com.lcl.controller;

import com.lcl.bean.Consignee;
import com.lcl.bean.Order;
import com.lcl.bean.Product;
import com.lcl.dao.OrderDao;
import com.lcl.dao.ProductDao;
import com.lcl.util.MybatisUtil;
import com.lcl.util.TimeUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.apache.ibatis.session.SqlSession;

import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

public class NewOrderController implements Initializable {

    private Consignee consignee;

    private OrderDao orderDao;
    private ProductDao productDao;

    @FXML
    TextField productName,productAmount;
    @FXML
    DatePicker accomplishDeadline,tenderDeadline;
    @FXML
    RadioButton publishTrue,publishFalse;

    public void init(Consignee consignee){
        this.consignee=consignee;
    }

    public void newOrder() throws ParseException {
        SqlSession session = MybatisUtil.getSession();
        orderDao=session.getMapper(OrderDao.class);
        productDao=session.getMapper(ProductDao.class);

        Product product = productDao.findByProductName(productName.getText());

        if(product!=null){
            String accomplishTime = accomplishDeadline.getValue().toString();
            String tenderTime=tenderDeadline.getValue().toString();
            String amount=productAmount.getText();

            orderDao.insert(new Order(product.getProductId(),Integer.parseInt(amount), TimeUtil.getDate(accomplishTime),
                    TimeUtil.getDate(tenderTime),consignee.getUserId(),publishTrue.isSelected()?"已发布":"未发布"));

            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("新建成功");
            alert.show();
        }else{
            Alert alert =new Alert(Alert.AlertType.ERROR);
            List<Product> productList = productDao.findAll();
            alert.setContentText("产品不存在，请先检查。\n可选产品如下:"+productList.toString());
            alert.show();
        }

        //提交事务
        session.commit();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
