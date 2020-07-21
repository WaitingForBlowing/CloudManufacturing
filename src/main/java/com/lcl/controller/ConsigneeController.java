package com.lcl.controller;

import com.lcl.App.App;
import com.lcl.bean.Consignee;

public class ConsigneeController {
    private App app;
    Consignee consignee=null;

    public void setStage(App app) {
        this.app = app;
    }

    public void init(Consignee consignee){
        this.consignee=consignee;
    }

    public void closeStage(){
        app.close();
    }
}
