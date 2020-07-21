package com.lcl.controller;

import com.lcl.bean.Factory;
import com.lcl.bean.Product;
import com.lcl.bean.ProductType;
import com.lcl.controller.temp.ProductTemp;
import com.lcl.dao.FactoryDao;
import com.lcl.dao.ProductDao;
import com.lcl.dao.ProductTypeDao;
import com.lcl.util.MybatisUtil;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminProductController implements Initializable {

    private ProductDao productDao;
    private ProductTypeDao productTypeDao;

    @FXML
    TableView<ProductTemp> productTable;
    @FXML
    TableColumn<ProductTemp, String> productName;
    @FXML
    TableColumn<ProductTemp, String> productType;
    @FXML
    TableColumn<ProductTemp, String> productInfo;
    @FXML
    TableColumn<ProductTemp, String> productSpecification;
    @FXML
    TextField searchText;

    public void refresh() {
        SqlSession session = MybatisUtil.getSession();
        productDao = session.getMapper(ProductDao.class);
        productTypeDao = session.getMapper(ProductTypeDao.class);
        ObservableList<ProductTemp> list = FXCollections.observableArrayList();

        List<Product> productList = productDao.findAll();
        for (Product product : productList) {
            ProductType productType = productTypeDao.findByTypeId(product.getPtId());
            list.add(new ProductTemp(product.getProductName(), product.getProductInfo(), product.getProductSpecification(), productType.getTypeName()));
        }


        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productInfo.setCellValueFactory(new PropertyValueFactory<>("productInfo"));
        productSpecification.setCellValueFactory(new PropertyValueFactory<>("productSpecification"));
        productType.setCellValueFactory(new PropertyValueFactory<>("productType"));

        productTable.setItems(list);

        //提交事务
        session.commit();
    }


    public void sProduct() {

    }

    public void nProduct() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/newProduct.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 340);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("新建产品");
        stage.show();
    }

    public void rProduct() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/removeProduct.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 340);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("style/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("删除产品");
        stage.show();
    }

    public void mProduct() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refresh();
    }
}
