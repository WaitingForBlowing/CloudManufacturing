package com.lcl.controller;

import com.lcl.dao.ConsigneeDao;
import com.lcl.dao.ManagerDao;
import com.lcl.util.MybatisUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveUserController implements Initializable {

    private ManagerDao managerDao;
    private ConsigneeDao consigneeDao;

    @FXML
    TextField account;

    public void removeUser() {
        SqlSession session = MybatisUtil.getSession();
        managerDao = session.getMapper(ManagerDao.class);
        consigneeDao = session.getMapper(ConsigneeDao.class);

        managerDao.deleteByAccount(account.getText());
        consigneeDao.deleteByAccount(account.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("删除成功");
        alert.show();

        //提交事务
        session.commit();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
