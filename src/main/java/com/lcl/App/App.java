package com.lcl.App;

import com.lcl.bean.Administrator;
import com.lcl.bean.Consignee;
import com.lcl.bean.Manager;
import com.lcl.controller.AdministratorController;
import com.lcl.controller.ConsigneeController;
import com.lcl.controller.LoginController;
import com.lcl.controller.ManagerController;
import com.lcl.util.MybatisUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class App extends Application {

    public Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage=primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/loginMain.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();
        controller.setStage(this);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setX(50);
        primaryStage.setY(0);
        Scene scene = new Scene(root, 1200, 680);
        JMetro jMetro=new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void goToAdministrator(Administrator administrator) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/administrator.fxml"));
        Parent root = loader.load();
        AdministratorController controller = loader.getController();
        controller.init(administrator);
        controller.setStage(this);
        mainStage.setX(50);
        mainStage.setY(0);
        Scene scene=new Scene(root,1200,680);
        mainStage.setScene(scene);
        JMetro jMetro=new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style/style.css").toExternalForm());
        mainStage.show();
    }

    public void goToManager(Manager manager) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/manager.fxml"));
        Parent root = loader.load();
        ManagerController managerController = loader.getController();
        managerController.init(manager);
        managerController.setStage(this);
        mainStage.setX(50);
        mainStage.setY(0);
        Scene scene=new Scene(root,1200,680);
        mainStage.setScene(scene);
        JMetro jMetro=new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style/style.css").toExternalForm());
        mainStage.show();
    }

    public void goToConsignee(Consignee consignee) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/consignee.fxml"));
        Parent root = loader.load();
        ConsigneeController consigneeController = loader.getController();
        consigneeController.init(consignee);
        consigneeController.setStage(this);
        mainStage.setX(50);
        mainStage.setY(0);
        Scene scene=new Scene(root,1200,680);
        mainStage.setScene(scene);
        JMetro jMetro=new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style/style.css").toExternalForm());
        mainStage.show();
    }

    public void close(){
        mainStage.close();
    }

    public static void main(String[] args) {
        launch(args);
        MybatisUtil.close();
    }
}
