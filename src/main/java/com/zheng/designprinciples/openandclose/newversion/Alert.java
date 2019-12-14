package com.zheng.designprinciples.openandclose.newversion;

import java.util.ArrayList;
import java.util.List;

public class Alert {

    private List<AlertHandler> alertHandlerList = new ArrayList();

    public void addAlertHandler(AlertHandler alertHandler){
        alertHandlerList.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo){
        for(AlertHandler alertHandler : alertHandlerList){
            alertHandler.check(apiStatInfo);
        }
    }

}
