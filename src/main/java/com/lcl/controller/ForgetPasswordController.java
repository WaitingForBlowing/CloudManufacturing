package com.lcl.controller;

import com.lcl.bean.Consignee;
import com.lcl.bean.Manager;
import com.lcl.dao.ConsigneeDao;
import com.lcl.dao.ManagerDao;
import com.lcl.util.EmailUtil;
import com.lcl.util.MybatisUtil;
import com.lcl.util.RandomUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.ibatis.session.SqlSession;

import javax.mail.MessagingException;
import java.util.List;
import java.util.zip.DataFormatException;

public class ForgetPasswordController {

    private Manager manager;
    private Consignee consignee;

    private ManagerDao managerDao;
    private ConsigneeDao consigneeDao;
    private final int REAL_CODE= RandomUtil.random(1000,9999);

    @FXML
    TextField account,email,code;

    public void findPassword(){
        if(code.getText().equals(String.valueOf(REAL_CODE))){
            if(manager!=null){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("您的密码是："+manager.getPassword());
                alert.show();
            }else if(consignee!=null){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("您的密码是："+consignee.getPassword());
                alert.show();
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("验证码错误");
            alert.show();
        }
    }

    public void send() throws DataFormatException, MessagingException {
        SqlSession session = MybatisUtil.getSession();
        managerDao=session.getMapper(ManagerDao.class);
        consigneeDao=session.getMapper(ConsigneeDao.class);

        List<Manager> managerList = managerDao.findByInfo(account.getText());
        List<Consignee> consigneeList = consigneeDao.findByInfo(account.getText());

        if(managerList.size()==1){
            manager=managerList.get(0);
            if(email.getText().equals(managerList.get(0).getEmail())){
                EmailUtil.send(email.getText(),"智能工厂云工厂提醒您不要将此验证码告诉他人\n"+"验证码："+REAL_CODE);
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("邮箱错误");
                alert.show();
            }
        }else if(consigneeList.size()==1){
            consignee=consigneeList.get(0);
            if(email.getText().equals(managerList.get(0).getEmail())){
                EmailUtil.send(email.getText(),"智能工厂云工厂提醒您不要将此验证码告诉他人\n"+"验证码："+REAL_CODE);
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("邮箱错误");
                alert.show();
            }
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("账号不存在");
            alert.show();
        }
    }
}
