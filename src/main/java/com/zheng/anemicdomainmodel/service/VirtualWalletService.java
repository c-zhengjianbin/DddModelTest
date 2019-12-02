package com.zheng.anemicdomainmodel.service;

import com.zheng.anemicdomainmodel.dto.VirtualWalletBo;
import com.zheng.anemicdomainmodel.entity.VirtualWalletEntity;
import com.zheng.anemicdomainmodel.entity.VirtualWalletTransactionEntity;
import com.zheng.anemicdomainmodel.repository.VirtualWalletRepository;
import com.zheng.anemicdomainmodel.repository.VirtualWalletTransactionRepository;

import java.math.BigDecimal;

/**
 * Created by zhengjianbin on 2019/12/2.
 */
public class VirtualWalletService {
        // 通过构造函数或者IOC框架注入
        private VirtualWalletRepository walletRepo;
        private VirtualWalletTransactionRepository transactionRepo;

        public VirtualWalletBo getVirtualWallet(Long walletId) {
            VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
            VirtualWalletBo walletBo = convert(walletEntity);
            return walletBo;
        }

        private VirtualWalletBo convert(VirtualWalletEntity walletEntity){
            return null;
        }

        public BigDecimal getBalance(Long walletId) {
            return walletRepo.getBalance(walletId);
        }

        public void debit(Long walletId, BigDecimal amount) {
            VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
            BigDecimal balance = walletEntity.getBalance();
            if (balance.compareTo(amount) < 0) {
                //抛出异常
            }
            walletRepo.updateBalance(walletId, balance.subtract(amount));
        }

        public void credit(Long walletId, BigDecimal amount) {
            VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
            BigDecimal balance = walletEntity.getBalance();
            walletRepo.updateBalance(walletId, balance.add(amount));
        }

        public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
            VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
            transactionEntity.setAmount(amount);
            transactionEntity.setCreateTime(System.currentTimeMillis());
            transactionEntity.setFromWalletId(fromWalletId);
            transactionEntity.setToWalletId(toWalletId);
            //TO_BE_EXECUTED -4
            transactionEntity.setStatus(-4);
            Long transactionId = transactionRepo.saveTransaction(transactionEntity);
            try {
                debit(fromWalletId, amount);
                credit(toWalletId, amount);
            }
//            catch (Exception e) { //抛出对应异常
//                // Status.CLOSED 状态默认为int -2
//                transactionRepo.updateStatus(transactionId, -2); //异常对应的操作
 //           }
            catch (Exception e) {
                // Status.FAILED 状态默认为int -1
                transactionRepo.updateStatus(transactionId, -1);
            }
            // Status.EXECUTED 状态默认为int 1-EXECUTED
            transactionRepo.updateStatus(transactionId, 1);
        }
}
