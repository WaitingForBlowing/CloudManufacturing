package com.lcl.controller;

import com.lcl.bean.Equipment;
import com.lcl.bean.Factory;
import com.lcl.bean.Manager;
import com.lcl.controller.temp.EquipmentTemp;
import com.lcl.dao.EquipmentDao;
import com.lcl.dao.EquipmentTypeDao;
import com.lcl.dao.FactoryDao;
import com.lcl.util.MybatisUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.ibatis.session.SqlSession;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OnCloseController implements Initializable {

    private Manager manager;
    private EquipmentDao equipmentDao;
    private FactoryDao factoryDao;

    @FXML
    TextField equipmentName;

    public void init(Manager manager){
        this.manager=manager;
    }

    public void onCloseEquipment(){
        try {
            SqlSession session = MybatisUtil.getSession();
            equipmentDao = session.getMapper(EquipmentDao.class);
            factoryDao = session.getMapper(FactoryDao.class);
            List<Equipment> equipmentList=new ArrayList<>();

            List<Factory> factoryList = factoryDao.findByUid(manager.getUserId());
            for(Factory factory:factoryList){
                List<Equipment> eList = equipmentDao.findByFid(factory.getFactoryId());
                equipmentList.addAll(eList);
            }
            boolean flag=false;
            for(Equipment equipment:equipmentList){
                if(equipment.getEquipmentName().equals(equipmentName.getText())&&
                   equipment.getEquipmentStatus().equals("闲置")){
                    flag=true;
                    equipment.setEquipmentStatus("关机");
                    equipmentDao.update(equipment);
                    session.commit();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("关机成功");
                    alert.show();
                    break;
                }else if(equipment.getEquipmentName().equals(equipmentName.getText())&&
                        equipment.getEquipmentStatus().equals("关机")){
                    flag=true;
                    equipment.setEquipmentStatus("闲置");
                    equipmentDao.update(equipment);
                    session.commit();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("开机成功");
                    alert.show();
                    break;
                }
            }
            if(!flag){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("此机器不存在或正在运行订单，操作失败");
                alert.show();
            }

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
