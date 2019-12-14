package com.zheng.designprinciples.openandclose.newversion;

import com.zheng.designprinciples.openandclose.oldversion.AlertRule;
import com.zheng.designprinciples.openandclose.oldversion.Notification;

public class TimeoutHandler extends AlertHandler {

    public TimeoutHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long timeoutTps = apiStatInfo.getTimeoutCount() / apiStatInfo.getDurationOfSeconds();
        if(timeoutTps > rule.getMatchedRule(apiStatInfo.getApi()).getTimeoutCount()){
            //TODO 执行timeout 的通知
        }
    }
}
