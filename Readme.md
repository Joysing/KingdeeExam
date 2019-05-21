###准备环境：
1. ActiveMQ
2. MySQL
3. C语言、C++、Python、Java中至少一个编译环境
4. judger.jar文件

###搭建步骤
1. ActiveMQ的下载安装
    * 进入http://www.apache.org/dyn/closer.cgi?filename=/activemq/5.15.9/apache-activemq-5.15.9-bin.zip&action=download下载apache-activemq-5.15.9-bin.zip
    * 解压apache-activemq-5.15.9-bin.zip到随意文件夹
    * 双击bin目录下的activemq.bat进行启动
    * 启动完成后登录http://localhost:8161/admin 账号密码都默认admin
    * 点击菜单 Queues 添加一个名为 vojJudgeResultQueue 的Queue
    * 同样地，添加一个名为 vojSubmissionTaskQueue 的Queue
    * 至此，ActiveMQ配置完成。

2. MySQL的安装不做详述，MySQL安装完成后导入新建数据库exam导入exam.sql。
3. 编译机配置：用压缩包的方式打开judger.jar，修改根目录的voj.properties文件，需要修改的数据有：
    * MySQL连接、账号、密码
    * 登录Windows系统的账号、密码（必须是当前登录的用户，因为运行测试需要创建进程）
4. 启动编译机：运行命令：java -jar judger.jar

###上述所有项配置完成后，本系统才能正常启动：

1. 启动本项目（入口：KingdeeExamApplication.class）
2. 访问http://localhost:8080/loginPage（管理员账号admin/密码admin，考生账号user/密码admin）