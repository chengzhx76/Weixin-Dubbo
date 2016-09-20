# 环境部署文档（最好下载下来看，格式有点乱[没换行]）
---

## 安装JDK环境 

###1.先卸载open-jdk 

java –version 
rpm -qa | grep java 

rpm -qa | grep jdk //查看安装了哪些 要逐一卸载 

tzdata-java-2013g-1.el6.noarch 
java-1.6.0-openjdk-1.6.0.0-11.1.13.4.el6.x86_64 
java-1.7.0-openjdk-1.7.0.65-2.5.1.2.el6_5.x86_64 

如： 
rpm -e --nodeps tzdata-java-2014g-1.el6.noarch 
rpm -e --nodeps java-1.7.0-openjdk-1.7.0.65-2.5.1.2.el6_5.x86_64 
rpm -e --nodeps java-1.6.0-openjdk-1.6.0.0-11.1.13.4.el6.x86_64 

###2.开始安装： 
mkdir /usr/local/java // 创建JDK目录  

// FTP或SFTP上传jdk tar包 
tar -xvf jdk-7u71-linux-i586.tar.gz 
yum install glibc.i686 
  
###3.配置环境变量 

①vi /etc/profile 
 
②在末尾行添加 
#set java environment 
JAVA_HOME=/usr/local/java/jdk1.7.0_45
CLASSPATH=.:$JAVA_HOME/lib.tools.jar 
PATH=$JAVA_HOME/bin:$PATH
export JAVA_HOME CLASSPATH PATH
或： 
export JAVA_HOME=/usr/local/java/jdk1.7.0_45
export JRE_HOME=$JAVA_HOME/jre 
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib:$CLASSPATH 
export PATH=$JAVA_HOME/bin:$PATH 

保存退出 
③source /etc/profile  使更改的配置立即生效 
④java -version  查看JDK版本信息，如果显示出1.7.0证明成功 

---

## 安装MYSQL 

###1.卸载掉原有mysql 

rpm -qa | grep mysql　　// 这个命令就会查看该操作系统上是否已经安装了mysql数据库 

// 有的话，我们就通过 rpm -e 命令 或者 rpm -e --nodeps 命令来卸载掉 
rpm -e mysql　　// 普通删除模式 
rpm -e --nodeps mysql　　// 强力删除模式，如果使用上面命令删除时，提示有依赖的其它文件，则用该命令可以对其进行强力删除 
// 在删除完以后我们可以通过 rpm -qa | grep mysql 命令来查看mysql是否已经卸载成功！！ 

###2.通过yum来进行mysql的安装 
yum list | grep mysql 

// 安装mysql mysql-server mysql-devel 
yum install -y mysql-server mysql mysql-deve 

// 查看刚安装好的mysql-server的版本 
rpm -qi mysql-server 

###3.mysql数据库的初始化及相关配置 

// 启动Mysql服务 
service mysqld start 

// 查看是否开机启动 
chkconfig --list | grep mysqld 
// 如果没启动 
chkconfig mysqld on 

// 为root账号设置密码 
mysqladmin -u root password 'new-password' 

// 登录MYSQL 
mysql -u root -p password 

允许root用户在任何地方进行远程登录，并具有所有库任何操作权限，具体操作如下：
在本机先使用root用户登录mysql：
mysql -u root -p"youpassword" 
进行授权操作：
mysql>GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'youpassword' WITH GRANT OPTION;
重载授权表：
FLUSH PRIVILEGES;
退出mysql数据库：
exit
 
乱码解决 
CentOS 6以上的版本：
vi /etc/my.cnf 
[mysqld] 下增加 
character-set-server=utf8 
重启
service mysqld restart 

--- 

##安装Redis 

###2.安装环境 
yum -y install cpp binutils glibc glibc-kernheaders glibc-common glibc-devel gcc make gcc-c++ libstdc++-devel tcl 

###2.创建目录 
mkdir -p /usr/local/redis 
cd /usr/local/redis 

###3.FTP或SFTP上传tar包&&安装 
tar -xvf redis-2.8.17.tar.gz 
cd redis-2.8.17 
make 
make test #这个就不要执行了，需要很长时间 
make install 

###4.修改配置文件 
vi /etc/redis.conf 
// 修改如下，默认为no(后台启动) 
daemonize yes 

// 添加密码 
requirepass passwd 
  
// 修改端口 
port 6677 

