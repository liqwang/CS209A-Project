FROM openjdk:17
EXPOSE 8443
ADD backend-0.0.1-SNAPSHOT.jar app.jar
#通过修改软连接的方式,修改时区为东八区,从而使日志时间正确
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
ENTRYPOINT ["java","-jar","/app.jar"]
