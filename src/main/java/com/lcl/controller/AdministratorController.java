package com.lcl.controller;

import com.lcl.App.App;
import com.lcl.bean.Administrator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

    private App app;
    Administrator administrator=null;

    @FXML
    AnchorPane table;


    public void setStage(App app) {
        this.app = app;
    }

    public void init(Administrator administrator){
        this.administrator=administrator;
    }

    public void closeStage(){
        app.close();
    }

    public void userAdmin() throws IOException {
        table.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/adminUser.fxml"));
        Parent root = loader.load();
        table.getChildren().add(root);
    }

    public void factoryAdmin() throws IOException {
        table.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/adminFactory.fxml"));
        Parent root = loader.load();
        table.getChildren().add(root);
    }

    public void productTypeAdmin() throws IOException {
        table.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/adminProductType.fxml"));
        Parent root = loader.load();
        table.getChildren().add(root);
    }

    public void productAdmin() throws IOException {
        table.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/adminProduct.fxml"));
        Parent root = loader.load();
        table.getChildren().add(root);
    }

    public void equipmentAdmin(){
        System.out.println("equipmentAdmin");
    }

    public void equipmentTypeAdmin(){
        System.out.println("equipmentTypeAdmin");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
