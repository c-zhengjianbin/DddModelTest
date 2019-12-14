# DddModelTest
 设计原则、设计模式理论与实践
 
 
 # MySpring
 
 ## [一、项目介绍](#41)
 * ### ☘️目的:
      * 将设计原则、设计模式用做最佳实践
 
 * ### ☘️目录:
      * 项目结构与包名注释🌴。
     ```    
        ├── DddTestApplication.java
        ├── anemicdomainmodel-----贫血模型
        │   ├── controller
        │   │   └── VirtualWalletController.java
        │   ├── dto
        │   │   └── VirtualWalletBo.java
        │   ├── entity
        │   │   ├── VirtualWalletEntity.java
        │   │   └── VirtualWalletTransactionEntity.java
        │   ├── repository
        │   │   ├── VirtualWalletRepository.java
        │   │   └── VirtualWalletTransactionRepository.java
        │   └── service
        │       └── VirtualWalletService.java
        ├── ddddomainmodel-----充血模型(领域驱动模型设计)
        └── designprinciples-----开闭原则最佳实践
            └── openandclose
                ├── Main.java
                ├── newversion
                │   ├── Alert.java
                │   ├── AlertHandler.java
                │   ├── ApiStatInfo.java
                │   ├── ApplicationContext.java
                │   ├── ErrorAlertHandler.java
                │   ├── TimeoutHandler.java
                │   └── TpsAlertHandler.java
                └── oldversion
                    ├── Alert.java
                    ├── AlertRule.java
                    └── Notification.java
             
     ```