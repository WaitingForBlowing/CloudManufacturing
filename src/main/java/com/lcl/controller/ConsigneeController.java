package com.lcl.controller;

import com.lcl.App.App;
import com.lcl.bean.Consignee;
import com.lcl.controller.ConsigneeOrderController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConsigneeController {

    private App app;
    Consignee consignee=null;

    @FXML
    AnchorPane table;
    @FXML
    Label info;

    public void setStage(App app) {
        this.app = app;
    }

    public void init(Consignee consignee){
        this.consignee=consignee;
        info.setText("你好，"+consignee.getName());
    }

    public void adminOrderConsignee() throws IOException {
        table.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/consigneeOrder.fxml"));
        Parent root = loader.load();
        ConsigneeOrderController controller = loader.getController();
        controller.init(consignee);
        table.getChildren().add(root);
    }

    public void closeStage(){
        app.close();
    }
}
