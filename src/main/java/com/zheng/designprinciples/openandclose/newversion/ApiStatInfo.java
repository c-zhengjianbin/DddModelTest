package com.zheng.designprinciples.openandclose.newversion;

import lombok.Data;

@Data
public class ApiStatInfo {

    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
    //新增功能
    private long timeoutCount;
}
