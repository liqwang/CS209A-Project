FROM centos:7.6.1810

RUN mkdir -p /www/quanquancho/nginx &&\
    cd /www/quanquancho/nginx &&\
    yum -y install wget vim &&\
    wget http://nginx.org/download/nginx-1.20.1.tar.gz

# 安装编译工具和库文件
RUN yum -y install make zlib zlib-devel gcc-c++ libtool openssl openssl-devel

# 解压Nginx
RUN cd /www/quanquancho/nginx &&\
    tar -zxvf nginx-1.20.1.tar.gz &&\
    mkdir -p /var/temp/nginx

# 手动配置安装
RUN cd /www/quanquancho/nginx/nginx-1.20.1 &&\
    ./configure \
    --prefix=/usr/local/nginx \
    --pid-path=/var/run/nginx.pid \
    --lock-path=/var/lock/nginx.lock \
    --error-log-path=/var/log/nginx/error.log \
    --http-log-path=/var/log/nginx/access.log \
    --with-http_gzip_static_module \
    --http-client-body-temp-path=/var/temp/nginx/client \
    --http-proxy-temp-path=/var/temp/nginx/proxy \
    --http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
    --http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
    --http-scgi-temp-path=/var/temp/nginx/scgi \
    --with-http_stub_status_module \
    --with-http_ssl_module

# 安装Nginx
RUN cd /www/quanquancho/nginx/nginx-1.20.1 &&\
    make install

# 配置环境变量
# vim /etc/profile
# 在文件末尾插入
# NGINX_HOME=/usr/local/nginx
# export PATH=$NGINX_HOME/sbin:$PATH
# 重启profile
# source /etc/profile

# nginx             启动Nginx
# nginx -s reload   重启Nginx
# nginx -s stop     关闭Nginx
