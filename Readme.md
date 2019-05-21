###准备环境：
1. ActiveMQ
2. MySQL
3. C语言、C++、Python、Java中至少一个编译环境
4. judger.jar文件

###必要修改的配置：
1. MySQL导入exam.sql
2. 用压缩包的方式打开judger.jar，修改根目录的voj.properties
3. 打开ActiveMQ服务
4. 运行命令：java -jar judger.jar
5. 启动本项目（入口：KingdeeExamApplication.class）
6. 访问http://localhost:8080/loginPage（管理员账号admin/密码admin，考生账号user/密码admin）