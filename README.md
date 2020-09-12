# 超市管理系统
## 系统截图
![avatar](https://raw.githubusercontent.com/lianggh98/MarkdownPhotos/master/Supermarker/Login.png)
## 详细介绍
### [CSDN介绍跳转](https://blog.csdn.net/qq_43374880/article/details/107440302)
    由于学校的实训安排,每个人必须使用JavaGUi来设计一个简单的操作管理系统,拥有增删改除
    也由于Swing的年代久远,在网上根据资料找到了,JavaFX这一GUI 由于国内对于这一技术的实现非常的少,有条件的可以去外网上详细的了解已经查阅一些资料.


    本次选题,抽中了超市这个非常庞大的管理系统,数据库的设计也是非常的难上加难
#### 遇到的困难

- 数据库的设计
- JavaFx的资料特别少
- 各大框架的灵运用
    - 协调分配
- 多线程的操作


## 环境依赖
- JavaFX
- Spring
- Mybatis
- Js
  - Char.js
  - Jquery.js
- Mysql 8.0.19
 ----

## 功能
- 基本数据的增删改除操作
- 数据的图形表显示
---
## 使用步骤
-   克隆代码
- IDEA打开
- 配置好本地的Maven
- 运行.sql到本地数据库
- java
    - Main
        - Start
            - 运行

### 数据库的版本由于每个人的都不一样
    我使用的是 Mysql 8.0.19
    如果不一样请在 请修改pom后
    在修改 resource 
            Mybatis
                MySQLConnection.properties 里面的配置
---
## 版本更新
- [x] V0.1
  - 基本的操作


- [x] V0.2
    - 修改了整体的布局
    - 整合了SpringMybatis
    - 某些地方使用了多线程,加快了读取速度
  
- [x] V0.3
  - 账号密码修改
  -  部门的增加删除
  -  商品类别的设置
  -  仓库的设置
  -  进货商设置

- [x] V0.4
  - 图表的显示

- [x] V0.5 等待
---
## 待解决[自我认为~~]
-   自动递增数据的id号
-   解决代码的臃肿
-   重新思考整个系统的数据库的结构
- 某些配置写入本地,而在从数据库里面读取
    - 部门
    - 职位
    - 仓库
- 每次结束后读取一次基础数据并且写入本地配置文件
---


