package com.zheng.anemicdomainmodel.controller;

import java.math.BigDecimal;

/**
 * @author : zhengjianbin
 * @version:
 * @time : 2019/12/2 - 11:20 AM
 * @Param :
 * @function : 虚拟钱包控制器(语法层面上)
 */
public class VirtualWalletController {

    /**
     * @author : zhengjianbin
     * @version:
     * @time : 2019/12/2 - 11:23 AM
     * @Param :
     * @function : 查询余额
     */
    public BigDecimal getBalance(Long walletId){
        return null;
    }

    /**
     * @author : zhengjianbin
     * @version:
     * @time : 2019/12/2 - 11:24 AM
     * @Param :
     * @function : 出账
     */
    public void debit(Long walletId,BigDecimal amount){

    }

    /**
     * @author : zhengjianbin
     * @version:
     * @time : 2019/12/2 - 11:25 AM
     * @Param :
     * @function : 入账
     */
    public void credit(){

    }

    /**
     * @author : zhengjianbin
     * @version:
     * @time : 2019/12/2 - 11:26 AM
     * @Param :
     * @function :
     */
    public void transfer(Long walletId, Long toWalletId, BigDecimal amount){

    }

}
