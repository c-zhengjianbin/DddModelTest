package com.zheng.designprinciples.openandclose.oldversion;

public class Alert {

    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    /**
     * @author : zhengjianbin
     * @version:
     * @Param :
     * @function : 检查api 调用次数并发告警
     */
    public void check(String api, long requestCount,
                      long errorCount, long durationOfSeconds,
                      long timeoutCount){
        long tps = requestCount / durationOfSeconds;
        if(tps > rule.getMatchedRule(api).getMaxTps()){
            //TODO 执行maxTps 的通知
        }
        if(errorCount > rule.getMatchedRule(api).getErrorCount()){
            //TODO 执行error 的通知
        }
        //现在加入一个新功能：当每秒接口超时请求个数，超过某个预先设置的最大阈值时，添加警告
        //要实现此功能，需要几个步骤：
        // 1.check() 方法加一个timeoutCount
        // 2.在check() 方法中添加超时逻辑
        long timeoutTps = timeoutCount / durationOfSeconds;
        if(timeoutTps > rule.getMatchedRule(api).getTimeoutCount()){
            //TODO 执行timeout 的通知
        }
        //问题1. 这种形式的功能添加会导致什么问题？
        //回答：1.接口入参进行了修改，意味着调用check() 的方法全部需要修改。
        //回答：2.修改了 check() 函数，相应的单元测试都需要修改。
        //上面功能的实现是基于"修改" 的方式来完成新功能的实现。如果遵循开闭原则，
        //也就是"对扩展开放，对修改关闭"。
        //那如何借助扩展实现新功能的拆分呢？
        //1.将参数进行封装
        //2.引入handler概念，将if 判断逻辑分散在各个handler 中
    }
}
