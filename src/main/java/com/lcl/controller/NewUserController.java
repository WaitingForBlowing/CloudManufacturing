package com.lcl.controller;

import com.lcl.bean.Consignee;
import com.lcl.bean.Manager;
import com.lcl.bean.User;
import com.lcl.dao.ConsigneeDao;
import com.lcl.dao.ManagerDao;
import com.lcl.util.MybatisUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewUserController implements Initializable {

    private ManagerDao managerDao;
    private ConsigneeDao consigneeDao;

    @FXML
    TextField name, account, password, email, tel;
    @FXML
    ToggleButton factoryAdmin, consignee;

    public void newUser() {
        SqlSession session = MybatisUtil.getSession();
        managerDao = session.getMapper(ManagerDao.class);
        consigneeDao = session.getMapper(ConsigneeDao.class);

        if (factoryAdmin.isSelected()) {
            managerDao.insert(new Manager(account.getText(), password.getText(), name.getText(), email.getText(), tel.getText(), "工厂管理员"));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("添加成功");
            alert.show();
        } else if (consignee.isSelected()) {
            consigneeDao.insert(new Consignee(account.getText(), password.getText(), name.getText(), email.getText(), tel.getText(), "经销商", " "));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("添加成功");
            alert.show();
        }

        //提交事务
        session.commit();

}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
