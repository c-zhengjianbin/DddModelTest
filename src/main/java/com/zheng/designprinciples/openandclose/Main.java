package com.zheng.designprinciples.openandclose;

import com.zheng.designprinciples.openandclose.newversion.ApiStatInfo;
import com.zheng.designprinciples.openandclose.newversion.ApplicationContext;

public class Main {

    public static void main(String[] args){
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        apiStatInfo.setTimeoutCount(100);
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }

}
