package com.zheng.designprinciples.openandclose.oldversion;

/**
 * @author : zhengjianbin
 * @version:
 * @Param :
 * @function : 存储告警规则
 */
public class AlertRule {


    public AlertRule getMatchedRule(String api){
        return new AlertRule();
    }

    public long getMaxTps(){
        return 0L;
    }

    public long getErrorCount(){
        return 0L;
    }

    public long getTimeoutCount(){
        return 0L;
    }
}
