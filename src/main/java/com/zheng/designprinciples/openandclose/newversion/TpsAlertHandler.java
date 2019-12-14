package com.zheng.designprinciples.openandclose.newversion;

import com.zheng.designprinciples.openandclose.oldversion.AlertRule;
import com.zheng.designprinciples.openandclose.oldversion.Notification;

public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if(tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()){
            //TODO Notification 执行对应的通知
        }
    }
}
