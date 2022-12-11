# 工程简介
服务gateway，作为提供业务服务的入口

# nacos本地docker安装(持久化存储)
1. docker pull nacos/nacos-server
2. 本地数据库安装并创建nacos_config库
3. 数据表建立，参考nacos_config.sql
4. docker run -it \
   -e PREFER_HOST_MODE=ip \
   -e MODE=standalone \
   -e SPRING_DATASOURCE_PLATFORM=mysql \
   -e MYSQL_SERVICE_HOST=127.0.0.1 \
   -e MYSQL_SERVICE_PORT=3306 \
   -e MYSQL_SERVICE_USER=root \
   -e MYSQL_SERVICE_PASSWORD=xxxx \
   -e MYSQL_SERVICE_DB_NAME=nacos_config \
   -p 8848:8848 \
   --name nacos-dev \
   --restart=always \
   nacos/nacos-server:latest

# nacos本地docker安装(非持久化存储)
docker run -d --name nacos-dev -p 8848:8848 -e PREFER_HOST_MODE=hostname -e MODE=standalone nacos/nacos-server

# 延伸阅读

