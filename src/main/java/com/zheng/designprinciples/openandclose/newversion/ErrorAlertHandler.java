package com.zheng.designprinciples.openandclose.newversion;

import com.zheng.designprinciples.openandclose.oldversion.AlertRule;
import com.zheng.designprinciples.openandclose.oldversion.Notification;
import javafx.scene.control.Alert;

public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if(apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getErrorCount()){
            //借助Notification 执行对应的通知
        }
    }
}
