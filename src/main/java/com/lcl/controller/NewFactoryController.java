package com.lcl.controller;

import com.lcl.bean.Consignee;
import com.lcl.bean.Factory;
import com.lcl.bean.Manager;
import com.lcl.dao.ConsigneeDao;
import com.lcl.dao.FactoryDao;
import com.lcl.dao.ManagerDao;
import com.lcl.util.MybatisUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewFactoryController implements Initializable {

    private ManagerDao managerDao;
    private FactoryDao factoryDao;

    @FXML
    TextField name,adminName;
    @FXML
    TextArea info;

    public void newFactory() {
        SqlSession session = MybatisUtil.getSession();
        managerDao = session.getMapper(ManagerDao.class);
        factoryDao = session.getMapper(FactoryDao.class);

        List<Manager> managerList = managerDao.findByInfo(adminName.getText());
        if (managerList.size() == 1) {
            Manager manager = managerList.get(0);
            factoryDao.insert(new Factory(manager.getUserId(), name.getText(), info.getText(), "正常"));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("添加成功");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("负责人姓名错误或未注册");
            alert.show();
        }

        //提交事务
        session.commit();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
