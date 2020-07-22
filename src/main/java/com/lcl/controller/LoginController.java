package com.lcl.controller;

import com.lcl.App.App;
import com.lcl.bean.Administrator;
import com.lcl.bean.Consignee;
import com.lcl.bean.Manager;
import com.lcl.dao.AdministratorDao;
import com.lcl.dao.ConsigneeDao;
import com.lcl.dao.ManagerDao;
import com.lcl.util.MybatisUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private App app;
    private AdministratorDao administratorDao;
    private ConsigneeDao consigneeDao;
    private ManagerDao managerDao;
    ObservableList<Node> children;

    @FXML
    AnchorPane loginContain,loginPanel;
    @FXML
    Button close, submit;
    @FXML
    TextField account;
    @FXML
    PasswordField password;

    public void setStage(App app) {
        children= loginPanel.getChildren();
        this.app = app;
    }

    public void closeStage() {
        app.close();
    }

    public void login() throws IOException {
        SqlSession session = MybatisUtil.getSession();
        administratorDao = session.getMapper(AdministratorDao.class);
        managerDao = session.getMapper(ManagerDao.class);
        consigneeDao = session.getMapper(ConsigneeDao.class);

        Administrator administrator = administratorDao.login(account.getText(), password.getText());
        Manager manager = managerDao.login(account.getText(), password.getText());
        Consignee consignee = consigneeDao.login(account.getText(), password.getText());

        if(administrator!=null){
            app.goToAdministrator(administrator);
        }else if(manager!=null){
            app.goToManager(manager);
        }else if(consignee!=null){
            app.goToConsignee(consignee);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("账号或密码错误");
            alert.show();
        }

        //提交事务
        session.commit();

    }

    public void findPassword(){
            }

    public void signUp(){

    }

    public void back() throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
