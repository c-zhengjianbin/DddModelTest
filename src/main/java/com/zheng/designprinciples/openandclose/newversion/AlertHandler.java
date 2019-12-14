package com.zheng.designprinciples.openandclose.newversion;

import com.zheng.designprinciples.openandclose.oldversion.AlertRule;
import com.zheng.designprinciples.openandclose.oldversion.Notification;

public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
