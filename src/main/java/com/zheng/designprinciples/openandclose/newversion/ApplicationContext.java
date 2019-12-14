package com.zheng.designprinciples.openandclose.newversion;

import com.zheng.designprinciples.openandclose.newversion.Alert;
import com.zheng.designprinciples.openandclose.oldversion.AlertRule;
import com.zheng.designprinciples.openandclose.oldversion.Notification;

public class ApplicationContext {

    private AlertRule rule;
    private Notification notification;
    private Alert alert;
    private static final ApplicationContext instance = new ApplicationContext();

    public void initalizeBeans(){
        rule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new ErrorAlertHandler(rule, notification));
        alert.addAlertHandler(new TpsAlertHandler(rule, notification));
        alert.addAlertHandler(new TimeoutHandler(rule, notification));
    }

    public Alert getAlert() {
        return alert;
    }

    private ApplicationContext(){
        instance.initalizeBeans();
    }

    public static ApplicationContext getInstance(){
        return instance;
    }

}
