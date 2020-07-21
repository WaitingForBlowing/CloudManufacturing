package com.lcl.controller;

import com.lcl.bean.Factory;
import com.lcl.bean.Manager;
import com.lcl.bean.ProductType;
import com.lcl.dao.FactoryDao;
import com.lcl.dao.ManagerDao;
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

public class NewProductTypeController implements Initializable {

    private ProductTypeDao productTypeDao;

    @FXML
    TextField typeName;

    public void newType() {
        SqlSession session = MybatisUtil.getSession();
        productTypeDao=session.getMapper(ProductTypeDao.class);

        try {
            productTypeDao.insert(new ProductType(typeName.getText()));
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("添加成功");
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("新增失败");
            alert.show();
        }


        //提交事务
        session.commit();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
