package com.lcl.controller;


import com.lcl.dao.FactoryDao;
import com.lcl.util.MybatisUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.ibatis.session.SqlSession;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveFactoryController implements Initializable {

    private FactoryDao factoryDao;

    @FXML
    TextField factoryName;

    public void removeUser() {

        try {
            SqlSession session = MybatisUtil.getSession();
            factoryDao = session.getMapper(FactoryDao.class);
            factoryDao.deleteByFactoryName(factoryName.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("删除成功");
            alert.show();

            //提交事务
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("删除失败");
            alert.show();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
