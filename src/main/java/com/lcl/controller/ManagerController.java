package com.lcl.controller;

import com.lcl.App.App;
import com.lcl.bean.Manager;

public class ManagerController {

    private App app;
    Manager manager=null;

    public void setStage(App app) {
        this.app = app;
    }

    public void init(Manager manager){
        this.manager=manager;
    }

    public void closeStage(){
        app.close();
    }
}