###5.启动 
redis-server ../redis.conf 
// 测试 
redis-cli 
redis-cli -p 6767 -a password // 如果修改了端口或者密码 

如： 
redis-server ../redis.conf  
redis-cli -h 127.0.0.1 -p 6767 -a password 
127.0.0.1:6767> keys * 
(empty list or set) 

// 查看状态 
ps -ef|grep redis 
root       854     1  0 18:56 ?        00:00:00 /usr/local/redis/redis-3.0.7/src/redis-server *:6767   

// 结束 
./redis-cli -p 6767 -a password shutdown 

---
 
##安装 Zookeeper 
解压：tar -zxvf zookeeper-3.4.6.tar.gz 
配置：进入conf目录重命名 mv zoo_sample.cfg zoo.cfg 
      修改zoo.cfg文件 dataDir=/usr/local/zookeeper/zookeeper-3.4.6/data 
启动：进入bin目录 
      ./zkServer.sh start 
      JMX enabled by default 
      Using config: /usr/local/zookeeper/zookeeper-3.4.6/bin/../conf/zoo.cfg 
      Starting zookeeper ... STARTED 
查看是否启动：进入bin目录 ./zkServer.sh status 
      [./zkServer.sh status 
      JMX enabled by default 
      Using config: /usr/local/zookeeper/zookeeper-3.4.6/bin/../conf/zoo.cfg 
      Mode: standalone 
 
停止：进入bin目录 ./zkServer.sh stop 
 
查看节点： 
./zkCli.sh 
ls / 
[zookeeper] 
 
1. 启动ZK服务:       sh bin/zkServer.sh start 
2. 查看ZK服务状态:   sh bin/zkServer.sh status 
3. 停止ZK服务:       sh bin/zkServer.sh stop 
4. 重启ZK服务:       sh bin/zkServer.sh restart


使用delete命令可以删除指定znode. 当该znode拥有子znode时, 必须先删除其所有子znode, 否则操作将失败. 
rmr命令可用于代替delete命令, rmr是一个递归删除命令, 如果发生指定节点拥有子节点时, rmr命令会首先删除子节点. 


##安装RabbitMQ 

###1.安装Erlang 

cd /usr/local/ 
mkdir rabbitmq 
cd rabbitmq 

或者：
上传esl-erlang_17.3-1~centos~6_amd64.rpm 
执行yum install esl-erlang_17.3-1~centos~6_amd64.rpm 
 
上传：esl-erlang-compat-R14B-1.el6.noarch.rpm 
yum install esl-erlang-compat-R14B-1.el6.noarch.rpm 

###2.安装RabbitMQ 

上传rabbitmq-server-3.4.1-1.noarch.rpm 
安装：
rpm -ivh rabbitmq-server-3.4.1-1.noarch.rpm 

###3.启动、停止 

service rabbitmq-server start 
service rabbitmq-server stop 
service rabbitmq-server restart 

###4.设置开机启动 

chkconfig rabbitmq-server on 

###5.设置配置文件 

cd /etc/rabbitmq 
cp /usr/share/doc/rabbitmq-server-3.4.1/rabbitmq.config.example /etc/rabbitmq/  

mv rabbitmq.config.example rabbitmq.config 

###6.开启用户远程访问 
vi /etc/rabbitmq/rabbitmq.config 
%%{loopback_users, []},修改为 {loopback_users, []} 

###7.开启web界面管理工具 

rabbitmq-plugins enable rabbitmq_management 
service rabbitmq-server restart 

###8.防火墙开放15672端口 

/sbin/iptables -I INPUT -p tcp --dport 15672 -j ACCEPT 
/sbin/iptables -I INPUT -p tcp --dport 5672 -j ACCEPT 
/etc/rc.d/init.d/iptables save

---

##安装Tomcat 

###1.创建目录 

cd /usr/local/ 
mkdir web 
cd web 

### 2.安装 
tar -zxvf apache-tomcat-7.0.61.tar.gz // 解压压缩包 

### 3.设置环境变量 
vim /etc/profile  文件后面加入（千万不要有空格） 

export CATALINA_BASE=/usr/local/cheng/web/apache-tomcat-7.0.61
export TOMCAT_HOME=/usr/local/cheng/web/apache-tomcat-7.0.61


保存，退出，然后运行： 
source /etc/profile // 使profile生效 

### 4.启动 
// 进入bin目录启动tomcat 
./startup.sh 
