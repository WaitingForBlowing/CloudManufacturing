package com.lcl.controller;

import com.lcl.bean.Factory;
import com.lcl.bean.Manager;
import com.lcl.bean.Product;
import com.lcl.bean.ProductType;
import com.lcl.dao.FactoryDao;
import com.lcl.dao.ManagerDao;
import com.lcl.dao.ProductDao;
import com.lcl.dao.ProductTypeDao;
import com.lcl.util.MybatisUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.ibatis.session.SqlSession;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewProductController implements Initializable {

    private ProductDao productDao;
    private ProductTypeDao productTypeDao;

    @FXML
    TextField productName,productSpecification,productTypeName;
    @FXML
    TextArea productInfo;

    public void newFactory() {
        SqlSession session = MybatisUtil.getSession();
        productDao = session.getMapper(ProductDao.class);
        productTypeDao = session.getMapper(ProductTypeDao.class);

        List<ProductType> productTypeList = productTypeDao.findByTypeName(productTypeName.getText());

        if (productTypeList.size()==1){
            int ptId=productTypeList.get(0).getTypeId();
            productDao.insert(new Product(ptId,productName.getText(),productInfo.getText(),productSpecification.getText()));
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("添加成功");
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("产品类别设置错误");
            alert.show();
        }

        //提交事务
        session.commit();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
