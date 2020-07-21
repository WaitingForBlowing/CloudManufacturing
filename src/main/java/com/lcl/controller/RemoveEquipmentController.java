package com.lcl.controller;

import com.lcl.dao.EquipmentDao;
import com.lcl.util.MybatisUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.ibatis.session.SqlSession;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveEquipmentController implements Initializable {

    private EquipmentDao equipmentDao;

    @FXML
    TextField equipmentName;

    public void removeEquipment(){
        try {
            SqlSession session = MybatisUtil.getSession();
            equipmentDao = session.getMapper(EquipmentDao.class);
            equipmentDao.deleteByEquipmentName(equipmentName.getText());
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
